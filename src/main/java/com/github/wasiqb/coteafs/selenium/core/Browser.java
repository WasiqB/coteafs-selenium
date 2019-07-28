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

import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.BROWSER;
import static com.github.wasiqb.coteafs.selenium.core.enums.Platform.DESKTOP;
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static io.github.bonigarcia.wdm.WebDriverManager.iedriver;
import static java.lang.System.getProperty;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.github.wasiqb.coteafs.selenium.constants.OS;
import com.github.wasiqb.coteafs.selenium.core.base.driver.AbstractDriver;
import com.github.wasiqb.coteafs.selenium.core.driver.IWebDriver;
import com.github.wasiqb.coteafs.selenium.core.enums.ApplicationType;
import com.github.wasiqb.coteafs.selenium.core.enums.AvailableBrowser;
import com.github.wasiqb.coteafs.selenium.listeners.DriverListner;

/**
 * @author Wasiq Bhamla
 * @since Aug 15, 2018 2:11:13 PM
 */
@SuppressWarnings ("unchecked")
public class Browser extends AbstractDriver <EventFiringWebDriver> implements IWebDriver {
	private static final Logger LOG = LogManager.getLogger (Browser.class);

	private static WebDriver setupChromeDriver () {
		LOG.info ("Setting up Chrome driver...");
		chromedriver ().setup ();
		final ChromeOptions chromeOptions = new ChromeOptions ();
		chromeOptions.addArguments ("--dns-prefetch-disable");
		if (appSetting ().isHeadlessMode ()) {
			chromeOptions.addArguments ("--headless");
		}
		chromeOptions.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		final ChromeDriverService chromeService = ChromeDriverService.createDefaultService ();
		return new ChromeDriver (chromeService, chromeOptions);
	}

	private static WebDriver setupDriver (final AvailableBrowser browser) {
		switch (browser) {
			case CHROME:
				return setupChromeDriver ();
			case FIREFOX:
				return setupFirefoxDriver ();
			case IE:
				return setupIeDriver ();
			case EDGE:
				return setupEdgeDriver ();
			case SAFARI:
			default:
				return setupSafariDriver ();
		}
	}

	private static WebDriver setupEdgeDriver () {
		LOG.info ("Setting up Edge driver...");
		edgedriver ().setup ();
		final EdgeOptions options = new EdgeOptions ();
		return new EdgeDriver (options);
	}

	private static WebDriver setupFirefoxDriver () {
		LOG.info ("Setting up Firefox driver...");
		firefoxdriver ().setup ();
		final DesiredCapabilities capabilities = new DesiredCapabilities ();
		final FirefoxOptions options = new FirefoxOptions (capabilities);
		final GeckoDriverService firefoxService = GeckoDriverService.createDefaultService ();
		return new FirefoxDriver (firefoxService, options);
	}

	private static WebDriver setupIeDriver () {
		LOG.info ("Setting up Internet Explorer driver...");
		iedriver ().setup ();
		final InternetExplorerOptions ieOptions = new InternetExplorerOptions ();
		ieOptions.destructivelyEnsureCleanSession ();
		ieOptions.setCapability ("requireWindowFocus", true);
		ieOptions.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
		final InternetExplorerDriverService ieService = InternetExplorerDriverService
			.createDefaultService ();
		if (!OS.isWindows ()) {
			Assert.fail ("IE is not supported.");
		}
		if (appSetting ().isHeadlessMode ()) {
			LOG.warn ("IE does not support headless mode. Hence, ignoring the same...");
		}
		return new InternetExplorerDriver (ieService, ieOptions);
	}

	private static WebDriver setupSafariDriver () {
		LOG.info ("Setting up Safari driver...");
		if (!OS.isMac ()) {
			Assert.fail ("Safari is not supported.");
		}
		if (appSetting ().isHeadlessMode ()) {
			LOG.warn ("Safari does not support Headless mode. Hence, ignoring the same...");
		}
		final SafariOptions options = new SafariOptions ();
		return new SafariDriver (options);
	}

	private String				browserName;
	private final DriverListner	listener;

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	public Browser () {
		super (DESKTOP);
		this.listener = new DriverListner ();
	}

	@Override
	public ApplicationType getApplicationType () {
		return ApplicationType.WEB;
	}

	@Override
	public BrowserActions perform () {
		return new BrowserActions (getDriver ());
	}

	@Override
	public void setBrowserUnderTest (final String browser) {
		this.browserName = browser;
	}

	@Override
	public void start () {
		LOG.info ("Starting the browser...");
		String target = this.browserName;
		if (target == null) {
			target = getProperty (BROWSER, appSetting ().getBrowser ()
				.name ());
		}
		final AvailableBrowser browser = AvailableBrowser.valueOf (target.toUpperCase ());
		final WebDriver driver = setupDriver (browser);
		final EventFiringWebDriver wd = new EventFiringWebDriver (driver);
		wd.register (this.listener);
		driver (wd);
		setupDriverOptions ();
	}

	@Override
	public void stop () {
		LOG.info ("Stopping the browser...");
		getDriver ().quit ();
		driver (null);
	}
}