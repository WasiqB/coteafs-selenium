package com.github.wasiqb.coteafs.selenium.pages.action;

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

			checkbox.checkBoxOne ()
				.verifySelected ()
				.isTrue ();
			checkbox.checkBoxTwo ()
				.verifySelected ()
				.isTrue ();

		}
		else if (value (CheckboxPageKeys.CHECK).equals ("uncheck")) {
			checkbox.checkBoxTwo ()
				.click ();

			checkbox.checkBoxOne ()
				.verifySelected ()
				.isFalse ();
			checkbox.checkBoxTwo ()
				.verifySelected ()
				.isFalse ();

		}
		else {
			Assert.fail ("Test failed as invalid  test data is not supplied!");
		}

	}

}