/*
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

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectboxActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;
import com.github.wasiqb.coteafs.selenium.core.page.IPage;

/**
 * @author Wasiq Bhamla
 * @since Aug 19, 2018 4:15:31 PM
 */
@SuppressWarnings ("unchecked")
public class BrowserPage implements IPage <BrowserActions, WebElement> {
	private final Browser browser;

	/**
	 * @author Wasiq Bhamla
	 * @since 02-Jun-2019
	 */
	public BrowserPage () {
		this.browser = new Browser ();
	}

	@Override
	public IMouseActions onClickable (final WebElement element) {
		return new WebElementAction (onDriver (), element);
	}

	@Override
	public IMouseActions onClickable (final WebElement element, final WaitStrategy strategy) {
		return new WebElementAction (onDriver (), element, strategy);
	}

	@Override
	public IMouseActions onClickable (final By locator, final WaitStrategy strategy) {
		return new WebElementAction (onDriver (), locator, strategy);
	}

	@Override
	public IMouseActions onClickable (final By locator) {
		return new WebElementAction (onDriver (), locator);
	}

	@Override
	public BrowserActions onDriver () {
		return new BrowserActions (this.browser.getDriver ());
	}

	@Override
	public ISelectboxActions onDropdown (final WebElement element) {
		return new WebElementAction (onDriver (), element);
	}

	@Override
	public ISelectboxActions onDropdown (final WebElement element, final WaitStrategy strategy) {
		return new WebElementAction (onDriver (), element, strategy);
	}

	@Override
	public ISelectboxActions onDropdown (final By locator, final WaitStrategy strategy) {
		return new WebElementAction (onDriver (), locator, strategy);
	}

	@Override
	public ISelectboxActions onDropdown (final By locator) {
		return new WebElementAction (onDriver (), locator);
	}

	@Override
	public ITextboxActions onTextbox (final WebElement element) {
		return new WebElementAction (onDriver (), element);
	}

	@Override
	public ITextboxActions onTextbox (final WebElement element, final WaitStrategy strategy) {
		return new WebElementAction (onDriver (), element, strategy);
	}

	@Override
	public ITextboxActions onTextbox (final By locator, final WaitStrategy strategy) {
		return new WebElementAction (onDriver (), locator, strategy);
	}

	@Override
	public ITextboxActions onTextbox (final By locator) {
		return new WebElementAction (onDriver (), locator);
	}
}