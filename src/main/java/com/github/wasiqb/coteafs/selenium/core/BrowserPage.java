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
package com.github.wasiqb.coteafs.selenium.core;

import static com.github.wasiqb.coteafs.error.util.ErrorUtil.handleError;
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.FILTER_PKG;

import java.lang.reflect.InvocationTargetException;

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectBoxActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextBoxActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;
import com.github.wasiqb.coteafs.selenium.core.page.IPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author Wasiq Bhamla
 * @since Aug 19, 2018 4:15:31 PM
 */
@SuppressWarnings ("unchecked")
public class BrowserPage implements IPage<EventFiringWebDriver, BrowserActions, WebElement> {
    private static final Logger  LOG = LogManager.getLogger ();
    private final        Browser browser;

    /**
     * @author Wasiq Bhamla
     * @since 02-Jun-2019
     */
    public BrowserPage () {
        this.browser = new Browser ();
    }

    @Override
    public <T extends IPage<EventFiringWebDriver, BrowserActions, WebElement>> T nextPage (final Class<T> pageCls) {
        T page = null;
        try {
            page = pageCls.getConstructor ()
                .newInstance ();
        } catch (final InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
            handleError (FILTER_PKG, e).forEach (LOG::error);
        }
        return page;
    }

    @Override
    public IMouseActions onClickable (final By locator, final String name) {
        return new WebElementAction (onDriver (), locator, name);
    }

    @Override
    public IMouseActions onClickable (final By locator, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), locator, name, strategy);
    }

    @Override
    public IMouseActions onClickable (final WebElement element, final String name) {
        return new WebElementAction (onDriver (), element, name);
    }

    @Override
    public IMouseActions onClickable (final WebElement element, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), element, name, strategy);
    }

    @Override
    public BrowserActions onDriver () {
        return new BrowserActions (this.browser.getDriver ());
    }

    @Override
    public ISelectBoxActions onDropdown (final By locator, final String name) {
        return new WebElementAction (onDriver (), locator, name);
    }

    @Override
    public ISelectBoxActions onDropdown (final By locator, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), locator, name, strategy);
    }

    @Override
    public ISelectBoxActions onDropdown (final WebElement element, final String name) {
        return new WebElementAction (onDriver (), element, name);
    }

    @Override
    public ISelectBoxActions onDropdown (final WebElement element, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), element, name, strategy);
    }

    @Override
    public ITextBoxActions onTextBox (final By locator, final String name) {
        return new WebElementAction (onDriver (), locator, name);
    }

    @Override
    public ITextBoxActions onTextBox (final By locator, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), locator, name, strategy);
    }

    @Override
    public ITextBoxActions onTextBox (final WebElement element, final String name) {
        return new WebElementAction (onDriver (), element, name);
    }

    @Override
    public ITextBoxActions onTextBox (final WebElement element, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), element, name, strategy);
    }
}