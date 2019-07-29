/*
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
package com.github.wasiqb.coteafs.selenium.config;

/**
 * @author wasiqb
 * @since Sep 10, 2018 5:48:30 PM
 */
public class DataSet {
	private String	name;
	private Object	value;

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:48:55 PM
	 * @return the name
	 */
	public String getName () {
		return this.name;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:48:55 PM
	 * @return the value
	 */
	public Object getValue () {
		return this.value;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:48:55 PM
	 * @param name
	 *     the name to set
	 */
	public void setName (final String name) {
		this.name = name;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:48:55 PM
	 * @param value
	 *     the value to set
	 */
	public void setValue (final Object value) {
		this.value = value;
	}
}