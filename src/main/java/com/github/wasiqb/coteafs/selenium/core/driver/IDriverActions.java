package com.github.wasiqb.coteafs.selenium.core.driver;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.wasiqb.coteafs.selenium.core.enums.AlertDecision;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since 06-Jun-2019
 */
public interface IDriverActions {
	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param decision
	 * @return message
	 */
	String alert (AlertDecision decision);

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return wait.
	 */
	WebDriverWait driverWait ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param <T>
	 * @param script
	 * @param args
	 * @return result
	 */
	<T> T execute (final String script, final Object... args);

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return is driver closed.
	 */
	boolean isClosed ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return screenshot
	 */
	byte [] saveScreenshot ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @return title
	 */
	String title ();

	/**
	 * @author Wasiq Bhamla
	 * @since 06-Jun-2019
	 * @param decision
	 * @return string subject
	 */
	StringSubject verifyAlertMessage (AlertDecision decision);

	/**
	 * @author Wasiq Bhamla
	 * @since 08-Jun-2019
	 * @return string subject
	 */
	StringSubject verifyTitle ();
}