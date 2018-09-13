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
package com.github.wasiqb.coteafs.selenium.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wasiqb
 * @since Sep 9, 2018 4:22:37 PM
 */
public class ElementObject {
	private String					alias;
	private List <ElementObject>	children;
	private ElementType				elementType;
	private int						index;
	private String					locator;
	private LocatorType				locatorType;

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:22:37 PM
	 */
	public ElementObject () {
		this.children = new ArrayList <> ();
		this.index = 0;
	}

	/**
	 * @author wasiqb
	 * @since Sep 11, 2018 9:58:20 PM
	 * @param name
	 * @return element
	 */
	public ElementObject find (final String name) {
		if (this.alias.equals (name)) { return this; }
		for (final ElementObject element : this.children) {
			final ElementObject res = element.find (name);
			if (res != null) { return res; }
		}
		return null;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:28:17 PM
	 * @return the alias
	 */
	public String getAlias () {
		return this.alias;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @return the children
	 */
	public List <ElementObject> getChildren () {
		return this.children;
	}

	/**
	 * @author wasiqb
	 * @since Sep 11, 2018 10:03:13 PM
	 * @return the elementType
	 */
	public ElementType getElementType () {
		return this.elementType;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @return the index
	 */
	public int getIndex () {
		return this.index;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @return the locator
	 */
	public String getLocator () {
		return this.locator;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @return the locatorType
	 */
	public LocatorType getLocatorType () {
		return this.locatorType;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:28:17 PM
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias (final String alias) {
		this.alias = alias;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @param children
	 *            the children to set
	 */
	public void setChildren (final List <ElementObject> children) {
		this.children = children;
	}

	/**
	 * @author wasiqb
	 * @since Sep 11, 2018 10:03:13 PM
	 * @param elementType
	 *            the elementType to set
	 */
	public void setElementType (final ElementType elementType) {
		this.elementType = elementType;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @param index
	 *            the index to set
	 */
	public void setIndex (final int index) {
		this.index = index;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @param locator
	 *            the locator to set
	 */
	public void setLocator (final String locator) {
		this.locator = locator;
	}

	/**
	 * @author wasiqb
	 * @since Sep 10, 2018 5:21:58 PM
	 * @param locatorType
	 *            the locatorType to set
	 */
	public void setLocatorType (final LocatorType locatorType) {
		this.locatorType = locatorType;
	}
}