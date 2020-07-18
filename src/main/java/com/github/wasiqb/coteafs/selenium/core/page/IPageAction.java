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

/**
 * @author Wasiq Bhamla
 * @since 08-Jun-2019
 */
public interface IPageAction {
    /**
     * @param <T>
     *     page action
     * @param elementKey
     *     element alias
     * @param value
     *     element input value
     * @return page action
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T extends IPageAction> T addInputValue (final ElementKey elementKey, final Object value);

    /**
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    void perform ();

    /**
     * @param <T>
     *     input value
     * @param elementKey
     *     element alias
     * @return input value
     *
     * @author Wasiq Bhamla
     * @since 08-Jun-2019
     */
    <T> T value (final ElementKey elementKey);
}