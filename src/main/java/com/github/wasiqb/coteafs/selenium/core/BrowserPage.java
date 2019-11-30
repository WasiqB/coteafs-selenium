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
import static com.github.wasiqb.coteafs.selenium.constants.ConfigKeys.IGNORE_PKG;

import com.github.wasiqb.coteafs.logger.Loggy;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectboxActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;
import com.github.wasiqb.coteafs.selenium.core.page.IPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author Wasiq Bhamla
 * @since Aug 19, 2018 4:15:31 PM
 */
@SuppressWarnings ("unchecked")
public class BrowserPage implements IPage<EventFiringWebDriver, BrowserActions, WebElement> {
    private static final Loggy   LOG = Loggy.init ();
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
            page = pageCls.newInstance ();
        } catch (final InstantiationException | IllegalAccessException e) {
            handleError (IGNORE_PKG, e).forEach (LOG::e);
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
    public ISelectboxActions onDropdown (final By locator, final String name) {
        return new WebElementAction (onDriver (), locator, name);
    }

    @Override
    public ISelectboxActions onDropdown (final By locator, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), locator, name, strategy);
    }

    @Override
    public ISelectboxActions onDropdown (final WebElement element, final String name) {
        return new WebElementAction (onDriver (), element, name);
    }

    @Override
    public ISelectboxActions onDropdown (final WebElement element, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), element, name, strategy);
    }

    @Override
    public ITextboxActions onTextbox (final By locator, final String name) {
        return new WebElementAction (onDriver (), locator, name);
    }

    @Override
    public ITextboxActions onTextbox (final By locator, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), locator, name, strategy);
    }

    @Override
    public ITextboxActions onTextbox (final WebElement element, final String name) {
        return new WebElementAction (onDriver (), element, name);
    }

    @Override
    public ITextboxActions onTextbox (final WebElement element, final String name, final WaitStrategy strategy) {
        return new WebElementAction (onDriver (), element, name, strategy);
    }
}