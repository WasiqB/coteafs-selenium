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

import static com.github.wasiqb.coteafs.selenium.core.Browser.start;
import static com.github.wasiqb.coteafs.selenium.core.Browser.stop;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.selenium.pages.MainPage;
import com.github.wasiqb.coteafs.selenium.pages.action.LoginPageAction;

/**
 * @author Wasiq Bhamla
 * @since Aug 15, 2018 8:07:59 PM
 */
public class BrowserTest {
	private MainPage main;

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 19, 2018 4:30:34 PM
	 */
	@BeforeMethod
	public void setupMethod () {
		this.main.interact ()
				.navigateTo ("http://automationpractice.com");
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 19, 2018 4:22:57 PM
	 */
	@BeforeTest
	public void setupTest () {
		start ("CHROME");
		this.main = new MainPage ();
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 19, 2018 4:23:40 PM
	 */
	@AfterTest
	public void teardownTest () {
		stop ();
	}

	/**
	 * @author wasiqb
	 * @since Aug 31, 2018 9:15:42 PM
	 */
	@Test
	public void testSignIn () {
		this.main.search ()
				.enterText ("Hello!!!");
		this.main.signIn ()
				.click ();

		final LoginPageAction login = new LoginPageAction ();
		login.addInputValue ("Email", "testerbuds@gmail.com")
				.addInputValue ("Password", "123456")
				.perform ();
	}
}