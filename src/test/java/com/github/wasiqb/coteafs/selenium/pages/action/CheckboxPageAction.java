package com.github.wasiqb.coteafs.selenium.pages.action;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.github.wasiqb.coteafs.selenium.core.page.AbstractPageAction;
import com.github.wasiqb.coteafs.selenium.pages.CheckboxPage;
import com.github.wasiqb.coteafs.selenium.pages.CheckboxPage.CheckboxPageKeys;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 *
 */
public class CheckboxPageAction extends AbstractPageAction <CheckboxPageAction> {

	@Override
	public void perform () {
		final CheckboxPage checkbox = new CheckboxPage ();
		if (value (CheckboxPageKeys.CHECK).equals ("check")) {
			checkbox.checkBoxOne ()
				.click ();
			assertTrue (checkbox.checkBoxOne ()
				.isSelected ());
			assertTrue (checkbox.checkBoxTwo ()
				.isSelected ());

		}
		else if (value (CheckboxPageKeys.CHECK).equals ("uncheck")) {
			checkbox.checkBoxTwo ()
				.click ();

			assertTrue (!checkbox.checkBoxOne ()
				.isSelected ());
			assertTrue (!checkbox.checkBoxTwo ()
				.isSelected ());

		}
		else {
			Assert.fail ("Test failed as test data is not supplied!");
		}

	}

}