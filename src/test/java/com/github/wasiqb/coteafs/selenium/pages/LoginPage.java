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

import org.openqa.selenium.support.How;

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.PageFactory;
import com.github.wasiqb.coteafs.selenium.core.annotation.Find;
import com.github.wasiqb.coteafs.selenium.core.element.IElementActions;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;

/**
 * @author wasiqb
 * @since Aug 31, 2018 9:33:22 PM
 */
public class LoginPage extends BrowserPage {
	@Find (strategy = How.NAME, locator = "frmLogin")
	private IElementActions	form;
	@Find (strategy = How.NAME, locator = "password", parent = "form")
	private ITextboxActions	password;
	@Find (strategy = How.NAME, locator = "btnLogin", parent = "form")
	private IMouseActions	signIn;
	@Find (strategy = How.NAME, locator = "uid", parent = "form")
	private ITextboxActions	uid;

	/**
	 * @author Wasiq Bhamla
	 * @since 09-Jun-2019
	 */
	public LoginPage () {
		PageFactory.init (this);
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:40:05 PM
	 * @return password
	 */
	public ITextboxActions password () {
		return this.password;
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:40:56 PM
	 * @return signIn button
	 */
	public IMouseActions signIn () {
		return this.signIn;
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:34:38 PM
	 * @return user id
	 */
	public ITextboxActions userId () {
		return this.uid;
	}
}