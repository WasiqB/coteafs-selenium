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
package com.github.wasiqb.coteafs.selenium.constants;

import static com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs.LINUX;
import static com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs.MAC;
import static com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs.WINDOWS;
import static java.lang.System.getProperty;

import com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs;

/**
 * @author Wasiq Bhamla
 * @since Aug 10, 2018 2:37:10 PM
 */
public class OS {
    private static final String NAME = getProperty ("os.name").toLowerCase ();

    /**
     * @return is Mac
     * @author Wasiq Bhamla
     * @since Aug 10, 2018 2:38:12 PM
     */
    public static boolean isMac () {
        return NAME.contains ("mac");
    }

    /**
     * @return is unix
     * @author Wasiq Bhamla
     * @since Aug 10, 2018 2:38:47 PM
     */
    public static boolean isUnix () {
        return NAME.contains ("nix") || NAME.contains ("nux") || NAME.contains ("aix");
    }

    /**
     * @return is win
     * @author Wasiq Bhamla
     * @since Aug 10, 2018 2:38:57 PM
     */
    public static boolean isWindows () {
        return NAME.contains ("win");
    }

    /**
     * @return platform
     * @author Wasiq Bhamla
     * @since Aug 10, 2018 2:50:40 PM
     */
    public static PlatformOs platform () {
        if (isWindows ()) {
            return WINDOWS;
        }
        if (isMac ()) {
            return MAC;
        }
        if (isUnix ()) {
            return LINUX;
        }
        return null;
    }

    private OS () {
        // Util class.
    }
}