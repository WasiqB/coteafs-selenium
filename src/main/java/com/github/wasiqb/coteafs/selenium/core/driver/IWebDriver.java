package com.github.wasiqb.coteafs.selenium.core.driver;

import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * @author Wasiq Bhamla
 * @since 06-Jun-2019
 */
public interface IWebDriver extends IDriver <EventFiringWebDriver> {
	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param browser
	 */
	void setBrowserUnderTest (String browser);
}