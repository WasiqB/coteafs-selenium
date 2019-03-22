/**
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

import static java.lang.System.getProperty;

/**
 * @author Wasiq Bhamla
 * @since Aug 10, 2018 2:37:10 PM
 */
public class OS {
	private static final String OS = getProperty ("os.name").toLowerCase ();

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 10, 2018 2:38:12 PM
	 * @return is Mac
	 */
	public static boolean isMac () {
		return OS.indexOf ("mac") >= 0;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 10, 2018 2:38:47 PM
	 * @return is unix
	 */
	public static boolean isUnix () {
		return OS.indexOf ("nix") >= 0 || OS.indexOf ("nux") >= 0 || OS.indexOf ("aix") > 0;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 10, 2018 2:38:57 PM
	 * @return is win
	 */
	public static boolean isWindows () {
		return OS.indexOf ("win") >= 0;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 10, 2018 2:50:40 PM
	 * @return platform
	 */
	public static String platform () {
		if (isWindows ()) { return "win"; }
		if (isMac ()) { return "mac"; }
		if (isUnix ()) { return "linux"; }
		return null;
	}
}