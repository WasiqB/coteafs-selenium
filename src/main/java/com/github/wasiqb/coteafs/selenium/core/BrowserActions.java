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

import java.util.Set;

import com.github.wasiqb.coteafs.selenium.config.ConfigUtil;
import com.github.wasiqb.coteafs.selenium.config.DelaySetting;
import com.github.wasiqb.coteafs.selenium.core.base.driver.WebDriverAction;
import com.github.wasiqb.coteafs.selenium.core.driver.IWebFrame;
import com.github.wasiqb.coteafs.selenium.core.driver.IWebWindow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author Wasiq Bhamla
 * @since Aug 18, 2018 4:41:56 PM
 */
public class BrowserActions extends WebDriverAction<EventFiringWebDriver> implements IWebFrame, IWebWindow {
    private final DelaySetting delaySetting;

    /**
     * @author Wasiq Bhamla
     * @since 02-Jun-2019
     * @param driver driver
     */
    BrowserActions (final EventFiringWebDriver driver) {
        super (driver);
        this.delaySetting = ConfigUtil.appSetting ()
            .getPlayback ()
            .getDelays ();
    }

    @Override
    public void switchFrame () {
        switchFrame (0);
    }

    @Override
    public void switchFrame (final int index) {
        perform (d -> {
            d.switchTo ()
                .frame (index);
            pause (this.delaySetting.getAfterFrameSwitch ());
        });
    }

    @Override
    public void switchFrame (final String nameOrId) {
        perform (d -> {
            d.switchTo ()
                .frame (nameOrId);
            pause (this.delaySetting.getAfterFrameSwitch ());
        });
    }

    @Override
    public void switchWindow () {
        perform (d -> {
            d.switchTo ()
                .defaultContent ();
            pause (this.delaySetting.getAfterWindowSwitch ());
        });
    }

    @Override
    public void switchWindow (final String title) {
        perform (d -> {
            final String currentHandle = d.getWindowHandle ();
            final Set<String> wins = d.getWindowHandles ();
            for (final String win : wins) {
                if (currentHandle.equals (win)) {
                    continue;
                }
                final WebDriver w = d.switchTo ()
                    .window (win);
                if (w.getTitle ()
                    .contains (title)) {
                    return;
                }
            }
            pause (this.delaySetting.getAfterWindowSwitch ());
        });
    }
}