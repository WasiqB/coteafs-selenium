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

import com.google.common.truth.BooleanSubject;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface IVerifyElement extends IElementActions {
    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @param attribute element attribute
     * @return subject
     */
    StringSubject verifyAttribute (final String attribute);

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return subject
     */
    BooleanSubject verifyDisplayed ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return subject
     */
    BooleanSubject verifyEnabled ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return subject
     */
    BooleanSubject verifySelected ();

    /**
     * @author Wasiq Bhamla
     * @since 07-Jun-2019
     * @return subject
     */
    StringSubject verifyText ();
}