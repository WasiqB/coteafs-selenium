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
import com.github.wasiqb.coteafs.selenium.pages.EditCustomerPage;

/**
 * @author Wasiq Bhamla
 * @since 29-Apr-2019
 */
public class DeleteCustomerPageAction extends AbstractPageAction<DeleteCustomerPageAction> {
    @Override
    public void perform () {
        final EditCustomerPage edit = new EditCustomerPage ();
        edit.navbar ("Delete Customer")
            .click ();

        edit.customerId ()
            .enterText (value ("CustomerId").toString ());
        edit.submit ()
            .click ();

        edit.onDriver ()
            .verifyAlertMessage (AlertDecision.ACCEPT)
            .isEqualTo ("Do you really want to delete this Customer?");

        edit.onDriver ()
            .verifyAlertMessage (AlertDecision.ACCEPT)
            .isEqualTo ("Customer deleted Successfully");
    }
}