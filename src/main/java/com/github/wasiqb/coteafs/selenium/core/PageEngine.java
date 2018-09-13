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

import static java.lang.String.format;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.config.loader.ConfigLoader;
import com.github.wasiqb.coteafs.selenium.config.DataCategory;
import com.github.wasiqb.coteafs.selenium.config.ElementObject;
import com.github.wasiqb.coteafs.selenium.config.ElementType;
import com.github.wasiqb.coteafs.selenium.config.LocatorType;

/**
 * @author wasiqb
 * @since Sep 10, 2018 5:51:53 PM
 */
public final class PageEngine {
	/**
	 * @author wasiqb
	 * @since Sep 11, 2018 11:05:46 PM
	 * @param pageFile
	 */
	public static void fill (final String pageFile) {
		final PageEngine engine = new PageEngine (pageFile);
		final BrowserPage page = new BrowserPage ();
		for (final String name : engine.data.getDatas ()
				.keySet ()) {
			final Object value = engine.data.getData (name);
			final ElementObject element = engine.page.find (name);
			final ElementAction action = page
					.interact (getBy (element.getLocatorType (), element.getLocator ()));
			performAction (action, element.getElementType (), value);
		}
	}

	private static By getBy (final LocatorType locatorType, final String locator) {
		switch (locatorType) {
			case ID:
				return By.id (locator);
			case CLASS:
				return By.className (locator);
			case CSS:
				return By.cssSelector (locator);
			case LINK_TEXT:
				return By.linkText (locator);
			case NAME:
				return By.name (locator);
			case PARTIAL_LINK_TEXT:
				return By.partialLinkText (locator);
			case TAG:
				return By.tagName (locator);
			case XPATH:
			default:
				return By.xpath (locator);
		}
	}

	private static void performAction (final ElementAction action, final ElementType elementType,
			final Object value) {
		switch (elementType) {
			case CHECK:
			case RADIO:
				if (value instanceof Boolean && !action.isSelected ()) {
					action.click ();
				}
				break;
			case LINK:
				action.click ();
				break;
			case SELECT:
				action.select (value.toString ());
				break;
			case TEXT:
			default:
				action.enterText (value.toString ());
				break;
		}
	}

	private final DataCategory	data;
	private final ElementObject	page;

	private PageEngine (final String page) {
		final String pagePath = format ("/externs/pages/%s.yaml", page);
		final String dataPath = format ("/externs/structs/%s.yaml", page);
		this.page = ConfigLoader.settings ()
				.withDefault (pagePath)
				.load (ElementObject.class);
		this.data = ConfigLoader.settings ()
				.withDefault (dataPath)
				.load (DataCategory.class);
	}
}