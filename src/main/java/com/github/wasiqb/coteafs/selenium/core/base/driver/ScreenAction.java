/*
 * Copyright (c) 2019, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static java.lang.String.format;
import static org.apache.commons.io.FileUtils.copyFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.wasiqb.coteafs.selenium.config.ScreenshotSetting;
import com.github.wasiqb.coteafs.selenium.core.driver.IScreenAction;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <D>
 */
public class ScreenAction <D extends WebDriver> extends ScriptAction <D> implements IScreenAction {
	private static final Logger LOG = LogManager.getLogger (AbstractDriverAction.class);

	ScreenAction (final D driver) {
		super (driver);
	}

	@Override
	public byte [] attachScreenshot () {
		return get (d -> ((RemoteWebDriver) d).getScreenshotAs (OutputType.BYTES));
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
			final File srcFiler = ((TakesScreenshot) this.driver).getScreenshotAs (OutputType.FILE);
			copyFile (srcFiler, new File (path));
		}
		catch (final IOException e) {
			LOG.error ("Error while saving screenshot.", e);
			LOG.catching (e);
		}
	}
}