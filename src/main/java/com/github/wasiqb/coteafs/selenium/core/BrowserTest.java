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
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.BROWSER;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * @author wasiqb
 * @since Sep 13, 2018 9:54:10 PM
 */
public class BrowserTest {
	private Browser browser;

	/**
	 * @author wasiqb
	 * @since Sep 13, 2018 9:55:41 PM
	 * @param browserName
	 *     Browser name
	 */
	@Parameters (BROWSER)
	@BeforeTest (alwaysRun = true)
	public void setupTest (@Optional final String browserName) {
		this.browser = new Browser ();
		this.browser.setBrowserUnderTest (browserName);
		this.browser.start ();
	}

	/**
	 * @author wasiqb
	 * @since Mar 21, 2019 6:46:47 PM
	 * @param result
	 *     test result
	 */
	@AfterMethod (alwaysRun = true)
	public void teardownMethod (final ITestResult result) {
		final boolean screenshotOnError = appSetting ().getPlayback ()
			.getScreenshot ()
			.isCaptureOnError ();
		if (screenshotOnError && result.getStatus () == ITestResult.FAILURE
			&& !this.browser.isRunning ()) {
			this.browser.perform ()
				.attachScreenshot ();
		}
	}

	/**
	 * @author wasiqb
	 * @since Sep 13, 2018 9:57:12 PM
	 */
	@AfterTest (alwaysRun = true)
	public void teardownTest () {
		this.browser.stop ();
	}
}