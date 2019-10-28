/*
 * Copyright (c) 2019, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core.driver;

import java.io.File;

/**
 * @author Wasiq Bhamla
 * @since 03-Jul-2019
 */
public interface IScreenAction {
    /**
     * @author Wasiq Bhamla
     * @since 06-Jun-2019
     * @return screenshot
     */
    byte [] attachScreenshot ();

    /**
     * @author Wasiq Bhamla
     * @return file
     * @since 25-Jul-2019
     */
    File saveScreenshot ();

    /**
     * @author Wasiq Bhamla
     * @param path
     * @return file
     * @since 25-Jul-2019
     */
    File saveScreenshot (String path);

    /**
     * @author Wasiq Bhamla
     * @since 27-Oct-2019
     */
    void startRecording ();

    /**
     * @author Wasiq Bhamla
     * @since 27-Oct-2019
     */
    void stopRecording ();
}