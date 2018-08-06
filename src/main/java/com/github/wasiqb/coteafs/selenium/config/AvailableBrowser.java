/**
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

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:42:01 PM
 */
public enum AvailableBrowser {
	/**
	 * Chrome.
	 */
	CHROME ("webdriver.chrome.driver", "/chromedriver_"),
	/**
	 * Firefox.
	 */
	FIREFOX ("webdriver.gecko.driver", "/geckodriver_");

	private static final String DEFAULT_FOLDER = "/driver";

	private String	key;
	private String	path;

	private AvailableBrowser (final String key, final String path) {
		this.key = key;
		this.path = path;
		setup ();
	}

	private void setup () {
		if (getProperty (this.key) == null) {
			final String folder = getConfig (DRIVER_PATH, DEFAULT_FOLDER);
			final String os = getProperty ("os.name");
			final StringBuilder sb = new StringBuilder ();
			if (DEFAULT_FOLDER.equals (folder)) {
				final String dir = getProperty ("user.dir");
				sb.append (dir);
			}
			sb.append (folder);
			sb.append (this.path);
			if (os.startsWith ("Windows"))
				sb.append ("Windows.exe");
			else
				sb.append (os);
			setProperty (this.key, sb.toString ());
		}
	}
}