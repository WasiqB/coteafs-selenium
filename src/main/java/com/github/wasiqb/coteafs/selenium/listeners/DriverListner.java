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
package com.github.wasiqb.coteafs.selenium.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * @author Wasiq Bhamla
 * @since Apr 28, 2019
 */
public class DriverListner implements WebDriverEventListener {
	private static final Logger log = LogManager.getLogger (DriverListner.class);

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterAlertAccept(
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterAlertAccept (final WebDriver driver) {
		log.trace ("Alert dialog accepted...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterAlertDismiss(
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterAlertDismiss (final WebDriver driver) {
		log.trace ("Alert dialog dismissed...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterChangeValueOf(
	 * org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver,
	 * java.lang.CharSequence[])
	 */
	@Override
	public void afterChangeValueOf (final WebElement element, final WebDriver driver,
		final CharSequence [] keysToSend) {
		if (keysToSend != null) {
			final String message = "Text [{}] has been entered...";
			log.trace (message, (Object []) keysToSend);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterClickOn(org.
	 * openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterClickOn (final WebElement element, final WebDriver driver) {
		log.trace ("Clicked on element...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterFindBy(org.
	 * openqa.selenium.By, org.openqa.selenium.WebElement,
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterFindBy (final By by, final WebElement element, final WebDriver driver) {
		log.trace ("Element found using [{}]...", by);
	}

	/*
	 * (non-Javadoc)
	 * @see @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * afterGetScreenshotAs(org.openqa.selenium.OutputType, java.lang.Object)
	 */
	@Override
	public <X> void afterGetScreenshotAs (final OutputType <X> target, final X screenshot) {
		log.trace ("Taken screenshot successfully...");
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterGetText(org.
	 * openqa.selenium.WebElement, org.openqa.selenium.WebDriver, java.lang.String)
	 */
	@Override
	public void afterGetText (final WebElement element, final WebDriver driver, final String text) {
		log.trace ("Got text [{}] from element...", text);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateBack(
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateBack (final WebDriver driver) {
		log.trace ("Navigated backward...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * afterNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateForward (final WebDriver driver) {
		log.trace ("Navigated forward...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * afterNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateRefresh (final WebDriver driver) {
		log.trace ("Page refreshed...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterNavigateTo(
	 * java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterNavigateTo (final String url, final WebDriver driver) {
		log.trace ("Navigated to url [{}]...", url);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterScript(java.
	 * lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterScript (final String script, final WebDriver driver) {
		log.trace ("Script [{}] executed successfully...", script);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#afterSwitchToWindow
	 * (java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void afterSwitchToWindow (final String windowName, final WebDriver driver) {
		log.trace ("Window switched to [{}]...", windowName);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeAlertAccept(
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeAlertAccept (final WebDriver driver) {
		log.info ("Accepting Alert pop-up...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeAlertDismiss(
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeAlertDismiss (final WebDriver driver) {
		log.info ("Dismissing Alert pop-up...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeChangeValueOf
	 * (org.openqa.selenium.WebElement, org.openqa.selenium.WebDriver,
	 * java.lang.CharSequence[])
	 */
	@Override
	public void beforeChangeValueOf (final WebElement element, final WebDriver driver,
		final CharSequence [] keysToSend) {
		if (keysToSend != null) {
			log.info ("Writing text [{}]...", (Object []) keysToSend);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeClickOn(org.
	 * openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeClickOn (final WebElement element, final WebDriver driver) {
		log.info ("Clicking on Element...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeFindBy(org.
	 * openqa.selenium.By, org.openqa.selenium.WebElement,
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeFindBy (final By by, final WebElement element, final WebDriver driver) {
		log.trace ("Finding element by [{}]", by);
	}

	/*
	 * (non-Javadoc)
	 * @see @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeGetScreenshotAs(org.openqa.selenium.OutputType)
	 */
	@Override
	public <X> void beforeGetScreenshotAs (final OutputType <X> target) {
		log.trace ("Taking screenshot...");
	}

	/*
	 * (non-Javadoc)
	 * @see @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeGetText(org.
	 * openqa.selenium.WebElement, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeGetText (final WebElement element, final WebDriver driver) {
		log.trace ("Getting text from element...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateBack(
	 * org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateBack (final WebDriver driver) {
		log.info ("Navigating back...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeNavigateForward(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateForward (final WebDriver driver) {
		log.info ("Navigating forward...");
	}

	/*
	 * (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeNavigateRefresh(org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateRefresh (final WebDriver driver) {
		log.info ("Refreshing the page...");
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeNavigateTo(
	 * java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeNavigateTo (final String url, final WebDriver driver) {
		log.info ("Navigating to [{}]...", url);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#beforeScript(java.
	 * lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeScript (final String script, final WebDriver driver) {
		final String message = "Executing script [{}]...";
		log.trace (message, script);
	}

	/*
	 * (non-Javadoc)
	 * @see org.openqa.selenium.support.events.WebDriverEventListener#
	 * beforeSwitchToWindow(java.lang.String, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void beforeSwitchToWindow (final String windowName, final WebDriver driver) {
		log.info ("Switching to window [{}]...", windowName);
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * org.openqa.selenium.support.events.WebDriverEventListener#onException(java.
	 * lang.Throwable, org.openqa.selenium.WebDriver)
	 */
	@Override
	public void onException (final Throwable throwable, final WebDriver driver) {
		final String message = "Error occurred: {}";
		log.error (message, throwable.getMessage ());
		for (final StackTraceElement stack : throwable.getStackTrace ()) {
			log.error (message, stack);
		}
		log.catching (throwable);
	}
}