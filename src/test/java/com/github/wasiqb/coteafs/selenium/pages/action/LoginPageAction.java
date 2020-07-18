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

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.LoginPage;
import com.github.wasiqb.coteafs.selenium.pages.LoginPage.LoginPageKeys;
import com.github.wasiqb.coteafs.selenium.pages.SuccessLoginPage;

/**
 * @author Wasiq Bhamla
 */
public class LoginPageAction extends AbstractPageAction<LoginPageAction> {
    @Override
    public void perform () {
        LoginPage login = new LoginPage ();
        login.userId ()
            .enterText (value (LoginPageKeys.USER_ID));
        login.password ()
            .enterText (value (LoginPageKeys.PASS));
        login.signIn ()
            .click ();

        final SuccessLoginPage successPage = login.nextPage (SuccessLoginPage.class);

        successPage.successMessage ()
            .verifyText ()
            .startsWith ("You logged into a secure area!");

        successPage.logout ()
            .click ();

        login = successPage.nextPage (LoginPage.class);
        login.loginMessage ()
            .verifyText ()
            .startsWith ("You logged out of the secure area!");
    }
}