package com.github.wasiqb.coteafs.selenium.core.driver;

/**
 * @author Wasiq Bhamla
 * @since 06-Jun-2019
 */
public interface IWebDriverActions extends IDriverActions {
	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void back ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void deleteCookies ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void forward ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param url
	 */
	void navigateTo (String url);

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void refresh ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void switchWindow ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param title
	 */
	void switchWindow (String title);
}