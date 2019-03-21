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
 * @author Wasiq Bhamla
 * @since Aug 18, 2018 10:46:12 PM
 */
@Deprecated
public class BrowserElement {
	/**
	 * @author Wasiq Bhamla
	 * @param name
	 * @since Aug 18, 2018 10:49:26 PM
	 * @param tag
	 * @return instance
	 */
	public static BrowserElement create (final String name, final String tag) {
		return new BrowserElement (name, tag);
	}

	private final Map <String, String>	attributes;
	private int							index;
	private final String				name;
	private BrowserElement				parent;
	private final String				tagName;

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 10:46:12 PM
	 */
	private BrowserElement (final String name, final String tagName) {
		this.name = name;
		this.tagName = tagName;
		this.attributes = new HashMap <> ();
		this.index = 0;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 11:00:16 PM
	 * @return attributes
	 */
	public Map <String, String> attributes () {
		return this.attributes;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 10:57:12 PM
	 * @return index
	 */
	public int index () {
		return this.index;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 10:56:38 PM
	 * @param id
	 * @return instance
	 */
	public BrowserElement index (final int id) {
		this.index = id;
		return this;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 20, 2018 10:01:38 PM
	 * @return name
	 */
	public String name () {
		return this.name;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:36:49 PM
	 * @return parent
	 */
	public BrowserElement parent () {
		return this.parent;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:36:14 PM
	 * @param ancestor
	 * @return instance
	 */
	public BrowserElement parent (final BrowserElement ancestor) {
		this.parent = ancestor;
		return this;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 10:55:01 PM
	 * @return tag
	 */
	public String tagName () {
		return this.tagName;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString () {
		final StringBuilder sb = new StringBuilder (this.tagName);
		for (final String key : this.attributes.keySet ()) {
			if (key.equals ("id")) {
				sb.append ("#")
					.append (this.attributes.get (key));
				continue;
			}
			else if (key.equals ("class")) {
				sb.append (".")
					.append (this.attributes.get (key));
				continue;
			}
			sb.append ("[")
				.append (key)
				.append ("='")
				.append (this.attributes.get (key))
				.append ("']");
		}
		return sb.toString ();
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 18, 2018 10:50:29 PM
	 * @param attr
	 * @param value
	 * @return instance
	 */
	public BrowserElement withAttr (final String attr, final String value) {
		this.attributes.put (attr, value);
		return this;
	}
}