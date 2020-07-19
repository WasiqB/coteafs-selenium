package com.github.wasiqb.coteafs.selenium.pages;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.BrowserPage;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectboxActions;
import com.github.wasiqb.coteafs.selenium.core.page.ElementKey;

/**
 * @author Faisal Khatri
 * @since Jul 19, 2020
 *
 */
public class DropdownPage extends BrowserPage {

	/**
	 * @author Faisal Khatri
	 * @since Jul 19, 2020
	 *
	 */
	public enum DropdownKeys implements ElementKey {

		/**
		 * @author Faisal Khatri
		 * @since Jul 19, 2020
		 */
		OPTION (" ");

		String key;

		private DropdownKeys (final String key) {
			this.key = key;
		}

		@Override
		public String getKey () {
			return this.key;
		}

	}

	/**
	 * @author Faisal Khatri
	 * @since Jul 19, 2020
	 * @return dropdown field
	 */
	public ISelectboxActions dropdownField () {
		return onDropdown (By.id ("dropdown"), "Dropdown List");

	}

}
