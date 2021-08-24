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
package com.github.wasiqb.coteafs.selenium;

import static com.github.wasiqb.coteafs.selenium.core.base.driver.ParallelSession.getBrowserSetting;
import static com.github.wasiqb.coteafs.selenium.pages.CheckboxPage.CheckboxPageKeys.CHECK;
import static com.github.wasiqb.coteafs.selenium.pages.DropDownPage.DropDownKeys.OPTION;
import static com.github.wasiqb.coteafs.selenium.pages.LoginPage.LoginPageKeys.PASS;
import static com.github.wasiqb.coteafs.selenium.pages.LoginPage.LoginPageKeys.USER_ID;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.github.wasiqb.coteafs.selenium.core.BrowserTest;
import com.github.wasiqb.coteafs.selenium.pages.MainPage;
import com.github.wasiqb.coteafs.selenium.pages.action.CheckboxPageAction;
import com.github.wasiqb.coteafs.selenium.pages.action.DropDownPageAction;
import com.github.wasiqb.coteafs.selenium.pages.action.LoginPageAction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Wasiq Bhamla
 */
public class SeleniumTest extends BrowserTest {
    private MainPage main;

    @BeforeMethod
    public void setupMethod () {
        this.main = new MainPage ();
        this.main.onDriver ()
            .navigateTo (getBrowserSetting ().getUrl ());
    }

    /**
     * @param value
     *
     * @since Jul 19, 2020
     */
    @Test (dataProvider = "testDataForCheckbox")
    public void testCheckboxes (final String value) {
        setupMethod ();
        this.main.links ("Checkboxes")
            .click ();
        final CheckboxPageAction checkbox = new CheckboxPageAction ();
        checkbox.addInputValue (CHECK, value)
            .perform ();
    }

    /**
     * @return test data for checkbox
     *
     * @since Jul 19, 2020
     */
    @DataProvider
    public Iterator<Object[]> testDataForCheckbox () {
        final List<Object[]> testData = new ArrayList<> ();
        testData.add (new Object[] { "check" });
        testData.add (new Object[] { "uncheck" });
        return testData.iterator ();
    }

    /**
     * @return dropDown data
     *
     * @since Jul 19, 2020
     */
    @DataProvider
    public Iterator<Object[]> testDataForDropDownBox () {
        final List<Object[]> testData = new ArrayList<> ();
        testData.add (new Object[] { "Option 1" });
        testData.add (new Object[] { "Option 2" });
        return testData.iterator ();
    }

    /**
     * @param testValue
     *
     * @since Jul 19, 2020
     */
    @Test (dataProvider = "testDataForDropDownBox")
    public void testDropDownBox (final String testValue) {
        setupMethod ();
        this.main.links ("Dropdown")
            .click ();
        final DropDownPageAction dropDownAction = new DropDownPageAction ();
        dropDownAction.addInputValue (OPTION, testValue)
            .perform ();
    }

    /**
     * @since Apr 8, 2019 10:34:29 PM
     */
    @Test
    public void testLogin () {
        this.main.links ("Form Authentication")
            .click ();
        final Map<String, String> loginParams = getBrowserSetting ().getParams ();
        final LoginPageAction login = new LoginPageAction ();
        login.addInputValue (USER_ID, loginParams.get ("user"))
            .addInputValue (PASS, loginParams.get ("password"))
            .perform ();
    }
}