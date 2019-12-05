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
package com.github.wasiqb.coteafs.selenium.config;

import static com.github.wasiqb.coteafs.config.loader.ConfigLoader.settings;
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.COTEAFS_CONFIG_DEFAULT_FILE;
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.COTEAFS_CONFIG_KEY;

/**
 * @author Wasiq Bhamla
 * @since Aug 9, 2018 8:23:23 PM
 */
public final class ConfigUtil {
    /**
     * @author Wasiq Bhamla
     * @since Aug 9, 2018 8:39:04 PM
     * @return setting
     */
    public static ApplicationSetting appSetting () {
        return settings ().withKey (COTEAFS_CONFIG_KEY)
            .withDefault (COTEAFS_CONFIG_DEFAULT_FILE)
            .load (ApplicationSetting.class);
    }

    private ConfigUtil () {
        // Remove default constructor since class is static util class.
    }
}