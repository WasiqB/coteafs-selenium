package com.github.wasiqb.coteafs.selenium.core.element;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface ISelectboxActions extends IKeyboardActions {
	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param text
	 */
	void deselect (String text);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 */
	void deselectAll ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param text
	 */
	void select (String text);
}