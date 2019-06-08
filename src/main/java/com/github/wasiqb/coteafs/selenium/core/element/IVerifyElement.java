package com.github.wasiqb.coteafs.selenium.core.element;

import com.google.common.truth.BooleanSubject;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface IVerifyElement {
	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param attribute
	 * @return subject
	 */
	StringSubject verifyAttribute (final String attribute);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return subject
	 */
	BooleanSubject verifyDisplayed ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return subject
	 */
	BooleanSubject verifyEnabled ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return subject
	 */
	BooleanSubject verifySelected ();

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @return subject
	 */
	StringSubject verifyText ();
}