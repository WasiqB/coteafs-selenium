package com.github.wasiqb.coteafs.selenium.core.element;

import org.openqa.selenium.Keys;

/**
 * @author Wasiq Bhamla
 * @since 08-Jun-2019
 */
public interface IKeyboardActions extends IMouseActions {
	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param keys
	 */
	void pressKey (Keys... keys);
}