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
package com.github.wasiqb.coteafs.selenium.config;

import com.github.wasiqb.coteafs.selenium.core.BrowserElement;
import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.ElementAction;

/**
 * @author wasiqb
 * @since Aug 31, 2018 9:33:22 PM
 */
public class LoginPage extends BrowserPage {
	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:34:38 PM
	 * @return email
	 */
	public ElementAction email () {
		final BrowserElement element = BrowserElement.create ("Email", "input")
				.withAttr ("id", "email");
		return interact (element);
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:40:05 PM
	 * @return password
	 */
	public ElementAction password () {
		final BrowserElement element = BrowserElement.create ("Password", "input")
				.withAttr ("id", "passwd");
		return interact (element);
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:40:56 PM
	 * @return signIn button
	 */
	public ElementAction signIn () {
		final BrowserElement element = BrowserElement.create ("Sign In", "button")
				.withAttr ("id", "SubmitLogin");
		return interact (element);
	}
}