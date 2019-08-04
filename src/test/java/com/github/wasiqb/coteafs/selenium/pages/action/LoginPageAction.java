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
package com.github.wasiqb.coteafs.selenium.pages.action;

import static java.text.MessageFormat.format;

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.LoginPage;
import com.github.wasiqb.coteafs.selenium.pages.MainPage;

/**
 * @author wasiqb
 * @since Sep 1, 2018 8:09:35 PM
 */
public class LoginPageAction extends AbstractPageAction <LoginPageAction> {
	/**
	 * Password key.
	 */
	public static final String	PASS	= "password";
	/**
	 * User Id key.
	 */
	public static final String	USER_ID	= "userId";

	@Override
	public void perform () {
		final LoginPage login = new LoginPage ();
		login.userId ()
			.enterText (value (USER_ID));
		login.password ()
			.enterText (value (PASS));
		login.signIn ()
			.click ();

		final MainPage main = new MainPage ();
		main.managerIdBanner ()
			.verifyText ()
			.endsWith (format ("Manger Id : {0}", value (USER_ID).toString ()));
	}
}