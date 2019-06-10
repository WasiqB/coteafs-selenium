/**
 * Copyright (c) 2017, Wasiq Bhamla.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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