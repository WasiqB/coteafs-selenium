/*
 * Copyright (c) 2017 - 2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.pages;

import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;

import org.openqa.selenium.By;

/**
 * @author wasiqb
 * @since Apr 8, 2019 8:14:38 PM
 */
public abstract class SuccessPage extends MainPage {
    /**
     * @author wasiqb
     * @since Apr 8, 2019 9:43:54 PM
     * @return message
     */
    public IMouseActions message () {
        return cell (0, 0);
    }

    protected abstract IMouseActions successTable ();

    IMouseActions cell (final int row) {
        return cell (row, 1);
    }

    private IMouseActions cell (final int row, final int col) {
        return successTable ().finds (By.tagName ("tr"), "Row")
            .get (row)
            .finds (By.tagName ("td"), "Col")
            .get (col);
    }
}