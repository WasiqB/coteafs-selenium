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

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ByIdOrName;

import com.github.wasiqb.coteafs.selenium.core.annotation.Find;
import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IElementActions;
import com.github.wasiqb.coteafs.selenium.core.page.IPage;

/**
 * @author Wasiq Bhamla
 * @since 09-Jun-2019
 */
public final class PageFactory {
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
		T extends IPage <D, E, A>> void findElements (final Find find, final Field field,
			final T page) {
		final ParameterizedType listType = (ParameterizedType) field.getGenericType ();
		final Type cls = listType.getActualTypeArguments () [0];
		if (IElementActions.class.isAssignableFrom (cls.getClass ())) {
			// TODO: WIll be done later.
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
			final Class <?> type = field.getType ();
			if (List.class.isAssignableFrom (type)) {
				findElements (find, field, page);
			}
			else {
				findElement (find, field, page, parentValue);
			}
		}
	}

	private static <D extends IDriverActions, E extends WebElement, A extends IElementActions,
		T extends IPage <D, E, A>> Field getField (final T page, final String name) {
		try {
			return page.getClass ()
				.getDeclaredField (name);
		}
		catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace ();
		}
		return null;
	}

	private static By getLocator (final Find find) {
		switch (find.strategy ()) {
			case CLASS_NAME:
				return By.className (find.locator ());
			case CSS:
				return By.cssSelector (find.locator ());
			case ID:
				return By.id (find.locator ());
			case ID_OR_NAME:
				return new ByIdOrName (find.locator ());
			case LINK_TEXT:
				return By.linkText (find.locator ());
			case NAME:
				return By.name (find.locator ());
			case PARTIAL_LINK_TEXT:
				return By.partialLinkText (find.locator ());
			case TAG_NAME:
				return By.tagName (find.locator ());
			case XPATH:
				return By.xpath (find.locator ());
			case UNSET:
			default:
				break;
		}
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
			e.printStackTrace ();
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
			e.printStackTrace ();
		}
		finally {
			field.setAccessible (false);
		}
	}

	private PageFactory () {
		// Utility class.
	}
}