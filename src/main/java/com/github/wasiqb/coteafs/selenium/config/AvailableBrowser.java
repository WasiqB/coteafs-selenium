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

import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

import java.net.URL;

import com.github.wasiqb.coteafs.selenium.constants.OS;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:42:01 PM
 */
public enum AvailableBrowser {
	/**
	 * Chrome.
	 */
	CHROME ("webdriver.chrome.driver", "chromedriver"),
	/**
	 * Firefox.
	 */
	FIREFOX ("webdriver.gecko.driver", "geckodriver");

	private static final String DEFAULT_FOLDER = "/drivers";

	private String	driver;
	private String	key;

	private AvailableBrowser (final String key, final String driver) {
		this.key = key;
		this.driver = driver;
		setup ();
	}

	private void setup () {
		final ApplicationSetting setting = appSetting ();
		if (getProperty (this.key) == null) {
			final String folder = setting.getDriverPath () == null
					? DEFAULT_FOLDER
					: setting.getDriverPath ();
			final StringBuilder sb = new StringBuilder ();
			if (DEFAULT_FOLDER.equals (folder)) {
				final URL dir = AvailableBrowser.class.getClassLoader ()
						.getResource (folder);
				sb.append (dir.getPath ());
			}
			sb.append (folder)
					.append ("/")
					.append (OS.platform ())
					.append (this.driver);
			if (OS.isWindows ()) {
				sb.append (".exe");
			}
			setProperty (this.key, sb.toString ());
		}
	}
}