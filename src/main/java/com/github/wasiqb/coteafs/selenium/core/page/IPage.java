package com.github.wasiqb.coteafs.selenium.core.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IElementActions;

/**
 * @author Wasiq Bhamla
 * @param <B>
 * @param <E>
 * @param <T>
 * @since 08-Jun-2019
 */
public interface IPage <B extends IDriverActions, E extends WebElement, T extends IElementActions> {
	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @return driver action
	 */
	B onDriver ();

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @param locator
	 * @return element action
	 */
	T onElement (By locator);

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @param element
	 * @return element action
	 */
	T onElement (E element);
}