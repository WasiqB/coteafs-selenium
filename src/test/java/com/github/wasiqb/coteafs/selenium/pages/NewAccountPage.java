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

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectboxActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;

/**
 * @author wasiqb
 * @since Apr 8, 2019 12:03:03 PM
 */
public class NewAccountPage extends EditCustomerPage {
	/**
	 * @author wasiqb
	 * @since Apr 8, 2019 12:05:04 PM
	 * @return account type
	 */
	public ISelectboxActions accountType () {
		return onElement (By.name ("selaccount"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 8, 2019 12:06:07 PM
	 * @return initial amount
	 */
	public ITextboxActions initialDeposit () {
		return onElement (By.name ("inideposit"));
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.selenium.pages.EditCustomerPage#submit()
	 */
	@Override
	public IMouseActions submit () {
		return onElement (By.name ("button2"));
	}
}