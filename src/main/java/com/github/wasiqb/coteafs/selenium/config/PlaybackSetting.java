/*
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.config;

import com.github.wasiqb.coteafs.config.util.BasePojo;
import com.github.wasiqb.coteafs.selenium.core.enums.ScreenState;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:45:29 PM
 */
public class PlaybackSetting extends BasePojo {
    private DelaySetting      delays;
    private boolean           highlight;
    private ScreenResolution  screenResolution;
    private ScreenshotSetting screenshot;
    private ScreenState       screenState;

    /**
     * @author Wasiq Bhamla
     * @since Apr 28, 2019
     */
    public PlaybackSetting () {
        this.screenResolution = new ScreenResolution ();
        this.delays = new DelaySetting ();
        this.screenshot = new ScreenshotSetting ();
        this.screenState = ScreenState.NORMAL;
        this.highlight = true;
    }

    /**
     * @return the delays
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public DelaySetting getDelays () {
        return this.delays;
    }

    /**
     * @return the screenResolution
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public ScreenResolution getScreenResolution () {
        return this.screenResolution;
    }

    /**
     * @return the screenshot
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public ScreenshotSetting getScreenshot () {
        return this.screenshot;
    }

    /**
     * @return the screenState
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public ScreenState getScreenState () {
        return this.screenState;
    }

    /**
     * @return the highlight
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public boolean isHighlight () {
        return this.highlight;
    }

    /**
     * @param delays the delays to set
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public void setDelays (final DelaySetting delays) {
        this.delays = delays;
    }

    /**
     * @param highlight the highlight to set
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public void setHighlight (final boolean highlight) {
        this.highlight = highlight;
    }

    /**
     * @param screenResolution the screenSize to set
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public void setScreenResolution (final ScreenResolution screenResolution) {
        this.screenResolution = screenResolution;
    }

    /**
     * @param screenshot the screenshot to set
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public void setScreenshot (final ScreenshotSetting screenshot) {
        this.screenshot = screenshot;
    }

    /**
     * @param screenState the screenState to set
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 3:00:22 PM
     */
    public void setScreenState (final ScreenState screenState) {
        this.screenState = screenState;
    }
}