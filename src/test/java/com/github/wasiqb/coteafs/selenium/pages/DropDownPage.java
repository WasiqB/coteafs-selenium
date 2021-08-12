package com.github.wasiqb.coteafs.selenium.pages;

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectBoxActions;
import com.github.wasiqb.coteafs.selenium.core.page.ElementKey;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 */
public class DropDownPage extends BrowserPage {
    /**
     * @author Faisal Khatri
     * @since Jul 19, 2020
     */
    public enum DropDownKeys implements ElementKey {
        /**
         * @since Jul 19, 2020
         */
        OPTION ("Option");

        String key;

        DropDownKeys (final String key) {
            this.key = key;
        }

        @Override
        public String getKey () {
            return this.key;
        }
    }

    /**
     * @return dropdown field
     *
     * @since Jul 19, 2020
     */
    public ISelectBoxActions dropDownField () {
        return onDropdown (By.id ("dropdown"), "DropDown List");
    }
}