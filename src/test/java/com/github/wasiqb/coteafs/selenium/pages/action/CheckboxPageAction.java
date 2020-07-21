package com.github.wasiqb.coteafs.selenium.pages.action;

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.CheckboxPage;
import com.github.wasiqb.coteafs.selenium.pages.CheckboxPage.CheckboxPageKeys;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 */
public class CheckboxPageAction extends AbstractPageAction<CheckboxPageAction> {

    @Override
    public void perform () {
        final CheckboxPage checkbox = new CheckboxPage ();

        final String checkValue = (value (CheckboxPageKeys.CHECK));
        switch (checkValue) {
            case "check":
                checkbox.checkBoxOne ()
                    .click ();
                checkbox.checkBoxOne ()
                    .verifySelected ()
                    .isTrue ();
                checkbox.checkBoxTwo ()
                    .verifySelected ()
                    .isTrue ();
                break;

            case "uncheck":
            default:
                checkbox.checkBoxTwo ()
                    .click ();

                checkbox.checkBoxOne ()
                    .verifySelected ()
                    .isFalse ();
                checkbox.checkBoxTwo ()
                    .verifySelected ()
                    .isFalse ();
                break;

        }
    }

}