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

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;
import org.openqa.selenium.By;

/**
 * @author wasiqb
 * @since Aug 31, 2018 9:33:22 PM
 */
public class LoginPage extends BrowserPage {
    /**
     * @return password
     * @author wasiqb
     * @since Aug 31, 2018 9:40:05 PM
     */
    public ITextboxActions password() {
        return form().find(By.name("password"), "Password");
    }

    /**
     * @return signIn button
     * @author wasiqb
     * @since Aug 31, 2018 9:40:56 PM
     */
    public IMouseActions signIn() {
        return form().find(By.name("btnLogin"), "Login");
    }

    /**
     * @return user id
     * @author wasiqb
     * @since Aug 31, 2018 9:34:38 PM
     */
    public ITextboxActions userId() {
        return form().find(By.name("uid"), "User ID");
    }

    private IMouseActions form() {
        return onClickable(By.name("frmLogin"), "Form");
    }
}