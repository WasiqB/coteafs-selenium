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
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

/**
 * @author Wasiq Bhamla
 * @param <D>
 * @since 27-Sep-2019
 */
public class DriverSession<D extends WebDriver> {
    private final Map<String, Object> context;
    private D                         driver;

    /**
     * @author Wasiq Bhamla
     * @param driver
     * @since 28-Sep-2019
     */
    public DriverSession (final D driver) {
        this.driver = driver;
        this.context = new HashMap<> ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     */
    public void clearContext () {
        this.context.clear ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     */
    public void close () {
        clearContext ();
        this.driver.quit ();
        this.driver = null;
    }

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     * @param <T>
     * @param key
     * @return context
     */
    @SuppressWarnings ("unchecked")
    public <T> T getContext (final String key) {
        return (T) this.context.get (key);
    }

    /**
     * @author Wasiq Bhamla
     * @since 27-Sep-2019
     * @return the driver
     */
    public D getDriver () {
        return this.driver;
    }

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     * @param <T>
     * @param key
     * @param value
     */
    public <T> void setContext (final String key, final T value) {
        this.context.put (key, value);
    }

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     * @param driver the driver to set
     */
    public void setDriver (final D driver) {
        this.driver = driver;
    }
}