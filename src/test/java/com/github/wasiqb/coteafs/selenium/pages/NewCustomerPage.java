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

import static java.lang.String.format;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.ElementAction;

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
	public ElementAction address () {
		return onElement (By.name ("addr"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 6:00:33 PM
	 * @return city
	 */
	public ElementAction city () {
		return onElement (By.name ("city"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:50:30 PM
	 * @return name
	 */
	public ElementAction customerName () {
		return onElement (By.name ("name"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:58:17 PM
	 * @return dob
	 */
	public ElementAction dob () {
		return onElement (By.name ("dob"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:23:52 PM
	 * @return email
	 */
	public ElementAction email () {
		return onElement (By.name ("emailid"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:52:55 PM
	 * @param gender
	 * @return gender
	 */
	public ElementAction gender (final char gender) {
		if (gender != 'm' && gender != 'f') { return gender ('m'); }
		return onElement (By.cssSelector (format ("input[name='rad1'][value='%s']", gender)));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 5:50:00 PM
	 * @return header
	 */
	public ElementAction header () {
		return onElement (By.className ("heading3"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:23:08 PM
	 * @return mobile no
	 */
	public ElementAction mobileNumber () {
		return onElement (By.name ("telephoneno"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:26:57 PM
	 * @return password
	 */
	public ElementAction password () {
		return onElement (By.name ("password"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 6:04:02 PM
	 * @return pin
	 */
	public ElementAction pin () {
		return onElement (By.name ("pinno"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 6:02:57 PM
	 * @return state
	 */
	public ElementAction state () {
		return onElement (By.name ("state"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:27:48 PM
	 * @return submit
	 */
	public ElementAction submit () {
		return onElement (By.name ("sub"));
	}
}