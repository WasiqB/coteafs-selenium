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

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import org.openqa.selenium.By;

/**
 * @author wasiqb
 */
public class MainPage extends BrowserPage {

    /**
     * @param name link name
     *
     * @return menu name
     */
    public IMouseActions links (final String name) {
        return navigationLinks ().finds (By.cssSelector ("li > a"), name)
            .stream ()
            .filter (m -> m.text ()
                .trim ()
                .equals (name))
            .findFirst ()
            .get ();
    }

    private IMouseActions navigationLinks () {
        return onClickable (By.cssSelector ("div#content ul"), "Links");
    }
}