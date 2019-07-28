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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IVerifyElement;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;
import com.google.common.truth.BooleanSubject;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <E>
 * @param <D>
 * @param <B>
 */
public class VerifyElement <E extends WebElement, D extends WebDriver, B extends IDriverActions <D>>
	extends ElementAction <E, D, B> implements IVerifyElement {
	VerifyElement (final B browserAction, final By by, final WaitStrategy strategy) {
		super (browserAction, by, strategy);
	}

	VerifyElement (final B browserAction, final E element) {
		super (browserAction, element);
	}

	VerifyElement (final B browserAction, final By by) {
		super (browserAction, by);
	}

	VerifyElement (final B browserAction, final E element, final WaitStrategy strategy) {
		super (browserAction, element, strategy);
	}

	@Override
	public StringSubject verifyAttribute (final String attribute) {
		return assertThat (attribute (attribute));
	}

	@Override
	public BooleanSubject verifyDisplayed () {
		return assertWithMessage ("Is Displayed?").that (isDisplayed ());
	}

	@Override
	public BooleanSubject verifyEnabled () {
		return assertWithMessage ("Is Enabled?").that (isEnabled ());
	}

	@Override
	public BooleanSubject verifySelected () {
		return assertWithMessage ("Is Selected?").that (isSelected ());
	}

	@Override
	public StringSubject verifyText () {
		return assertThat (text ());
	}
}