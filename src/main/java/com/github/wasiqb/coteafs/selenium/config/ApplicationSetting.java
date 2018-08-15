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

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:41:06 PM
 */
public class ApplicationSetting {
	private AvailableBrowser	browser;
	private String				driverPath;
	private boolean				headlessMode;
	private String				hubUrl;
	private PlaybackSetting		playback;
	private String				url;

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 6, 2018 10:55:03 PM
	 */
	public ApplicationSetting () {
		this.browser = AvailableBrowser.CHROME;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @return the browser
	 */
	public AvailableBrowser getBrowser () {
		return this.browser;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 9, 2018 8:52:36 PM
	 * @return the driverPath
	 */
	public String getDriverPath () {
		return this.driverPath;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since May 1, 2018 5:01:07 PM
	 * @return the hubUrl
	 */
	public String getHubUrl () {
		return this.hubUrl;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @return the playback
	 */
	public PlaybackSetting getPlayback () {
		return this.playback;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @return the url
	 */
	public String getUrl () {
		return this.url;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since May 20, 2018 2:33:04 PM
	 * @return the headlessMode
	 */
	public boolean isHeadlessMode () {
		return this.headlessMode;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @param browser
	 *            the browser to set
	 */
	public void setBrowser (AvailableBrowser browser) {
		this.browser = browser;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 9, 2018 8:52:36 PM
	 * @param driverPath
	 *            the driverPath to set
	 */
	public void setDriverPath (String driverPath) {
		this.driverPath = driverPath;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since May 20, 2018 2:33:04 PM
	 * @param headlessMode
	 *            the headlessMode to set
	 */
	public void setHeadlessMode (boolean headlessMode) {
		this.headlessMode = headlessMode;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since May 1, 2018 5:01:07 PM
	 * @param hubUrl
	 *            the hubUrl to set
	 */
	public void setHubUrl (String hubUrl) {
		this.hubUrl = hubUrl;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @param playback
	 *            the playback to set
	 */
	public void setPlayback (PlaybackSetting playback) {
		this.playback = playback;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @param url
	 *            the url to set
	 */
	public void setUrl (String url) {
		this.url = url;
	}
}