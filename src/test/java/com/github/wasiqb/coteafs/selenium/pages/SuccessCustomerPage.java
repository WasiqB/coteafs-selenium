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

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;

/**
 * @author wasiqb
 * @since Apr 7, 2019 10:46:56 PM
 */
public class SuccessCustomerPage extends SuccessPage {
	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:38:33 PM
	 * @return customer id
	 */
	public IMouseActions customerId () {
		return successTable ().find (By.cssSelector ("tbody > tr:nth-child(4) > td:last-child"));
	}

	/**
	 * @author wasiqb
	 * @since Apr 7, 2019 10:47:54 PM
	 * @return customer name
	 */
	public IMouseActions customerName () {
		return successTable ().find (By.cssSelector ("tbody > tr:nth-child(5) > td:last-child"));
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.selenium.pages.SuccessPage#successTable()
	 */
	@Override
	protected IMouseActions successTable () {
		return onClickable (By.id ("customer"));
	}
}