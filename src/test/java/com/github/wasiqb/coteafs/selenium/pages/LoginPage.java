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
package com.github.wasiqb.coteafs.selenium.pages;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;
import com.github.wasiqb.coteafs.selenium.core.page.ElementKey;

/**
 * @author wasiqb
 * @since Aug 31, 2018 9:33:22 PM
 */
public class LoginPage extends BrowserPage {
	/**
	 * @author Wasiq Bhamla
	 */
	public enum LoginPageKeys implements ElementKey {
		/**
		 * User Id
		 */
		USER_ID ("userId"),
		/**
		 * Password
		 */
		PASS ("password");

		String key;

		LoginPageKeys (final String key) {
			this.key = key;
		}

		@Override
		public String getKey () {
			return this.key;
		}
	}

	/**
	 * @return success message
	 */
	public IMouseActions loginMessage () {
		return onClickable (By.id ("flash"), "Login message");
	}

	/**
	 * @return password
	 * @since Aug 31, 2018 9:40:05 PM
	 */
	public ITextboxActions password () {
		return form ().find (By.id ("password"), "Password");
	}

	/**
	 * @return signIn button
	 * @since Aug 31, 2018 9:40:56 PM
	 */
	public IMouseActions signIn () {
		return form ().find (By.tagName ("button"), "Login");
	}

	/**
	 * @return user id
	 * @since Aug 31, 2018 9:34:38 PM
	 */
	public ITextboxActions userId () {
		return form ().find (By.id ("username"), "User ID");
	}

	private IMouseActions form () {
		return onClickable (By.id ("login"), "Login Form");
	}
}