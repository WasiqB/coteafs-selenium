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

import java.util.HashMap;
import java.util.Map;

import com.github.wasiqb.coteafs.config.util.BasePojo;
import com.github.wasiqb.coteafs.selenium.core.enums.AvailableBrowser;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:41:06 PM
 */
@Getter
@Setter
public class ApplicationSetting extends BasePojo {
    private AvailableBrowser    browser;
    private DriverSetting       driver;
    private boolean             headlessMode;
    private String              hubUrl;
    private Map<String, String> params;
    private PlaybackSetting     playback;
    private RemoteSetting       remote;
    private String              url;

    /**
     * @author wasiqb
     * @since Apr 7, 2019 5:12:10 PM
     */
    public ApplicationSetting () {
        this.params = new HashMap<> ();
        this.browser = AvailableBrowser.CHROME;
        this.driver = new DriverSetting ();
        this.playback = new PlaybackSetting ();
        this.headlessMode = false;
    }
}