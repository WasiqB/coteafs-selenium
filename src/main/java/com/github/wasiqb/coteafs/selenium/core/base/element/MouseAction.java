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
package com.github.wasiqb.coteafs.selenium.core.base.element;

import static java.time.Duration.ofMillis;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <E>
 * @param <D>
 * @param <B>
 */
public class MouseAction <E extends WebElement, D extends WebDriver, B extends IDriverActions <D>>
	extends VerifyElement <E, D, B> implements IMouseActions {

	protected MouseAction (final B browserAction, final By by, final WaitStrategy strategy) {
		super (browserAction, by, strategy);
	}

	protected MouseAction (final B browserAction, final E element) {
		super (browserAction, element);
	}

	protected MouseAction (final B browserAction, final By by) {
		super (browserAction, by);
	}

	protected MouseAction (final B browserAction, final E element, final WaitStrategy strategy) {
		super (browserAction, element, strategy);
	}

	@Override
	public void click () {
		perform (e -> {
			pause (this.delays.getBeforeClick ());
			e.click ();
			pause (this.delays.getAfterClick ());
		});
	}

	@Override
	public void hover () {
		perform (e -> this.actions.pause (ofMillis (this.delays.getBeforeMouseMove ()))
			.moveToElement (e)
			.pause (ofMillis (this.delays.getAfterMouseMove ()))
			.perform ());
	}
}