package com.github.wasiqb.coteafs.selenium.pages.action;

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.DropdownPage;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 */
public class DropdownPageAction extends AbstractPageAction<DropdownPageAction> {

    @Override
    public void perform () {
        final DropdownPage dropdown = new DropdownPage ();

        final String dropdownOption = value (DropdownPage.DropdownKeys.OPTION);
        dropdown.dropdownField ()
            .selectByText (dropdownOption);

        dropdown.dropdownField ()
            .selectedOptions ()
            .get (0)
            .verifyText ()
            .isEqualTo (dropdownOption);
    }

}
