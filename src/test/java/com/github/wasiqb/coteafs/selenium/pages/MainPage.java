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
package com.github.wasiqb.coteafs.selenium.pages;

import com.github.wasiqb.coteafs.selenium.core.BrowserElement;
import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.ElementAction;

/**
 * @author wasiqb
 * @since Aug 31, 2018 8:14:38 PM
 */
public class MainPage extends BrowserPage {
	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:11:41 PM
	 * @return element
	 */
	public ElementAction search () {
		final BrowserElement element = BrowserElement.create ("Search", "input")
				.withAttr ("id", "search_query_top");
		return interact (element);
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:29:31 PM
	 * @return element
	 */
	public ElementAction signIn () {
		final BrowserElement element = BrowserElement.create ("Sign In", "a")
				.withAttr ("class", "login");
		return interact (element);
	}
}