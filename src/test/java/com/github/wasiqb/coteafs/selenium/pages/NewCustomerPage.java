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

import static java.lang.String.format;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;

/**
 * @author wasiqb
 * @since Apr 7, 2019 5:48:17 PM
 */
public class NewCustomerPage extends MainPage {
	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:59:04 PM
	 * @return address
	 */
	public ITextboxActions address () {
		return onTextbox (By.name ("addr"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 6:00:33 PM
	 * @return city
	 */
	public ITextboxActions city () {
		return onTextbox (By.name ("city"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:50:30 PM
	 * @return name
	 */
	public ITextboxActions customerName () {
		return onTextbox (By.name ("name"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:58:17 PM
	 * @return dob
	 */
	public ITextboxActions dob () {
		return onTextbox (By.name ("dob"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:23:52 PM
	 * @return email
	 */
	public ITextboxActions email () {
		return onTextbox (By.name ("emailid"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:52:55 PM
	 * @param gender
	 *     Gender
	 * @return gender
	 */
	public IMouseActions gender (final char gender) {
		if (gender != 'm' && gender != 'f') return gender ('m');
		return onClickable (By.cssSelector (format ("input[name='rad1'][value='%s']", gender)));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:50:00 PM
	 * @return header
	 */
	public IMouseActions header () {
		return onClickable (By.className ("heading3"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:23:08 PM
	 * @return mobile no
	 */
	public ITextboxActions mobileNumber () {
		return onTextbox (By.name ("telephoneno"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:26:57 PM
	 * @return password
	 */
	public ITextboxActions password () {
		return onTextbox (By.name ("password"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 6:04:02 PM
	 * @return pin
	 */
	public ITextboxActions pin () {
		return onTextbox (By.name ("pinno"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 6:02:57 PM
	 * @return state
	 */
	public ITextboxActions state () {
		return onTextbox (By.name ("state"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:27:48 PM
	 * @return submit
	 */
	public IMouseActions submit () {
		return onClickable (By.name ("sub"));
	}
}