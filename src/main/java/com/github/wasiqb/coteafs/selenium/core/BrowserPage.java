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

import com.github.wasiqb.coteafs.selenium.core.page.IPage;

/**
 * @author Wasiq Bhamla
 * @since Aug 19, 2018 4:15:31 PM
 */
public class BrowserPage implements IPage <BrowserActions, WebElement, ElementAction> {
	private final Browser browser;

	/**
	 * @author Wasiq Bhamla
	 * @since 02-Jun-2019
	 */
	public BrowserPage () {
		this.browser = new Browser ();
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IPage#onDriver()
	 */
	@Override
	public BrowserActions onDriver () {
		return new BrowserActions (this.browser.getDriver ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IPage#onElement(org.openqa.
	 * selenium.By)
	 */
	@Override
	public ElementAction onElement (final By locator) {
		return new ElementAction (onDriver (), locator);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IPage#onElement(org.openqa.
	 * selenium.WebElement)
	 */
	@Override
	public ElementAction onElement (final WebElement element) {
		return new ElementAction (onDriver (), element);
	}
}