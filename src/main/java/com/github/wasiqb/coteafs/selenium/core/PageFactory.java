/**
 * Copyright (c) 2019, Wasiq Bhamla.
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

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.wasiqb.coteafs.selenium.core.annotation.Find;
import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IElementActions;
import com.github.wasiqb.coteafs.selenium.core.page.IPage;

/**
 * @author Wasiq Bhamla
 * @since 09-Jun-2019
 */
public final class PageFactory {
	private static final Logger LOG = LogManager.getLogger (PageFactory.class);

	/**
	 * @author Wasiq Bhamla
	 * @since 09-Jun-2019
	 * @param <D>
	 * @param <E>
	 * @param <A>
	 * @param <T>
	 * @param page
	 */
	public static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> void init (final T page) {
		LOG.info ("Finding elements available on the page.");
		final Field [] fields = page.getClass ()
			.getDeclaredFields ();
		for (final Field field : fields) {
			findForField (page, field);
		}
	}

	private static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> void findElement (final Find find, final Field field,
			final T page, final A parent) {
		if (IElementActions.class.isAssignableFrom (field.getType ())) {
			if (parent == null) {
				setField (page, field, page.onElement (getLocator (find)));
			}
			else {
				setField (page, field, parent.find (getLocator (find)));
			}
		}
	}

	private static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> void findForField (final T page, final Field field) {
		if (field.isAnnotationPresent (Find.class)) {
			final Find find = field.getAnnotation (Find.class);
			final String parent = find.parent ();
			A parentValue = getValue (parent, page);
			if (!StringUtils.isEmpty (parent) && parentValue == null) {
				final Field parentField = getField (page, parent);
				findForField (page, parentField);
				parentValue = getValue (parent, page);
			}
			LOG.info ("Finding element {} using locator {}.", field.getName (), getLocator (find));
			findElement (find, field, page, parentValue);
		}
	}

	private static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> Field getField (final T page, final String name) {
		try {
			return page.getClass ()
				.getDeclaredField (name);
		}
		catch (NoSuchFieldException | SecurityException e) {
			LOG.error ("Error occurred while getting field info.");
			LOG.catching (e);
		}
		return null;
	}

	private static By getLocator (final Find find) {
		if (isNotEmpty (find.id ())) return By.id (find.id ());
		if (isNotEmpty (find.className ())) return By.className (find.className ());
		if (isNotEmpty (find.name ())) return By.name (find.name ());
		if (isNotEmpty (find.tagName ())) return By.tagName (find.tagName ());
		if (isNotEmpty (find.linkText ())) return By.linkText (find.linkText ());
		if (isNotEmpty (find.partialLinkText ()))
			return By.partialLinkText (find.partialLinkText ());
		if (isNotEmpty (find.css ())) return By.cssSelector (find.css ());
		if (isNotEmpty (find.xpath ())) return By.xpath (find.xpath ());
		LOG.fatal (
			"No locator info found. Kindly set proper locator details to find the element...");
		return null;
	}

	@SuppressWarnings ("unchecked")
	private static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> A getValue (final String parent, final T page) {
		if (StringUtils.isEmpty (parent)) return null;
		Field field = null;
		try {
			field = getField (page, parent);
			if (!field.isAccessible ()) {
				field.setAccessible (true);
			}
			return (A) field.get (page);
		}
		catch (IllegalArgumentException | IllegalAccessException | SecurityException e) {
			LOG.error ("Error occurred while getting element field value.");
			LOG.catching (e);
		}
		finally {
			if (field != null) {
				field.setAccessible (false);
			}
		}
		return null;
	}

	private static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> void setField (final T page, final Field field,
			final A element) {
		try {
			if (!field.isAccessible ()) {
				field.setAccessible (true);
			}
			field.set (page, element);
		}
		catch (IllegalArgumentException | IllegalAccessException e) {
			LOG.error ("Error occurred while setting element field value.");
			LOG.catching (e);
		}
		finally {
			field.setAccessible (false);
		}
	}

	private PageFactory () {
		// Utility class.
	}
}