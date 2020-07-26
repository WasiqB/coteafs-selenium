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

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface IElementActions extends IWaitStrategy {
    /**
     * @param name attribute name
     *
     * @return attribute
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    String attribute (String name);

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    void clear ();

    /**
     * @return is displayed
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    boolean isDisplayed ();

    /**
     * @return is enabled
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    boolean isEnabled ();

    /**
     * @return is selected
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    boolean isSelected ();

    /**
     * @return text
     *
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    String text ();
}