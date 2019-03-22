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
package com.github.wasiqb.coteafs.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Wasiq Bhamla
 * @since Aug 19, 2018 4:15:31 PM
 */
public class BrowserPage {
	/**
	 * @author Wasiq Bhamla
	 * @since Aug 19, 2018 4:16:51 PM
	 * @return actions
	 */
	public BrowserActions interact () {
		return Browser.interact ();
	}

	/**
	 * @author wasiqb
	 * @since Aug 29, 2018 10:35:20 PM
	 * @param locator
	 * @return element action
	 */
	public ElementAction interact (final By locator) {
		return new ElementAction (interact (), locator);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:38:00 PM
	 * @param element
	 * @return element action
	 */
	public ElementAction interact (final WebElement element) {
		return new ElementAction (interact (), element);
	}
}