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
import org.openqa.selenium.By;

/**
 * @author wasiqb
 * @since Apr 8, 2019 8:21:28 PM
 */
public class SuccessAccountPage extends SuccessPage {
    /**
     * @return account id
     * @author wasiqb
     * @since Apr 8, 2019 8:31:20 PM
     */
    public IMouseActions accountId() {
        return cell(3);
    }

    /**
     * @return customer id
     * @author wasiqb
     * @since Apr 8, 2019 8:34:58 PM
     */
    public IMouseActions customerId() {
        return cell(4);
    }

    @Override
    protected IMouseActions successTable() {
        return onClickable(By.id("account"), "Success Table");
    }
}