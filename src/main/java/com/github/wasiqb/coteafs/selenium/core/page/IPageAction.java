package com.github.wasiqb.coteafs.selenium.core.page;

/**
 * @author Wasiq Bhamla
 * @since 08-Jun-2019
 */
public interface IPageAction {
	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @param <T>
	 * @param element
	 * @param value
	 * @return page action
	 */
	<T extends IPageAction> T addInputValue (final String element, final Object value);

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 */
	void perform ();

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @param <T>
	 * @param element
	 * @return input value
	 */
	<T> T value (final String element);
}