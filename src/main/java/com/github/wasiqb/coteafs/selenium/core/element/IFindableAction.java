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
package com.github.wasiqb.coteafs.selenium.core.element;

import java.util.List;

import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

import org.openqa.selenium.By;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 */
public interface IFindableAction extends IKeyboardActions {
    /**
     * @author Wasiq Bhamla
     * @param <E>
     * @since 27-Jul-2019
     * @param byLocator locator
     * @param name
     * @return actions
     */
    <E extends IMouseActions> E find (final By byLocator, final String name);

    /**
     * @author Wasiq Bhamla
     * @param <E>
     * @since 27-Jul-2019
     * @param byLocator locator
     * @param name
     * @param strategy wait strategy
     * @return list of actions
     */
    <E extends IMouseActions> E find (final By byLocator, final String name, WaitStrategy strategy);

    /**
     * @author Wasiq Bhamla
     * @param <E>
     * @since 27-Jul-2019
     * @param byLocator locator
     * @param name
     * @return list of actions
     */
    <E extends IMouseActions> List<E> finds (final By byLocator, final String name);

    /**
     * @author Wasiq Bhamla
     * @param <E>
     * @since 27-Jul-2019
     * @param byLocator locator
     * @param name
     * @param strategy wait strategy
     * @return list of actions
     */
    <E extends IMouseActions> List<E> finds (final By byLocator, final String name, WaitStrategy strategy);
}