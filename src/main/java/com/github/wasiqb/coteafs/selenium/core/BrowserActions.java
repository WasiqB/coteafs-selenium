/*
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
import static java.time.Duration.ofSeconds;
import static org.apache.commons.io.FileUtils.copyFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.wasiqb.coteafs.selenium.config.ScreenshotSetting;
import com.github.wasiqb.coteafs.selenium.core.driver.IWebDriverActions;
import com.github.wasiqb.coteafs.selenium.core.enums.AlertDecision;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since Aug 18, 2018 4:41:56 PM
 */
public class BrowserActions implements IWebDriverActions {
	private static final Logger			LOG	= LogManager.getLogger (BrowserActions.class);

	private final EventFiringWebDriver	driver;
	private final WebDriverWait			wait;

	/**
	 * @author Wasiq Bhamla
	 * @since 02-Jun-2019
	 * @param driver
	 */
	public BrowserActions (final EventFiringWebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (driver, ofSeconds (appSetting ().getPlayback ()
			.getDelays ()
			.getExplicit ()));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#alert(com.github.
	 * wasiqb.coteafs.selenium.core.ext.AlertDecision)
	 */
	@Override
	public String alert (final AlertDecision decision) {
		final Alert alert = this.wait.until (ExpectedConditions.alertIsPresent ());
		String message = null;
		if (alert != null) {
			message = alert.getText ();
			if (decision == AlertDecision.ACCEPT) {
				alert.accept ();
			}
			else {
				alert.dismiss ();
			}
		}
		return message;
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#saveScreenshot()
	 */
	@Override
	public byte [] attachScreenshot () {
		return get (
			d -> ((RemoteWebDriver) d.getWrappedDriver ()).getScreenshotAs (OutputType.BYTES));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#back()
	 */
	@Override
	public void back () {
		perform (d -> d.navigate ()
			.back ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#deleteCookies()
	 */
	@Override
	public void deleteCookies () {
		perform (d -> d.manage ()
			.deleteAllCookies ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#driverWait()
	 */
	@Override
	public WebDriverWait driverWait () {
		return this.wait;
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#execute(java.lang.
	 * String)
	 */
	@SuppressWarnings ("unchecked")
	@Override
	public <T> T execute (final String script, final Object... args) {
		return (T) get (
			d -> ((RemoteWebDriver) d.getWrappedDriver ()).executeScript (script, args));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#forward()
	 */
	@Override
	public void forward () {
		perform (d -> d.navigate ()
			.forward ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#navigateTo(java
	 * .lang.String)
	 */
	@Override
	public void navigateTo (final String url) {
		perform (d -> d.navigate ()
			.to (url));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#refresh()
	 */
	@Override
	public void refresh () {
		perform (d -> d.navigate ()
			.refresh ());
	}

	@Override
	public void saveScreenshot () {
		final ScreenshotSetting setting = appSetting ().getPlayback ()
			.getScreenshot ();
		final String path = setting.getPath ();
		final String prefix = setting.getPrefix ();
		final SimpleDateFormat date = new SimpleDateFormat ("yyyyMMdd-HHmmss");
		final String timeStamp = date.format (Calendar.getInstance ()
			.getTime ());
		final String fileName = "%s/%s-%s.%s";
		saveScreenshot (format (fileName, path, prefix, timeStamp, "jpeg"));
	}

	@Override
	public void saveScreenshot (final String path) {
		final String msg = "Capturing screenshot and saving at [{}]...";
		LOG.info (msg, path);
		try {
			final File srcFiler = this.driver.getScreenshotAs (OutputType.FILE);
			copyFile (srcFiler, new File (path));
		}
		catch (IOException e) {
			LOG.error ("Error while saving screenshot.", e);
			LOG.catching (e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.driver.IWebFrame#switchFrame()
	 */
	@Override
	public void switchFrame () {
		switchFrame (0);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.driver.IWebFrame#switchFrame(int)
	 */
	@Override
	public void switchFrame (final int index) {
		perform (d -> d.switchTo ()
			.frame (index));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.driver.IWebFrame#switchFrame(java.
	 * lang.String)
	 */
	@Override
	public void switchFrame (final String nameOrId) {
		perform (d -> d.switchTo ()
			.frame (nameOrId));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#switchWindow()
	 */
	@Override
	public void switchWindow () {
		perform (d -> d.switchTo ()
			.defaultContent ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWebDriverActions#switchWindow(
	 * java.lang.String)
	 */
	@Override
	public void switchWindow (final String title) {
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
					.contains (title)) return;
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#title()
	 */
	@Override
	public String title () {
		return get (WebDriver::getTitle);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#verifyAlertMessage
	 * (com.github.wasiqb.coteafs.selenium.core.ext.AlertDecision)
	 */
	@Override
	public StringSubject verifyAlertMessage (final AlertDecision decision) {
		final String actual = alert (decision);
		return assertThat (actual);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IDriverActions#verifyTitle()
	 */
	@Override
	public StringSubject verifyTitle () {
		return assertThat (title ());
	}

	protected <E> E get (final Function <EventFiringWebDriver, E> func) {
		return func.apply (this.driver);
	}

	protected void perform (final Consumer <EventFiringWebDriver> action) {
		action.accept (this.driver);
	}

	EventFiringWebDriver driver () {
		return this.driver;
	}
}