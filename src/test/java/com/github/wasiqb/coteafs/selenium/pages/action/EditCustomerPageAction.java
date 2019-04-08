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
import com.github.wasiqb.coteafs.selenium.core.BrowserPageAction;
import com.github.wasiqb.coteafs.selenium.pages.EditCustomerPage;
import com.github.wasiqb.coteafs.selenium.pages.NewCustomerPage;

/**
 * @author wasiqb
 * @since Apr 8, 2019 11:49:16 AM
 */
public class EditCustomerPageAction extends BrowserPageAction {
	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.selenium.core.BrowserPageAction#perform()
	 */
	@Override
	public void perform () {
		final EditCustomerPage edit = new EditCustomerPage ();
		edit.navbar ("Edit Customer")
			.click ();

		edit.customerId ()
			.enterText (value ("CustomerId"));
		edit.submit ()
			.click ();

		final NewCustomerPage cust = new NewCustomerPage ();
		final Faker fake = Faker.instance ();
		cust.address ()
			.enterText (fake.address ()
				.fullAddress ());
		cust.city ()
			.enterText (fake.address ()
				.city ());
		cust.state ()
			.enterText (fake.address ()
				.state ());
		cust.pin ()
			.enterText (fake.address ()
				.zipCode ());
		cust.email ()
			.enterText (fake.internet ()
				.emailAddress ());
		cust.submit ()
			.click ();
	}
}