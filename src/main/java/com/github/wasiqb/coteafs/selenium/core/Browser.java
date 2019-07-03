/**
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
import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.edgedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;
import static io.github.bonigarcia.wdm.WebDriverManager.iedriver;
import static java.lang.System.getProperty;

import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
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
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.github.wasiqb.coteafs.selenium.config.DelaySetting;
import com.github.wasiqb.coteafs.selenium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.selenium.config.ScreenResolution;
import com.github.wasiqb.coteafs.selenium.constants.OS;
import com.github.wasiqb.coteafs.selenium.core.driver.IWebDriver;
import com.github.wasiqb.coteafs.selenium.core.enums.ApplicationType;
import com.github.wasiqb.coteafs.selenium.core.enums.AvailableBrowser;
import com.github.wasiqb.coteafs.selenium.core.enums.Platform;
import com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs;
import com.github.wasiqb.coteafs.selenium.core.enums.ScreenState;
import com.github.wasiqb.coteafs.selenium.listeners.DriverListner;

/**
 * @author Wasiq Bhamla
 * @since Aug 15, 2018 2:11:13 PM
 */
public class Browser implements IWebDriver {
	private static final ThreadLocal <EventFiringWebDriver>	driverThread	= new ThreadLocal <> ();
	private static final Logger								log				= LogManager
		.getLogger (Browser.class);

	private static WebDriver setupChromeDriver () {
		log.info ("Setting up Chrome driver...");
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
			default:
				return setupEdgeDriver ();
		}
	}

	private static WebDriver setupEdgeDriver () {
		log.info ("Setting up Edge driver...");
		edgedriver ().setup ();
		final EdgeOptions options = new EdgeOptions ();
		return new EdgeDriver (options);
	}

	private static WebDriver setupFirefoxDriver () {
		log.info ("Setting up Firefox driver...");
		firefoxdriver ().setup ();
		final DesiredCapabilities capabilities = new DesiredCapabilities ();
		final FirefoxOptions options = new FirefoxOptions (capabilities);
		final GeckoDriverService firefoxService = GeckoDriverService.createDefaultService ();
		return new FirefoxDriver (firefoxService, options);
	}

	private static WebDriver setupIeDriver () {
		log.info ("Setting up Internet Explorer driver...");
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
			Assert.fail (
				"Internet Explorer can not run in headless mode, Set Headless setting to false in config.yaml");
		}
		return new InternetExplorerDriver (ieService, ieOptions);
	}

	private String				browserName;
	private final DriverListner	listener;

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	public Browser () {
		this.listener = new DriverListner ();
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriver#getApplicationType()
	 */
	@Override
	public ApplicationType getApplicationType () {
		return ApplicationType.WEB;
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriver#getDriver()
	 */
	@Override
	public EventFiringWebDriver getDriver () {
		return driverThread.get ();
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriver#getPlatform()
	 */
	@Override
	public Platform getPlatform () {
		return Platform.DESKTOP;
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriver#getPlatformOs()
	 */
	@Override
	public PlatformOs getPlatformOs () {
		return OS.platform ();
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriver#interact()
	 */
	@SuppressWarnings ("unchecked")
	@Override
	public BrowserActions perform () {
		return new BrowserActions (getDriver ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriver#setBrowserUnderTest(
	 * com.github.wasiqb.coteafs.selenium.config.AvailableBrowser)
	 */
	@Override
	public void setBrowserUnderTest (final String browser) {
		this.browserName = browser;
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriver#start()
	 */
	@Override
	public void start () {
		log.info ("Starting the browser...");
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

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriver#stop()
	 */
	@Override
	public void stop () {
		log.info ("Stopping the browser...");
		getDriver ().quit ();
		driver (null);
	}

	private void manageOptions (final Consumer <Options> options) {
		options.accept (getDriver ().manage ());
	}

	private void manageTimeouts (final Consumer <Timeouts> timeouts) {
		timeouts.accept (getDriver ().manage ()
			.timeouts ());
	}

	private void manageWindow (final Consumer <Window> window) {
		window.accept (getDriver ().manage ()
			.window ());
	}

	private void setScreenSize (final PlaybackSetting playback) {
		final ScreenState state = playback.getScreenState ();
		log.info ("Setting screen size of Browser to {}...", state);
		switch (state) {
			case FULL_SCREEN:
				manageWindow (Window::fullscreen);
				break;
			case MAXIMIZED:
				manageWindow (Window::maximize);
				break;
			case NORMAL:
			default:
				final ScreenResolution resolution = playback.getScreenResolution ();
				log.info ("Setting screen resolution to [{}]...", resolution);
				manageWindow (w -> w
					.setSize (new Dimension (resolution.getWidth (), resolution.getHeight ())));
				break;
		}
	}

	private void setupDriverOptions () {
		final PlaybackSetting playback = appSetting ().getPlayback ();
		final DelaySetting delays = playback.getDelays ();
		manageTimeouts (t -> t.pageLoadTimeout (delays.getPageLoad (), TimeUnit.SECONDS));
		manageTimeouts (t -> t.setScriptTimeout (delays.getScriptLoad (), TimeUnit.SECONDS));
		manageTimeouts (t -> t.implicitlyWait (delays.getImplicit (), TimeUnit.SECONDS));
		manageOptions (Options::deleteAllCookies);
		setScreenSize (playback);
	}

	protected void driver (final EventFiringWebDriver driver) {
		driverThread.set (driver);
	}
}