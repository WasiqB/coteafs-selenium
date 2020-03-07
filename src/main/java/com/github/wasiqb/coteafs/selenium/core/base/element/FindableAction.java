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

import java.util.List;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IFindableAction;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @param <E>
 * @param <D>
 * @param <B>
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 */
public abstract class FindableAction<E extends WebElement, D extends WebDriver, B extends IDriverActions<D>>
    extends KeyboardAction<E, D, B> implements IFindableAction {
    protected FindableAction(final B browserAction, final By by, final String name) {
        super(browserAction, by, name);
    }

    protected FindableAction(final B browserAction, final By by, final String name, final WaitStrategy strategy) {
        super(browserAction, by, name, strategy);
    }

    protected FindableAction(final B browserAction, final E element, final String name) {
        super(browserAction, element, name);
    }

    protected FindableAction(final B browserAction, final E element, final String name, final WaitStrategy strategy) {
        super(browserAction, element, name, strategy);
    }

    @Override
    public <T extends IMouseActions> T find(final By byLocator, final String name) {
        return find(byLocator, name, WaitStrategy.NONE);
    }

    @Override
    public <T extends IMouseActions> List<T> finds(final By byLocator, final String name) {
        return finds(byLocator, name, WaitStrategy.NONE);
    }
}