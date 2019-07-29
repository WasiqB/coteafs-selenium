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

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 3:00:06 PM
 */
public class ScreenshotSetting {
	private boolean	captureOnError;
	private String	extension;
	private String	path;
	private String	prefix;

	/**
	 * @author Wasiq Bhamla
	 * @since May 1, 2018 4:58:36 PM
	 * @return the extension
	 */
	public String getExtension () {
		return this.extension;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:16 PM
	 * @return the path
	 */
	public String getPath () {
		return this.path;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:16 PM
	 * @return the prefix
	 */
	public String getPrefix () {
		return this.prefix;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:15 PM
	 * @return the captureOnError
	 */
	public boolean isCaptureOnError () {
		return this.captureOnError;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:16 PM
	 * @param captureOnError
	 *     the captureOnError to set
	 */
	public void setCaptureOnError (final boolean captureOnError) {
		this.captureOnError = captureOnError;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since May 1, 2018 4:58:36 PM
	 * @param extension
	 *     the extension to set
	 */
	public void setExtension (final String extension) {
		this.extension = extension;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:16 PM
	 * @param path
	 *     the path to set
	 */
	public void setPath (final String path) {
		this.path = path;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:01:16 PM
	 * @param prefix
	 *     the prefix to set
	 */
	public void setPrefix (final String prefix) {
		this.prefix = prefix;
	}
}