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
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @param name attribute name
     * @return attribute
     */
    String attribute (String name);

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     */
    void clear ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return is displayed
     */
    boolean isDisplayed ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return is enabled
     */
    boolean isEnabled ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return is selected
     */
    boolean isSelected ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return text
     */
    String text ();
}