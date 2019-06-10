/**
 * Copyright (c) 2017, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core.driver;

import org.openqa.selenium.WebDriver;

import com.github.wasiqb.coteafs.selenium.core.enums.ApplicationType;
import com.github.wasiqb.coteafs.selenium.core.enums.Platform;
import com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs;

/**
 * @author Wasiq Bhamla
 * @param <D>
 * @since 06-Jun-2019
 */
public interface IDriver <D extends WebDriver> {
	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return application type.
	 */
	ApplicationType getApplicationType ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return driver
	 */
	D getDriver ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return platform
	 */
	Platform getPlatform ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return platform os.
	 */
	PlatformOs getPlatformOs ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param <T>
	 * @return actions
	 */
	<T extends IDriverActions> T interact ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void start ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void stop ();
}