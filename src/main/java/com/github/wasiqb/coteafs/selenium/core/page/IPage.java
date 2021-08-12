/*
 * Copyright (c) 2017, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core.page;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectBoxActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextBoxActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @param <D>
 * @param <B>
 * @param <E>
 *
 * @author Wasiq Bhamla
 * @since 08-Jun-2019
 */
public interface IPage<D extends WebDriver, B extends IDriverActions<D>, E extends WebElement> {
    /**
     * @param <T> Page type
     * @param pageCls Page class
     *
     * @return next page instance
     *
     * @author Wasiq Bhamla
     * @since 14-Oct-2019
     */
    <T extends IPage<D, B, E>> T nextPage (Class<T> pageCls);

    /**
     * @param <T> Mouse action type
     * @param locator locator
     * @param name Name of element
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends IMouseActions> T onClickable (By locator, final String name);

    /**
     * @param <T> Mouse action type
     * @param locator locator
     * @param name Name of element
     * @param strategy strategy
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends IMouseActions> T onClickable (By locator, final String name, WaitStrategy strategy);

    /**
     * @param <T> Mouse action type
     * @param element element
     * @param name Element name
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends IMouseActions> T onClickable (E element, final String name);

    /**
     * @param <T> Mouse action type
     * @param element element
     * @param name Element name
     * @param strategy wait strategy
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends IMouseActions> T onClickable (E element, final String name, WaitStrategy strategy);

    /**
     * @return driver action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    B onDriver ();

    /**
     * @param <T> SelectBox action type
     * @param locator locator
     * @param name Element name
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends ISelectBoxActions> T onDropdown (By locator, final String name);

    /**
     * @param <T> SelectBox action type
     * @param locator locator
     * @param name Element name
     * @param strategy strategy
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends ISelectBoxActions> T onDropdown (By locator, final String name, WaitStrategy strategy);

    /**
     * @param <T> SelectBox action type
     * @param element element
     * @param name Element name
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends ISelectBoxActions> T onDropdown (E element, final String name);

    /**
     * @param <T> SelectBox action type
     * @param element element
     * @param name Element name
     * @param strategy strategy
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends ISelectBoxActions> T onDropdown (E element, final String name, WaitStrategy strategy);

    /**
     * @param <T> TextBox action type
     * @param locator locator
     * @param name Element name
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends ITextBoxActions> T onTextBox (By locator, final String name);

    /**
     * @param <T> TextBox action type
     * @param locator locator
     * @param name Element name
     * @param strategy strategy
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends ITextBoxActions> T onTextBox (By locator, final String name, WaitStrategy strategy);

    /**
     * @param <T> TextBox action type
     * @param element element
     * @param name Element name
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends ITextBoxActions> T onTextBox (E element, final String name);

    /**
     * @param <T> TextBox action type
     * @param element element
     * @param name Element name
     * @param strategy strategy
     *
     * @return element action
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends ITextBoxActions> T onTextBox (E element, final String name, WaitStrategy strategy);
}