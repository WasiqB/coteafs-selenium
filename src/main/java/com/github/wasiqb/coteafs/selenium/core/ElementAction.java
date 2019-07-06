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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.lang.Thread.sleep;
import static java.text.MessageFormat.format;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.wasiqb.coteafs.selenium.config.ConfigUtil;
import com.github.wasiqb.coteafs.selenium.config.DelaySetting;
import com.github.wasiqb.coteafs.selenium.core.element.ISelectboxActions;
import com.github.wasiqb.coteafs.selenium.core.element.ITextboxActions;
import com.google.common.truth.BooleanSubject;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since Aug 21, 2018 3:31:21 PM
 */
public class ElementAction implements ISelectboxActions, ITextboxActions {
	private static final Logger LOG = LogManager.getLogger (ElementAction.class);

	private static void pause (final long delay) {
		try {
			sleep (delay);
		}
		catch (final InterruptedException e) {
			LOG.error ("Error while pausing: {}", e.getMessage ());
			Thread.currentThread ()
				.interrupt ();
		}
	}

	private final Actions				actions;
	private boolean						alreadyHighlighted;
	private final BrowserActions		browserAction;
	private By							by;
	private final DelaySetting			delays;
	private final EventFiringWebDriver	driver;
	private WebElement					element;
	private String						style;
	private boolean						useBy;
	private final WebDriverWait			wait;

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

	/**
	 * @author wasiqb
	 * @since Mar 21, 2019 10:16:16 PM
	 * @param browserAction
	 * @param element
	 */
	public ElementAction (final BrowserActions browserAction, final WebElement element) {
		this (browserAction);
		this.element = element;
		this.useBy = false;
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

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IElementActions#attribute(java.
	 * lang.String)
	 */
	@Override
	public String attribute (final String name) {
		return get (e -> e.getAttribute (name));
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IElementActions#clear()
	 */
	@Override
	public void clear () {
		perform (WebElement::clear);
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IMouseActions#click()
	 */
	@Override
	public void click () {
		perform (e -> {
			pause (this.delays.getBeforeClick ());
			e.click ();
			pause (this.delays.getAfterClick ());
		});
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.ISelectboxActions#deselect(java.
	 * lang.String)
	 */
	@Override
	public void deselect (final String text) {
		final Select select = new Select (this.element);
		select.deselectByValue (text);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.ISelectboxActions#deselectAll()
	 */
	@Override
	public void deselectAll () {
		final Select select = new Select (this.element);
		select.deselectAll ();
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.ITextboxActions#enterText(java.
	 * lang.String)
	 */
	@Override
	public void enterText (final String text) {
		perform (e -> {
			if (StringUtils.isNoneEmpty (text)) {
				pause (this.delays.getBeforeTyping ());
				e.sendKeys (text);
				pause (this.delays.getAfterTyping ());
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IFindableElement#find(org.openqa.
	 * selenium.By)
	 */
	@Override
	@SuppressWarnings ("unchecked")
	public ElementAction find (final By byLocator) {
		return get (e -> new ElementAction (this.browserAction, e.findElement (byLocator)));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IFindableElement#finds(org.openqa
	 * .selenium.By)
	 */
	@Override
	@SuppressWarnings ("unchecked")
	public List <ElementAction> finds (final By byLocator) {
		return get (e -> e.findElements (byLocator)).stream ()
			.map (e -> new ElementAction (this.browserAction, e))
			.collect (Collectors.toList ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IMouseActions#hover()
	 */
	@Override
	public void hover () {
		perform (e -> this.actions.pause (ofMillis (this.delays.getBeforeMouseMove ()))
			.moveToElement (e)
			.pause (ofMillis (this.delays.getAfterMouseMove ()))
			.perform ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IElementActions#isDisplayed()
	 */
	@Override
	public boolean isDisplayed () {
		return get (WebElement::isDisplayed);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IElementActions#isEnabled()
	 */
	@Override
	public boolean isEnabled () {
		return get (WebElement::isEnabled);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IElementActions#isSelected()
	 */
	@Override
	public boolean isSelected () {
		return get (WebElement::isSelected);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IKeyboardActions#pressKey(org.
	 * openqa.selenium.Keys[])
	 */
	@Override
	public void pressKey (final Keys... keys) {
		perform (e -> e.sendKeys (keys));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.ISelectboxActions#select(java.
	 * lang.String)
	 */
	@Override
	public void select (final String value) {
		perform (e -> {
			final Select select = new Select (e);
			select.selectByVisibleText (value);
		});
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IElementActions#text()
	 */
	@Override
	public String text () {
		return get (WebElement::getText);
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IVerifyElement#verifyAttribute(
	 * java.lang.String)
	 */
	@Override
	public StringSubject verifyAttribute (final String attribute) {
		return assertThat (attribute (attribute));
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IVerifyElement#verifyDisplayed()
	 */
	@Override
	public BooleanSubject verifyDisplayed () {
		return assertWithMessage ("Is Displayed?").that (isDisplayed ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IVerifyElement#verifyEnabled()
	 */
	@Override
	public BooleanSubject verifyEnabled () {
		return assertWithMessage ("Is Enabled?").that (isEnabled ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IVerifyElement#verifySelected()
	 */
	@Override
	public BooleanSubject verifySelected () {
		return assertWithMessage ("Is Selected?").that (isSelected ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IVerifyElement#verifyText()
	 */
	@Override
	public StringSubject verifyText () {
		return assertThat (text ());
	}

	/*
	 * (non-Javadoc)
	 * @see @see com.github.wasiqb.coteafs.selenium.core.ext.IWaitStrategy#
	 * waitUntilAttributeIs(java.lang.String, java.lang.String)
	 */
	@Override
	public void waitUntilAttributeIs (final String attribute, final String value) {
		if (this.useBy) {
			waitUntilLocatorAttributeIs (attribute, value);
		}
		else {
			this.wait.until (attributeToBe (this.element, attribute, value));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWaitStrategy#waitUntilClickable(
	 * )
	 */
	@Override
	public void waitUntilClickable () {
		if (this.useBy) {
			waitUntilLocatorClickable ();
		}
		else {
			this.wait.until (elementToBeClickable (this.element));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWaitStrategy#waitUntilInvisible(
	 * )
	 */
	@Override
	public void waitUntilInvisible () {
		if (this.useBy) {
			waitUntilLocatorInvisible ();
		}
		else {
			this.wait.until (invisibilityOf (this.element));
		}
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * com.github.wasiqb.coteafs.selenium.core.ext.IWaitStrategy#waitUntilVisible()
	 */
	@Override
	public void waitUntilVisible () {
		if (this.useBy) {
			waitUntilLocatorVisible ();
		}
		else {
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
			this.browserAction.execute (
				"arguments[0].setAttribute('style', arguments[1] + arguments[2]);", this.element,
				this.style, format ("color: {0}; border: 3px solid {0};", color));
		}
	}

	private void perform (final Consumer <WebElement> action) {
		prepareForAction ("red");
		action.accept (this.element);
	}

	private void prepareForAction (final String color) {
		waitUntilVisible ();
		highlight (color);
		pause (this.delays.getHighlight ());
		unhighlight ();
	}

	private void unhighlight () {
		if (!this.alreadyHighlighted) {
			this.browserAction.execute ("arguments[0].setAttribute('style', arguments[1]);",
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