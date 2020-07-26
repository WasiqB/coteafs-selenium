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

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.handleError;
import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.FILTER_PKG;
import static com.google.common.truth.Truth.assertThat;
import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import static org.apache.commons.io.FileUtils.copyFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.github.wasiqb.coteafs.logger.Loggy;
import com.github.wasiqb.coteafs.selenium.config.ScreenshotSetting;
import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.driver.IScreenAction;
import com.google.common.truth.StringSubject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @param <D>
 *
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 */
public class ScreenAction<D extends WebDriver> extends BaseDriverAction<D> implements IScreenAction, IDriverActions<D> {
    private static final Loggy LOG = Loggy.init ();

    protected static void pause (final long delay) {
        try {
            sleep (delay);
        } catch (final InterruptedException e) {
            LOG.e ("Error while pausing: {}", e.getMessage ());
            currentThread ().interrupt ();
        }
    }

    ScreenAction (final D driver) {
        super (driver);
    }

    @Override
    public byte[] attachScreenshot () {
        return get (d -> ((RemoteWebDriver) d).getScreenshotAs (OutputType.BYTES));
    }

    @Override
    public File saveScreenshot () {
        final ScreenshotSetting setting = appSetting ().getPlayback ()
            .getScreenshot ();
        final String path = setting.getPath ();
        final String prefix = setting.getPrefix ();
        final SimpleDateFormat date = new SimpleDateFormat ("yyyyMMdd-HHmmss");
        final String timeStamp = date.format (Calendar.getInstance ()
            .getTime ());
        final String fileName = "%s/%s-%s.%s";
        return saveScreenshot (format (fileName, path, prefix, timeStamp, "jpeg"));
    }

    @Override
    public File saveScreenshot (final String path) {
        final String msg = "Capturing screenshot and saving at [{}]...";
        LOG.i (msg, path);
        try {
            final File source = ((TakesScreenshot) this.driver).getScreenshotAs (OutputType.FILE);
            final File destination = new File (path);
            copyFile (source, destination);
            return destination;
        } catch (final IOException e) {
            LOG.e ("Error while saving screenshot.", e);
            handleError (FILTER_PKG, e).forEach (LOG::e);
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.github.wasiqb.coteafs.selenium.core.driver.IScreenAction#startRecording()
     */
    @Override
    public void startRecording () {
        try {
            CustomScreenRecorder.startRecording ();
        } catch (final Exception e) {
            handleError (FILTER_PKG, e).forEach (LOG::e);
        }
    }

    /*
     * (non-Javadoc)
     * @see @see
     * com.github.wasiqb.coteafs.selenium.core.driver.IScreenAction#stopRecording()
     */
    @Override
    public void stopRecording () {
        try {
            CustomScreenRecorder.stopRecording ();
        } catch (final Exception e) {
            handleError (FILTER_PKG, e).forEach (LOG::e);
        }
    }

    @Override
    public String title () {
        return get (WebDriver::getTitle);
    }

    @Override
    public StringSubject verifyTitle () {
        return assertThat (title ());
    }
}