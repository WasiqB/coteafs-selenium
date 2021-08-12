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

import com.github.wasiqb.coteafs.selenium.core.enums.AvailableBrowser;
import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:41:06 PM
 */
@Data
public class ApplicationSetting {
    private AvailableBrowser    browser  = AvailableBrowser.CHROME;
    private DriverSetting       driver   = new DriverSetting ();
    private boolean             headlessMode;
    private String              hubUrl;
    private Map<String, String> params   = new HashMap<> ();
    private PlaybackSetting     playback = new PlaybackSetting ();
    private RemoteSetting       remote;
    private String              url;
}