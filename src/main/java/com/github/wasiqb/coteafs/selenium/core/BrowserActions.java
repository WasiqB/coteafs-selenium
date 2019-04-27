/**
 * Copyright (c) 2017 - 2020, Wasiq Bhamla.
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
import static com.google.common.truth.Truth.assertThat;
import static java.lang.String.format;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since Aug 18, 2018 4:41:56 PM
 */
public class BrowserActions {
	private static final Logger log = LogManager.getLogger (BrowserActions.class);

	private final EventFiringWebDriver	driver;
	private final WebDriverWait			wait;

	/**
	 * @author Wasiq Bhamla
	 * @param driver
	 * @since Aug 18, 2018 4:41:56 PM
	 */
	public BrowserActions (final EventFiringWebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (driver, appSetting ().getPlayback ()
			.getDelays ()
			.getExplicit ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:07:46 PM
	 * @return message
	 */
	public String acceptAlert () {
		final Alert alert = this.wait.until (ExpectedConditions.alertIsPresent ());
		String message = null;
		if (alert != null) {
			message = alert.getText ();
			alert.accept ();
		}
		return message;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:09:37 PM
	 */
	public void back () {
		perform (d -> d.navigate ()
			.back ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:07:23 PM
	 */
	public void deleteCookies () {
		perform (d -> d.manage ()
			.deleteAllCookies ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:04:47 PM
	 * @return message
	 */
	public String dismissAlert () {
		final Alert alert = this.wait.until (ExpectedConditions.alertIsPresent ());
		String message = StringUtils.EMPTY;
		if (alert != null) {
			message = alert.getText ();
			alert.dismiss ();
		}
		return message;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:04:13 PM
	 * @return wait
	 */
	public WebDriverWait driverWait () {
		return this.wait;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 6:13:46 PM
	 * @param script
	 * @param args
	 * @return output
	 */
	@SuppressWarnings ("unchecked")
	public <E> E executeScript (final String script, final Object... args) {
		return (E) get (d -> d.executeScript (script, args));
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:09:56 PM
	 */
	public void forward () {
		perform (d -> d.navigate ()
			.forward ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:03:36 PM
	 * @return is closed
	 */
	public boolean isClosed () {
		return get (d -> ((RemoteWebDriver) d.getWrappedDriver ()).getSessionId () == null);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:08:41 PM
	 * @param url
	 */
	public void navigateTo (final String url) {
		perform (d -> d.navigate ()
			.to (url));
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 5:09:14 PM
	 */
	public void refresh () {
		perform (d -> d.navigate ()
			.refresh ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 4:59:27 PM
	 * @return screenshot
	 */
	public byte [] saveScreenshot () {
		return get (d -> ((TakesScreenshot) d).getScreenshotAs (OutputType.BYTES));
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 22, 2018 2:45:55 PM
	 * @param filePath
	 */
	public void saveScreenshot (final String filePath) {
		final File screenshot = get (d -> ((TakesScreenshot) d).getScreenshotAs (OutputType.FILE));
		try {
			log.info (format ("Saving screenshot to file: %s...", filePath));
			FileUtils.copyFile (screenshot, new File (filePath));
		}
		catch (final IOException e) {
			log.error (format ("Error while saving screenshot to file: %s", filePath));
			log.catching (e);
		}
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 4:58:54 PM
	 */
	public void switchToMain () {
		perform (d -> d.switchTo ()
			.defaultContent ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 4:55:09 PM
	 * @param title
	 */
	public void switchToWindow (final String title) {
		perform (d -> {
			final String currentHandle = d.getWindowHandle ();
			final Set <String> wins = d.getWindowHandles ();
			for (final String win : wins) {
				if (currentHandle.equals (win)) {
					continue;
				}
				final WebDriver w = d.switchTo ()
					.window (win);
				if (w.getTitle ()
					.contains (title)) { return; }
			}
		});
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 4:54:38 PM
	 * @return title
	 */
	public String title () {
		return get (WebDriver::getTitle);
	}

	/**
	 * @author wasiqb
	 * @since Apr 15, 2019 8:43:28 PM
	 * @return string subject
	 */
	public StringSubject verifyAcceptedAlertMessage () {
		final String actual = acceptAlert ();
		return assertThat (actual);
	}

	/**
	 * @author wasiqb
	 * @since Apr 15, 2019 8:44:10 PM
	 * @return string subject
	 */
	public StringSubject verifyDismissedAlertMessage () {
		final String actual = dismissAlert ();
		return assertThat (actual);
	}

	EventFiringWebDriver driver () {
		return this.driver;
	}

	private <E> E get (final Function <EventFiringWebDriver, E> func) {
		return func.apply (this.driver);
	}

	private void perform (final Consumer <EventFiringWebDriver> action) {
		action.accept (this.driver);
	}
}