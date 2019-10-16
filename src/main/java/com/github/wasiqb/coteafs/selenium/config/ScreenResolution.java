/*
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.config;

import com.github.wasiqb.coteafs.config.util.BasePojo;

/**
 * @author Wasiq Bhamla
 * @since 28 Apr 2019
 */
public class ScreenResolution extends BasePojo {
    private int height;
    private int width;

    /**
     * @author Wasiq Bhamla
     * @since 28 Apr 2019
     */
    public ScreenResolution () {
        this.width = 1366;
        this.height = 1024;
    }

    /**
     * @author Wasiq Bhamla
     * @return height
     * @since 28 Apr 2019
     */
    public int getHeight () {
        return this.height;
    }

    /**
     * @author Wasiq Bhamla
     * @return width
     * @since 28 Apr 2019
     */
    public int getWidth () {
        return this.width;
    }

    /**
     * @author Wasiq Bhamla
     * @param height height
     * @since 28 Apr 2019
     */
    public void setHeight (final int height) {
        this.height = height;
    }

    /**
     * @author Wasiq Bhamla
     * @param width width
     * @since 28 Apr 2019
     */
    public void setWidth (final int width) {
        this.width = width;
    }

    @Override
    public String toString () {
        return String.format ("%dx%d", this.width, this.height);
    }
}