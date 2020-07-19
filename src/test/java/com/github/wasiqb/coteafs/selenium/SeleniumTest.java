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
package com.github.wasiqb.coteafs.selenium;

import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static com.github.wasiqb.coteafs.selenium.pages.CheckboxPage.CheckboxPageKeys.CHECK;
import static com.github.wasiqb.coteafs.selenium.pages.LoginPage.LoginPageKeys.PASS;
import static com.github.wasiqb.coteafs.selenium.pages.LoginPage.LoginPageKeys.USER_ID;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.wasiqb.coteafs.selenium.core.BrowserTest;
import com.github.wasiqb.coteafs.selenium.pages.MainPage;
import com.github.wasiqb.coteafs.selenium.pages.action.CheckboxPageAction;
import com.github.wasiqb.coteafs.selenium.pages.action.LoginPageAction;

/**
 * @author Wasiq Bhamla
 * @since Aug 15, 2018 8:07:59 PM
 */
public class SeleniumTest extends BrowserTest {
	private MainPage main;

	/**
	 * @since Aug 19, 2018 4:30:34 PM
	 */
	@BeforeClass
	public void setupMethod () {
		this.main = new MainPage ();
		this.main.onDriver ()
			.navigateTo (appSetting ().getUrl ());
	}

	/**
	 * @since Apr 8, 2019 10:34:29 PM
	 */
	@Test
	public void testLogin () {
		this.main.links ("Form Authentication")
			.click ();
		final Map <String, String> loginParams = appSetting ().getParams ();
		final LoginPageAction login = new LoginPageAction ();
		login.addInputValue (USER_ID, loginParams.get ("user"))
			.addInputValue (PASS, loginParams.get ("password"))
			.perform ();

	}

	/**
	 * @author Faisal Khatri
	 * @since Jul 19, 2020
	 * @return test data for checkbox
	 */
	@DataProvider
	public Iterator <Object []> testDataForCheckbox () {
		final List <Object []> testData = new ArrayList <> ();
		testData.add (new Object [] { "check" });
		testData.add (new Object [] { "uncheck" });
		return testData.iterator ();
	}

	/**
	 * @author Faisal Khatri
	 * @since Jul 19, 2020
	 * @param value
	 *
	 */
	@Test (dataProvider = "testDataForCheckbox")
	public void testCheckboxes (final String value) {
		setupMethod ();
		this.main.links ("Checkboxes")
			.click ();
		final CheckboxPageAction checkbox = new CheckboxPageAction ();
		checkbox.addInputValue (CHECK, value)
			.perform ();
	}

}