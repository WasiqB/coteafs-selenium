/*
 * Copyright (c) 2019, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import com.github.wasiqb.coteafs.selenium.core.driver.IPlatformAction;
import com.github.wasiqb.coteafs.selenium.core.enums.Platform;
import com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs;

/**
 * @author Wasiq Bhamla
 * @since 26-Jul-2019
 */
public class PlatformAction implements IPlatformAction {
	private final Platform		platform;
	private final PlatformOs	platformOs;

	/**
	 * @author Wasiq Bhamla
	 * @since 26-Jul-2019
	 * @param platform
	 *     platform
	 * @param platformOs
	 *     platformOs
	 */
	PlatformAction (final Platform platform, final PlatformOs platformOs) {
		this.platform = platform;
		this.platformOs = platformOs;
	}

	@Override
	public Platform getPlatform () {
		return this.platform;
	}

	@Override
	public PlatformOs getPlatformOs () {
		return this.platformOs;
	}
}