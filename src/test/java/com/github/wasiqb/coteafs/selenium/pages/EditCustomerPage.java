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

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;
import org.openqa.selenium.By;

/**
 * @author wasiqb
 * @since Apr 8, 2019 11:44:28 AM
 */
public class EditCustomerPage extends MainPage {
    /**
     * @return customer id
     * @author wasiqb
     * @since Apr 8, 2019 11:45:14 AM
     */
    public ITextboxActions customerId() {
        return onTextbox(By.name("cusid"), "Customer ID");
    }

    /**
     * @return submit
     * @author wasiqb
     * @since Apr 8, 2019 11:46:15 AM
     */
    public IMouseActions submit() {
        return onClickable(By.name("AccSubmit"), "Submit");
    }
}