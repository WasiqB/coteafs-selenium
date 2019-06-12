package com.github.wasiqb.coteafs.selenium.core.element;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface IWaitStrategy {
	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param attribute
	 * @param value
	 */
	void waitUntilAttributeIs (final String attribute, final String value);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 */
	void waitUntilClickable ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 */
	void waitUntilInvisible ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 */
	void waitUntilVisible ();
}