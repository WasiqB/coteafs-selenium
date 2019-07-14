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
package com.github.wasiqb.coteafs.selenium.core.element;

import java.util.List;

/**
 * @author Wasiq Bhamla
 * @since 07-Jun-2019
 */
public interface ISelectboxActions extends IKeyboardActions {
	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 */
	void deselectAll ();

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @param index
	 */
	void deselectByIndex (int index);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param value
	 */
	void deselectByText (String value);

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @param value
	 */
	void deselectByValue (String value);

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @return is multi select
	 */
	boolean isMultiSelect ();

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @return all options
	 */
	List <IElementActions> options ();

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @param index
	 */
	void selectByIndex (int index);

	/**
	 * @author Wasiq Bhamla
	 * @since 07-Jun-2019
	 * @param value
	 */
	void selectByText (String value);

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @param value
	 */
	void selectByValue (String value);

	/**
	 * @author Wasiq Bhamla
	 * @since 12-Jul-2019
	 * @return all selected options
	 */
	List <IElementActions> selectedOptions ();
}