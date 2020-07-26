package com.github.wasiqb.coteafs.selenium.pages;

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.page.ElementKey;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 */
public class CheckboxPage extends BrowserPage {
    /**
     * @author Faisal Khatri
     * @since Jul 19, 2020
     */
    public enum CheckboxPageKeys implements ElementKey {
        /**
         * @since Jul 19, 2020
         */
        CHECK ("check");

        String key;

        CheckboxPageKeys (final String key) {
            this.key = key;
        }

        @Override
        public String getKey () {
            return this.key;
        }
    }

    /**
     * @return checkbox 1
     *
     * @since Jul 19, 2020
     */
    public IMouseActions checkBoxOne () {
        return onClickable (By.cssSelector ("#checkboxes > input[type=checkbox]:nth-child(1)"), "Checkbox 1");
    }

    /**
     * @return checkbox 2
     *
     * @since Jul 19, 2020
     */
    public IMouseActions checkBoxTwo () {
        return onClickable (By.cssSelector ("#checkboxes > input[type=checkbox]:nth-child(3)"), "Checkbox 2");
    }
}