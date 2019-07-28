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
import org.openqa.selenium.support.ui.Select;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IMouseActions;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectboxActions;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <E>
 * @param <D>
 * @param <B>
 */
public class SelectboxAction <E extends WebElement, D extends WebDriver,
	B extends IDriverActions <D>> extends KeyboardAction <E, D, B> implements ISelectboxActions {
	protected SelectboxAction (final B browserAction, final By by, final WaitStrategy strategy) {
		super (browserAction, by, strategy);
	}

	protected SelectboxAction (final B browserAction, final E element) {
		super (browserAction, element);
	}

	protected SelectboxAction (final B browserAction, final By by) {
		super (browserAction, by);
	}

	protected SelectboxAction (final B browserAction, final E element,
		final WaitStrategy strategy) {
		super (browserAction, element, strategy);
	}

	@Override
	public void deselectAll () {
		perform (e -> {
			final Select select = new Select (e);
			select.deselectAll ();
		});
	}

	@Override
	public void deselectByIndex (final int index) {
		perform (e -> {
			final Select select = new Select (e);
			select.deselectByIndex (index);
		});
	}

	@Override
	public void deselectByText (final String value) {
		perform (e -> {
			final Select select = new Select (e);
			select.deselectByVisibleText (value);
		});
	}

	@Override
	public void deselectByValue (final String value) {
		perform (e -> {
			final Select select = new Select (e);
			select.deselectByValue (value);
		});
	}

	@Override
	public boolean isMultiSelect () {
		return get (e -> {
			final Select select = new Select (e);
			return select.isMultiple ();
		});
	}

	@Override
	public List <IMouseActions> options () {
		return get (e -> {
			final Select select = new Select (e);
			return select.getOptions ()
				.stream ()
				.map (o -> new MouseAction <> (this.browserAction, o))
				.collect (Collectors.toList ());
		});
	}

	@Override
	public void selectByIndex (final int index) {
		perform (e -> {
			final Select select = new Select (e);
			select.selectByIndex (index);
		});
	}

	@Override
	public void selectByText (final String value) {
		perform (e -> {
			final Select select = new Select (e);
			select.selectByVisibleText (value);
		});
	}

	@Override
	public void selectByValue (final String value) {
		perform (e -> {
			final Select select = new Select (e);
			select.selectByValue (value);
		});
	}

	@Override
	public List <IMouseActions> selectedOptions () {
		return get (e -> {
			final Select select = new Select (e);
			return select.getAllSelectedOptions ()
				.stream ()
				.map (o -> new MouseAction <> (this.browserAction, o))
				.collect (Collectors.toList ());
		});
	}
}