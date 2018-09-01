/**
 * Copyright (c) 2017 - 2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wasiqb
 * @since Sep 1, 2018 4:28:28 PM
 */
public abstract class BrowserPageAction {
	private final Map <String, Object> values;

	/**
	 * @author wasiqb
	 * @since Sep 1, 2018 8:04:10 PM
	 */
	public BrowserPageAction () {
		this.values = new HashMap <> ();
	}

	/**
	 * @author wasiqb
	 * @since Sep 1, 2018 8:05:35 PM
	 * @param element
	 * @param value
	 * @return instance
	 */
	public BrowserPageAction addInputValue (final String element, final Object value) {
		this.values.put (element, value);
		return this;
	}

	/**
	 * @author wasiqb
	 * @since Sep 1, 2018 8:07:57 PM
	 */
	public abstract void perform ();

	@SuppressWarnings ("unchecked")
	protected <T> T value (final String element) {
		return (T) this.values.get (element);
	}
}