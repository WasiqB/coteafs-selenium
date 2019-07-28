/*
 * Copyright (c) 2019, Wasiq Bhamla.
 *  
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  
 *          http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.wasiqb.coteafs.selenium.core.base.element;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IFindableAction;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <E>
 * @param <D>
 * @param <B>
 */
@SuppressWarnings ("unchecked")
public class FinadableAction <E extends WebElement, D extends WebDriver,
	B extends IDriverActions <D>> extends BaseElementAction <E, D, B> implements IFindableAction {
	FinadableAction (final B browserAction, final By by, final WaitStrategy strategy) {
		super (browserAction, by, strategy);
	}

	FinadableAction (final B browserAction, final E element) {
		super (browserAction, element);
	}

	FinadableAction (final B browserAction, final By by) {
		super (browserAction, by);
	}

	FinadableAction (final B browserAction, final E element, final WaitStrategy strategy) {
		super (browserAction, element, strategy);
	}

	@Override
	public <E extends IFindableAction> E find (final By byLocator, final WaitStrategy strategy) {
		waitForStrategy (byLocator, strategy);
		return get (
			e -> (E) new FinadableAction <> (this.browserAction, e.findElement (byLocator)));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IFindableElement#find(org.openqa.
	 * selenium.By)
	 */
	@Override
	public <E extends IFindableAction> E find (final By byLocator) {
		return get (
			e -> (E) new FinadableAction <> (this.browserAction, e.findElement (byLocator)));
	}

	@Override
	public <E extends IFindableAction> List <E> finds (final By byLocator,
		final WaitStrategy strategy) {
		waitForStrategy (byLocator, strategy);
		return get (e -> e.findElements (byLocator)).stream ()
			.map (e -> (E) new FinadableAction <> (this.browserAction, e))
			.collect (Collectors.toList ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IFindableElement#finds(org.openqa
	 * .selenium.By)
	 */
	@Override
	public <E extends IFindableAction> List <E> finds (final By byLocator) {
		return get (e -> e.findElements (byLocator)).stream ()
			.map (e -> (E) new FinadableAction <> (this.browserAction, e))
			.collect (Collectors.toList ());
	}
}