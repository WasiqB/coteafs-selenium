/*
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.wasiqb.coteafs.selenium.core;

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.fail;
import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.BROWSER;
import static com.github.wasiqb.coteafs.selenium.core.base.driver.ParallelSession.close;
import static com.github.wasiqb.coteafs.selenium.core.base.driver.ParallelSession.getSession;
import static com.github.wasiqb.coteafs.selenium.core.base.driver.ParallelSession.setSession;
import static com.github.wasiqb.coteafs.selenium.core.enums.Platform.DESKTOP;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static io.github.bonigarcia.wdm.WebDriverManager.iedriver;
import static java.lang.System.getProperty;
import static java.text.MessageFormat.format;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.github.wasiqb.coteafs.logger.Loggy;
import com.github.wasiqb.coteafs.selenium.config.DriverSetting;
import com.github.wasiqb.coteafs.selenium.config.RemoteSetting;
import com.github.wasiqb.coteafs.selenium.constants.OS;
import com.github.wasiqb.coteafs.selenium.core.base.driver.AbstractDriver;
import com.github.wasiqb.coteafs.selenium.core.driver.IWebDriver;
import com.github.wasiqb.coteafs.selenium.core.enums.ApplicationType;
import com.github.wasiqb.coteafs.selenium.core.enums.AvailableBrowser;
import com.github.wasiqb.coteafs.selenium.core.enums.RemoteSource;
import com.github.wasiqb.coteafs.selenium.error.DriverNotSetupError;
import com.github.wasiqb.coteafs.selenium.listeners.DriverListner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

/**
 * @author Wasiq Bhamla
 * @since Aug 15, 2018 2:11:13 PM
 */
@SuppressWarnings("unchecked")
public class Browser extends AbstractDriver<EventFiringWebDriver> implements IWebDriver {
    private static final Loggy LOG = Loggy.init();
    private final DriverListner listener;
    private AvailableBrowser availableBrowser;
    private String browserName;

    /**
     * @author Wasiq Bhamla
     * @since 06-Jun-2019
     */
    public Browser() {
        super(DESKTOP);
        this.listener = new DriverListner();
    }

    private static WebDriver createRemoteSession(final RemoteSetting remoteSetting, final MutableCapabilities caps) {
        LOG.i("Creating remote session...");
        final StringBuilder urlBuilder = new StringBuilder(remoteSetting.getProtocol()
                .getPrefix());
        final String url = remoteSetting.getUrl();
        if (remoteSetting.getSource() != RemoteSource.GRID) {
            final String user = remoteSetting.getUserId();
            final String pass = remoteSetting.getPassword();
            if (isNotEmpty(user)) {
                urlBuilder.append(user)
                        .append(":")
                        .append(requireNonNull(pass, "Cloud Password cannot be empty."))
                        .append("@");
            }
        }
        urlBuilder.append(url);
        final int port = remoteSetting.getPort();
        if (port > 0) {
            urlBuilder.append(":")
                    .append(port);
        }
        urlBuilder.append("/wd/hub");
        try {
            final URL remoteUrl = new URL(urlBuilder.toString());
            return new RemoteWebDriver(remoteUrl, caps);
        } catch (final MalformedURLException e) {
            LOG.e("Error occurred while creating remote session: ", e);
        }
        return null;
    }

    private static WebDriver setupChromeDriver() throws MalformedURLException {
        LOG.i("Setting up Chrome driver...");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        setupDriver(chromedriver());
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--dns-prefetch-disable");
        if (appSetting().isHeadlessMode()) {
            chromeOptions.addArguments("--headless");
        }
        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        final ChromeDriverService chromeService = ChromeDriverService.createDefaultService();
        return new ChromeDriver(chromeService, chromeOptions);
    }

    private static void setupCloud(final RemoteSetting remoteSetting, final DesiredCapabilities caps,
                                   final String source) {
        final Map<String, Object> capabilities = remoteSetting.getCapabilities();
        capabilities.forEach(caps::setCapability);
        if (isNotEmpty(source)) {
            caps.setCapability(format("{0}:options", source), remoteSetting.getCloudCapabilities());
        }
    }

    private static WebDriver setupDriver(final AvailableBrowser browser) {
        try {
            switch (browser) {
                case CHROME:
                    return setupChromeDriver();
                case FIREFOX:
                    return setupFirefoxDriver();
                case IE:
                    return setupIeDriver();
                case EDGE:
                    return setupEdgeDriver();
                case SAFARI:
                    return setupSafariDriver();
                case REMOTE:
                default:
                    return setupRemote();
            }
        } catch (final MalformedURLException e) {
            LOG.e("URL is malformed.", e);
            LOG.c(e);
        }
        return null;
    }

    private static void setupDriver(final WebDriverManager manager) throws MalformedURLException {
        final DriverSetting driver = appSetting().getDriver();
        if (!isNull(driver)) {
            if (isNotEmpty(driver.getVersion())) {
                manager.version(driver.getVersion());
            }
            if (isNotEmpty(driver.getExeUrl())) {
                manager.driverRepositoryUrl(new URL(driver.getExeUrl()));
            }
            if (driver.isForceCache()) {
                manager.forceCache();
            }
            if (driver.isForceDownload()) {
                manager.forceDownload();
            }
            if (isNotEmpty(driver.getPath())) {
                manager.targetPath(driver.getPath());
            }
        }
        manager.setup();
    }

    private static WebDriver setupEdgeDriver() throws MalformedURLException {
        LOG.i("Setting up Edge driver...");
        setupDriver(edgedriver());
        final EdgeOptions options = new EdgeOptions();
        return new EdgeDriver(options);
    }

    private static WebDriver setupFirefoxDriver() throws MalformedURLException {
        LOG.i("Setting up Firefox driver...");
        setupDriver(firefoxdriver());
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        final FirefoxOptions options = new FirefoxOptions(capabilities);
        final GeckoDriverService firefoxService = GeckoDriverService.createDefaultService();
        return new FirefoxDriver(firefoxService, options);
    }

    private static WebDriver setupIeDriver() throws MalformedURLException {
        LOG.i("Setting up Internet Explorer driver...");
        setupDriver(iedriver());
        final InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.destructivelyEnsureCleanSession();
        ieOptions.setCapability("requireWindowFocus", true);
        ieOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        final InternetExplorerDriverService ieService = InternetExplorerDriverService.createDefaultService();
        if (!OS.isWindows()) {
            Assert.fail("IE is not supported.");
        }
        if (appSetting().isHeadlessMode()) {
            LOG.w("IE does not support headless mode. Hence, ignoring the same...");
        }
        return new InternetExplorerDriver(ieService, ieOptions);
    }

    private static WebDriver setupRemote() {
        LOG.i("Setting up Remote driver...");
        final RemoteSetting remoteSetting = appSetting().getRemote();
        final RemoteSource source = remoteSetting.getSource();
        final DesiredCapabilities caps = new DesiredCapabilities();
        switch (source) {
            case SAUCELABS:
                setupCloud(remoteSetting, caps, "sauce");
                break;
            case BROWSERSTACK:
                setupCloud(remoteSetting, caps, "bstack");
                break;
            case GRID:
            default:
                setupCloud(remoteSetting, caps, null);
                break;
        }
        return createRemoteSession(remoteSetting, caps);
    }

    private static WebDriver setupSafariDriver() {
        LOG.i("Setting up Safari driver...");
        if (!OS.isMac()) {
            Assert.fail("Safari is not supported.");
        }
        if (appSetting().isHeadlessMode()) {
            LOG.w("Safari does not support Headless mode. Hence, ignoring the same...");
        }
        final SafariOptions options = new SafariOptions();
        return new SafariDriver(options);
    }

    @Override
    public ApplicationType getApplicationType() {
        return ApplicationType.WEB;
    }

    @Override
    public EventFiringWebDriver getDriver() {
        return getSession().getDriver();
    }

    @Override
    public BrowserActions perform() {
        return new BrowserActions(getDriver());
    }

    @Override
    public void setBrowserUnderTest(final String browser) {
        this.browserName = browser;
    }

    @Override
    public void start() {
        LOG.i("Starting the browser...");
        String target = this.browserName;
        if (target == null) {
            target = getProperty(BROWSER, appSetting().getBrowser()
                    .name());
        }
        this.availableBrowser = AvailableBrowser.valueOf(target.toUpperCase());
        final WebDriver driver = setupDriver(this.availableBrowser);
        if (isNull(driver)) {
            fail(DriverNotSetupError.class, "Driver was not setup properly.");
        }
        final EventFiringWebDriver wd = new EventFiringWebDriver(driver);
        wd.register(this.listener);
        setSession(new BrowserSession(wd));
        setupDriverOptions();
        if (this.availableBrowser != AvailableBrowser.REMOTE) {
            perform().startRecording();
        } else {
            LOG.w("Video recording is disabled for Remote execution...");
        }
    }

    @Override
    public void stop() {
        LOG.i("Stopping the browser...");
        if (this.availableBrowser != AvailableBrowser.REMOTE) {
            perform().stopRecording();
        } else {
            LOG.w("Video recording is disabled for Remote execution...");
        }
        getDriver().unregister(this.listener);
        getSession().close();
        close();
    }
}