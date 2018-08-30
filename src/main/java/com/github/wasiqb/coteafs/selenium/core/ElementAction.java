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
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.wasiqb.coteafs.selenium.config.ConfigUtil;
import com.github.wasiqb.coteafs.selenium.config.DelaySetting;

/**
 * @author Wasiq Bhamla
 * @since Aug 21, 2018 3:31:21 PM
 */
public class ElementAction {
	private final Actions				actions;
	private boolean						alreadyHighlighted;
	private final BrowserActions		browserAction;
	private By							by;
	private final DelaySetting			delays;
	private final EventFiringWebDriver	driver;
	private WebElement					element;
	private BrowserElement				locator;
	private String						style;
	private boolean						useBy;
	private final WebDriverWait			wait;

	/**
	 * @author Wasiq Bhamla
	 * @param browserAction
	 * @param element
	 * @since Aug 21, 2018 3:31:21 PM
	 */
	public ElementAction (final BrowserActions browserAction, final BrowserElement element) {
		this (browserAction);
		this.locator = element;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:18:37 PM
	 * @param browserAction
	 * @param by
	 */
	public ElementAction (final BrowserActions browserAction, final By by) {
		this (browserAction);
		this.by = by;
		this.useBy = true;
	}

	private ElementAction (final BrowserActions browserAction) {
		this.browserAction = browserAction;
		this.driver = browserAction.driver ();
		this.actions = new Actions (this.driver);
		this.wait = browserAction.driverWait ();
		this.alreadyHighlighted = false;
		this.delays = ConfigUtil.appSetting ()
				.getPlayback ()
				.getDelays ();
	}

	private ElementAction (final BrowserActions browserAction, final WebElement element) {
		this (browserAction);
		this.element = element;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 4:01:30 PM
	 * @param name
	 * @return attribute
	 */
	public String attribute (final String name) {
		return get (e -> e.getAttribute (name));
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 4:01:50 PM
	 */
	public void click () {
		perform (e -> {
			e.click ();
		});
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 4:02:12 PM
	 * @param text
	 */
	public void enterText (final String text) {
		perform (e -> {
			click ();
			e.clear ();
			e.sendKeys (text);
		});
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:46:09 PM
	 * @param byLocator
	 * @return child element.
	 */
	public ElementAction find (final By byLocator) {
		return get (e -> new ElementAction (this.browserAction, e.findElement (byLocator)));
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:46:27 PM
	 * @param byLocator
	 * @return list of children.
	 */
	public List <ElementAction> finds (final By byLocator) {
		return get (e -> e.findElements (byLocator)).stream ()
				.map (e -> new ElementAction (this.browserAction, e))
				.collect (Collectors.toList ());
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 4:03:13 PM
	 */
	public void hover () {
		perform (e -> {
			this.actions.moveToElement (e)
					.pause (ofMillis (this.delays.getBeforeMouseMove ()))
					.perform ();
		});
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:21:09 PM
	 * @return is displayed
	 */
	public boolean isDisplayed () {
		return get (WebElement::isDisplayed);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:21:20 PM
	 * @return is enabled
	 */
	public boolean isEnabled () {
		return get (WebElement::isEnabled);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:21:35 PM
	 * @return is selected
	 */
	public boolean isSelected () {
		return get (WebElement::isSelected);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:22:06 PM
	 * @param keys
	 */
	public void pressKey (final Keys... keys) {
		perform (e -> e.sendKeys (keys));
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:22:37 PM
	 * @param value
	 */
	public void select (final String value) {
		perform (e -> {
			click ();
			final List <WebElement> options = e.findElements (By.tagName ("option"));
			final Optional <WebElement> option = options.stream ()
					.filter (s -> s.getText ()
							.trim ()
							.equalsIgnoreCase (value))
					.findFirst ();
			if (option.isPresent ()) {
				new ElementAction (this.browserAction, option.get ()).click ();
			}
		});
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:23:06 PM
	 * @return text
	 */
	public String text () {
		return get (WebElement::getText);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:34:15 PM
	 * @param attribute
	 * @param value
	 */
	public void waitUntilAttributeIs (final String attribute, final String value) {
		if (this.useBy) {
			waitUntilLocatorAttributeIs (attribute, value);
		} else {
			this.wait.until (attributeToBe (this.element, attribute, value));
		}
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:34:26 PM
	 */
	public void waitUntilClickable () {
		if (this.useBy) {
			waitUntilLocatorClickable ();
		} else {
			this.wait.until (elementToBeClickable (this.element));
		}
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 9:34:22 PM
	 */
	public void waitUntilInvisible () {
		if (this.useBy) {
			waitUntilLocatorInvisible ();
		} else {
			this.wait.until (invisibilityOf (this.element));
		}
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Aug 21, 2018 8:23:15 PM
	 */
	public void waitUntilVisible () {
		if (this.useBy) {
			waitUntilLocatorVisible ();
		} else {
			this.wait.until (visibilityOf (this.element));
		}
	}

	private <T> T get (final Function <WebElement, T> func) {
		prepareForAction ("green");
		return func.apply (this.element);
	}

	private void highlight (final String color) {
		if (!this.alreadyHighlighted) {
			this.style = this.element.getAttribute ("style");
			this.browserAction.executeScript (
					"arguments[0].setAttribute('style', arguments[1] + arguments[2]);",
					this.element, this.style, format ("color: {0}; border: 3px solid {0};", color));
		}
	}

	private void perform (final Consumer <WebElement> action) {
		prepareForAction ("red");
		action.accept (this.element);
	}

	private void prepareForAction (final String color) {
		this.element = this.browserAction.find (this.locator);
		scrollIntoView ();
		highlight (color);
		unhighlight ();
	}

	private void scrollIntoView () {
		final String script = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);\n"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;\n"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		this.browserAction.executeScript (script, this.element);
	}

	private void unhighlight () {
		if (!this.alreadyHighlighted) {
			this.browserAction.executeScript ("arguments[0].setAttribute('style', arguments[1]);",
					this.element, this.style);
			this.alreadyHighlighted = true;
		}
	}

	private void waitUntilLocatorAttributeIs (final String attribute, final String value) {
		this.wait.until (attributeToBe (this.by, attribute, value));
	}

	private void waitUntilLocatorClickable () {
		this.element = this.wait.until (elementToBeClickable (this.by));
	}

	private void waitUntilLocatorInvisible () {
		this.wait.until (invisibilityOfElementLocated (this.by));
	}

	private void waitUntilLocatorVisible () {
		this.element = this.wait.until (visibilityOfElementLocated (this.by));
	}
}