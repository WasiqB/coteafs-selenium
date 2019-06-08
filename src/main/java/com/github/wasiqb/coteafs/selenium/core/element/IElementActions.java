package com.github.wasiqb.coteafs.selenium.core.element;

import java.util.List;

import org.openqa.selenium.By;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface IElementActions extends IVerifyElement, IWaitStrategy {
	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param name
	 * @return attribute
	 */
	String attribute (String name);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 */
	void clear ();

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @param byLocator
	 * @return actions
	 */
	<E extends IElementActions> E find (final By byLocator);

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @param byLocator
	 * @return list of actions
	 */
	<E extends IElementActions> List <E> finds (final By byLocator);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return is displayed
	 */
	boolean isDisplayed ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return is enabled
	 */
	boolean isEnabled ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return is selected
	 */
	boolean isSelected ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return text
	 */
	String text ();
}