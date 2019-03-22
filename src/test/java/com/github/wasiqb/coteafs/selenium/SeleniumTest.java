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
package com.github.wasiqb.coteafs.selenium;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.selenium.core.BrowserTest;
import com.github.wasiqb.coteafs.selenium.pages.MainPage;
import com.github.wasiqb.coteafs.selenium.pages.action.LoginPageAction;

/**
 * @author Wasiq Bhamla
 * @since Aug 15, 2018 8:07:59 PM
 */
public class SeleniumTest extends BrowserTest {
	private MainPage main;

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 19, 2018 4:30:34 PM
	 */
	@BeforeMethod
	public void setupMethod () {
		this.main.interact ()
			.navigateTo ("http://cafetownsend-angular-rails.herokuapp.com/login");
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:15:42 PM
	 */
	@Test
	public void testSignIn () {
		final LoginPageAction login = new LoginPageAction ();
		login.addInputValue ("Email", "testerbuds@gmail.com")
			.addInputValue ("Password", "123456")
			.perform ();
	}
}