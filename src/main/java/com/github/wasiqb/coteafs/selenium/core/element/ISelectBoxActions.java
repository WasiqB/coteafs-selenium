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
package com.github.wasiqb.coteafs.selenium.core.element;

import java.util.List;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface ISelectBoxActions extends IMouseActions {
    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    void deselectAll ();

    /**
     * @param index item indoex
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    void deselectByIndex (int index);

    /**
     * @param value item value
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    void deselectByText (String value);

    /**
     * @param value item value
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    void deselectByValue (String value);

    /**
     * @return is multi select
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    boolean isMultiSelect ();

    /**
     * @return all options
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends IMouseActions> List<T> options ();

    /**
     * @param index item indoex
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    void selectByIndex (int index);

    /**
     * @param value item value
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    void selectByText (String value);

    /**
     * @param value item value
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    void selectByValue (String value);

    /**
     * @param <T> Mouse action type
     *
     * @return all selected options
     *
     * @author Wasiq Bhamla
     * @since 12-Jul-2019
     */
    <T extends IMouseActions> List<T> selectedOptions ();
}