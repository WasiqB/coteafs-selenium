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

import com.github.wasiqb.coteafs.selenium.core.enums.AlertDecision;
import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.EditAccountPage;

/**
 * @author wasiqb
 * @since Apr 8, 2019 10:26:00 PM
 */
public class DeleteAccountPageAction extends AbstractPageAction<DeleteAccountPageAction> {
    @Override
    public void perform () {
        final EditAccountPage acc = new EditAccountPage ();
        acc.navbar ("Delete Account")
            .click ();

        acc.accountId ()
            .enterText (value ("AccountId"));
        acc.submit ()
            .click ();

        acc.onDriver ()
            .verifyAlertMessage (AlertDecision.ACCEPT)
            .isEqualTo ("Do you really want to delete this Account?");

        acc.onDriver ()
            .verifyAlertMessage (AlertDecision.ACCEPT)
            .isEqualTo ("Account Deleted Sucessfully");
    }
}