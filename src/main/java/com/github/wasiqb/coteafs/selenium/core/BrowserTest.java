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

import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.BROWSER;
import static com.github.wasiqb.coteafs.selenium.core.base.driver.ParallelSession.getBrowserSetting;

import java.io.File;

import com.github.wasiqb.coteafs.selenium.config.ScreenshotSetting;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger  LOG = LogManager.getLogger ();
    private              Browser browser;

    /**
     * @param browserName Browser setting name
     *
     * @author wasiqb
     * @since Sep 13, 2018 9:55:41 PM
     */
    @Parameters ({ BROWSER })
    @BeforeTest (alwaysRun = true)
    public void setupTest (@Optional final String browserName) {
        this.browser = new Browser ();
        this.browser.setBrowserSettingName (browserName);
        this.browser.start ();
    }

    /**
     * @param result test result
     *
     * @author wasiqb
     * @since Mar 21, 2019 6:46:47 PM
     */
    @AfterMethod (alwaysRun = true)
    public void tearDownMethod (final ITestResult result) {
        final ScreenshotSetting screenshotSetting = getBrowserSetting ().getPlayback ()
            .getScreenshot ();
        final boolean screenshotOnError = screenshotSetting.isCaptureOnError ();
        final boolean captureAll = screenshotSetting.isCaptureAll ();
        if (captureAll || screenshotOnError && result.getStatus () == ITestResult.FAILURE && this.browser.isRunning ()) {
            final File screenshot = this.browser.perform ()
                .saveScreenshot ();
            final Throwable cause = result.getThrowable ();
            if (cause != null) {
                LOG.error ("Test Failed: Screenshot captured at [{}]", screenshot.getPath ());
            } else {
                LOG.info ("Screenshot captured at path [{}]", screenshot.getPath ());
            }
        }
    }

    /**
     * @author wasiqb
     * @since Sep 13, 2018 9:57:12 PM
     */
    @AfterTest (alwaysRun = true)
    public void tearDownTest () {
        this.browser.stop ();
    }
}