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
package com.github.wasiqb.coteafs.selenium.pages.action;

import com.github.javafaker.Faker;
import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.NewAccountPage;
import com.github.wasiqb.coteafs.selenium.pages.SuccessAccountPage;

/**
 * @author wasiqb
 * @since Apr 8, 2019 8:05:24 PM
 */
public class NewAccountPageAction extends AbstractPageAction <NewAccountPageAction> {
	private String accountId;

	/**
	 * @author wasiqb
	 * @since Apr 8, 2019 10:00:42 PM
	 * @return account id
	 */
	public String accountId () {
		return this.accountId;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.selenium.core.BrowserPageAction#perform()
	 */
	@Override
	public void perform () {
		final Faker fake = Faker.instance ();
		final NewAccountPage acc = new NewAccountPage ();
		acc.navbar ("New Account")
			.click ();

		acc.customerId ()
			.enterText (value ("CustomerId"));
		acc.accountType ()
			.select (fake.bool ()
				.bool () ? "Current" : "Savings");
		acc.initialDeposit ()
			.enterText (fake.number ()
				.numberBetween (500, 100000) + "");
		acc.submit ()
			.click ();

		final SuccessAccountPage success = new SuccessAccountPage ();
		success.message ()
			.verifyText ()
			.isEqualTo ("Account Generated Successfully!!!");
		success.customerId ()
			.verifyText ()
			.isEqualTo (value ("CustomerId"));
		this.accountId = success.accountId ()
			.text ();
	}
}