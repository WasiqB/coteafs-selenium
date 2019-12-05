/*
 * Copyright (c) 2019, Wasiq Bhamla.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.wasiqb.coteafs.selenium.core.base.element;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IElementActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <E>
 * @param <D>
 * @param <B>
 */
public class ElementAction<E extends WebElement, D extends WebDriver, B extends IDriverActions<D>>
    extends BaseElementAction<E, D, B> implements IElementActions {
    protected ElementAction (final B browserAction, final By by, final String name) {
        super (browserAction, by, name);
    }

    protected ElementAction (final B browserAction, final By by, final String name, final WaitStrategy strategy) {
        super (browserAction, by, name, strategy);
    }

    protected ElementAction (final B browserAction, final E element, final String name) {
        super (browserAction, element, name);
    }

    protected ElementAction (final B browserAction, final E element, final String name, final WaitStrategy strategy) {
        super (browserAction, element, name, strategy);
    }

    @Override
    public String attribute (final String name) {
        return get (e -> e.getAttribute (name));
    }

    @Override
    public void clear () {
        perform (WebElement::clear);
    }

    @Override
    public boolean isDisplayed () {
        return get (WebElement::isDisplayed);
    }

    @Override
    public boolean isEnabled () {
        return get (WebElement::isEnabled);
    }

    @Override
    public boolean isSelected () {
        return get (WebElement::isSelected);
    }

    @Override
    public String text () {
        return get (WebElement::getText);
    }
}