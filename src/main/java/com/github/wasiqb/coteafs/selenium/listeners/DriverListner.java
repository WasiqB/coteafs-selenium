/*
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
    private static final Logger LOG = LogManager.getLogger (DriverListner.class);
    private static String       name;

    /**
     * @author Wasiq Bhamla
     * @since 25-Sep-2019
     * @return the nAME
     */
    public static String getAlias () {
        return name;
    }

    /**
     * @author Wasiq Bhamla
     * @since 25-Sep-2019
     * @param alias the Element alias to set
     */
    public static void setAlias (final String alias) {
        name = alias;
    }

    @Override
    public void afterAlertAccept (final WebDriver driver) {
        LOG.trace ("Alert dialog accepted...");
    }

    @Override
    public void afterAlertDismiss (final WebDriver driver) {
        LOG.trace ("Alert dialog dismissed...");
    }

    @Override
    public void afterChangeValueOf (final WebElement element, final WebDriver driver,
        final CharSequence [] keysToSend) {
        if (keysToSend != null) {
            final String message = "Text {} has been entered in element [{}]...";
            LOG.trace (message, keysToSend, name);
        }
    }

    @Override
    public void afterClickOn (final WebElement element, final WebDriver driver) {
        LOG.trace ("Clicked on element [{}]...", name);
    }

    @Override
    public void afterFindBy (final By by, final WebElement element, final WebDriver driver) {
        LOG.trace ("Element [{}] found using {}...", name, by);
    }

    @Override
    public <X> void afterGetScreenshotAs (final OutputType<X> target, final X screenshot) {
        LOG.trace ("Taken screenshot successfully...");
    }

    @Override
    public void afterGetText (final WebElement element, final WebDriver driver, final String text) {
        LOG.trace ("Got text {} from element [{}]...", text, name);
    }

    @Override
    public void afterNavigateBack (final WebDriver driver) {
        LOG.trace ("Navigated backward...");
    }

    @Override
    public void afterNavigateForward (final WebDriver driver) {
        LOG.trace ("Navigated forward...");
    }

    @Override
    public void afterNavigateRefresh (final WebDriver driver) {
        LOG.trace ("Page refreshed...");
    }

    @Override
    public void afterNavigateTo (final String url, final WebDriver driver) {
        LOG.trace ("Navigated to url {}...", url);
    }

    @Override
    public void afterScript (final String script, final WebDriver driver) {
        LOG.trace ("Script {} executed successfully...", script);
    }

    @Override
    public void afterSwitchToWindow (final String windowName, final WebDriver driver) {
        LOG.trace ("Window switched to {}...", windowName);
    }

    @Override
    public void beforeAlertAccept (final WebDriver driver) {
        LOG.info ("Accepting Alert pop-up...");
    }

    @Override
    public void beforeAlertDismiss (final WebDriver driver) {
        LOG.info ("Dismissing Alert pop-up...");
    }

    @Override
    public void beforeChangeValueOf (final WebElement element, final WebDriver driver,
        final CharSequence [] keysToSend) {
        if (keysToSend != null) {
            LOG.info ("Writing text {} in element [{}]...", keysToSend, name);
        }
    }

    @Override
    public void beforeClickOn (final WebElement element, final WebDriver driver) {
        LOG.info ("Clicking on element [{}]...", name);
    }

    @Override
    public void beforeFindBy (final By by, final WebElement element, final WebDriver driver) {
        LOG.trace ("Finding element [{}] using {}", name, by);
    }

    @Override
    public <X> void beforeGetScreenshotAs (final OutputType<X> target) {
        LOG.trace ("Taking screenshot...");
    }

    @Override
    public void beforeGetText (final WebElement element, final WebDriver driver) {
        LOG.trace ("Getting text from element [{}]...", name);
    }

    @Override
    public void beforeNavigateBack (final WebDriver driver) {
        LOG.info ("Navigating back...");
    }

    @Override
    public void beforeNavigateForward (final WebDriver driver) {
        LOG.info ("Navigating forward...");
    }

    @Override
    public void beforeNavigateRefresh (final WebDriver driver) {
        LOG.info ("Refreshing the page...");
    }

    @Override
    public void beforeNavigateTo (final String url, final WebDriver driver) {
        LOG.info ("Navigating to {}...", url);
    }

    @Override
    public void beforeScript (final String script, final WebDriver driver) {
        final String message = "Executing script {}...";
        LOG.trace (message, script);
    }

    @Override
    public void beforeSwitchToWindow (final String windowName, final WebDriver driver) {
        LOG.info ("Switching to window {}...", windowName);
    }

    @Override
    public void onException (final Throwable throwable, final WebDriver driver) {
        LOG.error ("Error occurred: {}", throwable.getMessage ());
        for (final StackTraceElement stack : throwable.getStackTrace ()) {
            LOG.error ("\tat: {}", stack);
        }
        LOG.catching (throwable);
    }
}