/*
 * Copyright (c) 2019, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.wasiqb.coteafs.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.github.wasiqb.coteafs.selenium.core.base.element.AbstractElementAction;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 */
class WebElementAction extends AbstractElementAction <WebElement, EventFiringWebDriver, BrowserActions> {
	WebElementAction (final BrowserActions browserAction, final By by) {
		super (browserAction, by);
	}

	WebElementAction (final BrowserActions browserAction, final By by, final WaitStrategy strategy) {
		super (browserAction, by, strategy);
	}

	WebElementAction (final BrowserActions browserAction, final WebElement element) {
		super (browserAction, element);
	}

	WebElementAction (final BrowserActions browserAction, final WebElement element, final WaitStrategy strategy) {
		super (browserAction, element, strategy);
	}
}