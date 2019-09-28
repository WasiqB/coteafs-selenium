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
import static com.github.wasiqb.coteafs.selenium.core.enums.Platform.DESKTOP;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.function.Consumer;

import com.github.wasiqb.coteafs.selenium.config.DelaySetting;
import com.github.wasiqb.coteafs.selenium.config.PlaybackSetting;
import com.github.wasiqb.coteafs.selenium.config.ScreenResolution;
import com.github.wasiqb.coteafs.selenium.constants.OS;
import com.github.wasiqb.coteafs.selenium.core.driver.IDriver;
import com.github.wasiqb.coteafs.selenium.core.enums.Platform;
import com.github.wasiqb.coteafs.selenium.core.enums.ScreenState;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Wasiq Bhamla
 * @param <D>
 * @since 26-Jul-2019
 */
public abstract class AbstractDriver<D extends WebDriver> extends PlatformAction implements IDriver<D> {
    private static final Logger LOG = LogManager.getLogger (AbstractDriver.class);

    /**
     * @param platform target platform
     * @author Wasiq Bhamla
     * @since 26-Jul-2019
     */
    protected AbstractDriver (final Platform platform) {
        super (platform, OS.platform ());
    }

    @Override
    public boolean isRunning () {
        return ((RemoteWebDriver) getDriver ()).getSessionId () != null;
    }

    protected void setupDriverOptions () {
        final PlaybackSetting playback = appSetting ().getPlayback ();
        final DelaySetting delays = playback.getDelays ();
        manageTimeouts (t -> t.pageLoadTimeout (delays.getPageLoad (), SECONDS));
        manageTimeouts (t -> t.setScriptTimeout (delays.getScriptLoad (), SECONDS));
        manageTimeouts (t -> t.implicitlyWait (delays.getImplicit (), SECONDS));
        manageOptions (Options::deleteAllCookies);
        setScreenSize (playback);
    }

    private void manageOptions (final Consumer<Options> options) {
        options.accept (getDriver ().manage ());
    }

    private void manageTimeouts (final Consumer<Timeouts> timeouts) {
        timeouts.accept (getDriver ().manage ()
            .timeouts ());
    }

    private void manageWindow (final Consumer<Window> window) {
        window.accept (getDriver ().manage ()
            .window ());
    }

    private void setScreenSize (final PlaybackSetting playback) {
        final ScreenState state = playback.getScreenState ();
        if (getPlatform () == DESKTOP) {
            LOG.info ("Setting screen size of Browser to {}...", state);
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
                    LOG.info ("Setting screen resolution to [{}]...", resolution);
                    manageWindow (w -> w.setSize (new Dimension (resolution.getWidth (), resolution.getHeight ())));
                    break;
            }
        }
    }
}