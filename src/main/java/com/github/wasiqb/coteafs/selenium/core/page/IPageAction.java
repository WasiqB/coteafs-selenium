/*
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
	 *     page action
	 * @param element
	 *     element alias
	 * @param value
	 *     element input value
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
	 *     input value
	 * @param element
	 *     element alias
	 * @return input value
	 */
	<T> T value (final String element);
}