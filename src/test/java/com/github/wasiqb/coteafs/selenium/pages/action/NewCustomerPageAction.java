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

import java.text.SimpleDateFormat;

import com.github.javafaker.Faker;
import com.github.wasiqb.coteafs.selenium.core.BrowserPageAction;
import com.github.wasiqb.coteafs.selenium.pages.NewCustomerPage;
import com.github.wasiqb.coteafs.selenium.pages.SuccessCustomerPage;

/**
 * @author wasiqb
 * @since Apr 7, 2019 10:51:02 PM
 */
public class NewCustomerPageAction extends BrowserPageAction {
	private String id;

	/**
	 * @author wasiqb
	 * @since Apr 8, 2019 11:37:44 AM
	 * @return id
	 */
	public String customerId () {
		return this.id;
	}

	/*
	 * (non-Javadoc)
	 * @see com.github.wasiqb.coteafs.selenium.core.BrowserPageAction#perform()
	 */
	@Override
	public void perform () {
		final Faker fake = Faker.instance ();
		final NewCustomerPage cust = new NewCustomerPage ();
		cust.navbar ("New Customer")
			.click ();
		final String name = fake.name ()
			.firstName ();
		cust.customerName ()
			.enterText (name);
		cust.gender (fake.demographic ()
			.sex ()
			.charAt (0));
		final SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");
		final String [] dates = df.format (fake.date ()
			.birthday (15, 50))
			.split ("-");
		for (final String date : dates) {
			cust.dob ()
				.enterText (date);
		}

		cust.address ()
			.enterText (fake.address ()
				.streetAddress ());
		cust.city ()
			.enterText (fake.address ()
				.city ());
		cust.state ()
			.enterText (fake.address ()
				.state ());
		cust.pin ()
			.enterText (fake.number ()
				.digits (6));
		cust.mobileNumber ()
			.enterText (fake.number ()
				.digits (10));
		cust.email ()
			.enterText (fake.internet ()
				.emailAddress ());
		cust.password ()
			.enterText (fake.code ()
				.imei ());
		cust.submit ()
			.click ();

		final SuccessCustomerPage success = new SuccessCustomerPage ();
		success.message ()
			.verifyText ()
			.isEqualTo ("Customer Registered Successfully!!!");
		success.customerName ()
			.verifyText ()
			.isEqualTo (name);
		this.id = success.customerId ()
			.text ();
	}
}