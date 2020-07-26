package com.github.wasiqb.coteafs.selenium.pages.action;

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.DropDownPage;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 */
public class DropDownPageAction extends AbstractPageAction <DropDownPageAction> {
    @Override
    public void perform () {
        final DropDownPage dropDown = new DropDownPage ();

        final String dropDownOption = value (DropDownPage.DropDownKeys.OPTION);
        dropDown.dropDownField ()
            .selectByText (dropDownOption);

        dropDown.dropDownField ()
            .selectedOptions ()
            .get (0)
            .verifyText ()
            .isEqualTo (dropDownOption);
    }
}