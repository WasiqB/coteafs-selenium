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

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:41:06 PM
 */
public class ApplicationSetting {
	private AvailableBrowser		browser;
	private boolean					headlessMode;
	private String					hubUrl;
	private Map <String, String>	params;
	private PlaybackSetting			playback;
	private String					url;

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:10 PM
	 */
	public ApplicationSetting () {
		this.params = new HashMap <> ();
		this.browser = AvailableBrowser.CHROME;
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @return the browser
	 */
	public AvailableBrowser getBrowser () {
		return this.browser;
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
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @return the params
	 */
	public Map <String, String> getParams () {
		return this.params;
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
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @return the url
	 */
	public String getUrl () {
		return this.url;
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @return the headlessMode
	 */
	public boolean isHeadlessMode () {
		return this.headlessMode;
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @param browser
	 * the browser to set
	 */
	public void setBrowser (final AvailableBrowser browser) {
		this.browser = browser;
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @param headlessMode
	 * the headlessMode to set
	 */
	public void setHeadlessMode (final boolean headlessMode) {
		this.headlessMode = headlessMode;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since May 1, 2018 5:01:07 PM
	 * @param hubUrl
	 * the hubUrl to set
	 */
	public void setHubUrl (final String hubUrl) {
		this.hubUrl = hubUrl;
	}

	/**
	 * @author wasiqb
	 * @since Apr 8, 2019 11:22:53 PM
	 * @param params
	 * the params to set
	 */
	public void setParams (final Map <String, String> params) {
		this.params = params;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:35 PM
	 * @param playback
	 * the playback to set
	 */
	public void setPlayback (final PlaybackSetting playback) {
		this.playback = playback;
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:12:41 PM
	 * @param url
	 * the url to set
	 */
	public void setUrl (final String url) {
		this.url = url;
	}
}