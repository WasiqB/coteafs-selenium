package com.github.wasiqb.coteafs.selenium.core.driver;

import org.openqa.selenium.WebDriver;

import com.github.wasiqb.coteafs.selenium.core.enums.ApplicationType;
import com.github.wasiqb.coteafs.selenium.core.enums.Platform;
import com.github.wasiqb.coteafs.selenium.core.enums.PlatformOs;

/**
 * @author Wasiq Bhamla
 * @param <D>
 * @since 06-Jun-2019
 */
public interface IDriver <D extends WebDriver> {
	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return application type.
	 */
	ApplicationType getApplicationType ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return driver
	 */
	D getDriver ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return platform
	 */
	Platform getPlatform ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return platform os.
	 */
	PlatformOs getPlatformOs ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param <T>
	 * @return actions
	 */
	<T extends IDriverActions> T interact ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void start ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 */
	void stop ();
}