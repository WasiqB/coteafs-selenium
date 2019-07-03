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

/**
 * @author Wasiq Bhamla
 * @since 06-Jun-2019
 */
public interface IWebDriverActions extends IDriverActions, IWebWindow {
	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void back ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void deleteCookies ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void forward ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param url
	 */
	void navigateTo (String url);

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void refresh ();
}