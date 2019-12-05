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

import static java.util.Arrays.stream;

import com.github.wasiqb.coteafs.logger.Loggy;

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
    private static final Loggy LOG = Loggy.init ();
    private static String      name;

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
        LOG.t ("Alert dialog accepted with message [{}]...", name);
    }

    @Override
    public void afterAlertDismiss (final WebDriver driver) {
        LOG.t ("Alert dialog dismissed [{}]...", name);
    }

    @Override
    public void afterChangeValueOf (final WebElement element, final WebDriver driver,
        final CharSequence [] keysToSend) {
        if (keysToSend != null) {
            final String message = "Text {} has been entered in element [{}]...";
            LOG.t (message, keysToSend, name);
        }
    }

    @Override
    public void afterClickOn (final WebElement element, final WebDriver driver) {
        LOG.t ("Clicked on element [{}]...", name);
    }

    @Override
    public void afterFindBy (final By by, final WebElement element, final WebDriver driver) {
        LOG.t ("Element [{}] found using {}...", name, by);
    }

    @Override
    public <X> void afterGetScreenshotAs (final OutputType<X> target, final X screenshot) {
        LOG.t ("Taken screenshot successfully...");
    }

    @Override
    public void afterGetText (final WebElement element, final WebDriver driver, final String text) {
        LOG.t ("Got text {} from element [{}]...", text, name);
    }

    @Override
    public void afterNavigateBack (final WebDriver driver) {
        LOG.t ("Navigated backward...");
    }

    @Override
    public void afterNavigateForward (final WebDriver driver) {
        LOG.t ("Navigated forward...");
    }

    @Override
    public void afterNavigateRefresh (final WebDriver driver) {
        LOG.t ("Page refreshed...");
    }

    @Override
    public void afterNavigateTo (final String url, final WebDriver driver) {
        LOG.t ("Navigated to url {}...", url);
    }

    @Override
    public void afterScript (final String script, final WebDriver driver) {
        LOG.t ("Script {} executed successfully...", script);
    }

    @Override
    public void afterSwitchToWindow (final String windowName, final WebDriver driver) {
        LOG.t ("Window switched to {}...", windowName);
    }

    @Override
    public void beforeAlertAccept (final WebDriver driver) {
        LOG.i ("Accepting Alert pop-up with message [{}]...", name);
    }

    @Override
    public void beforeAlertDismiss (final WebDriver driver) {
        LOG.i ("Dismissing Alert pop-up with message [{}]...", name);
    }

    @Override
    public void beforeChangeValueOf (final WebElement element, final WebDriver driver,
        final CharSequence [] keysToSend) {
        if (keysToSend != null) {
            LOG.i ("Writing text {} in element [{}]...", keysToSend, name);
        }
    }

    @Override
    public void beforeClickOn (final WebElement element, final WebDriver driver) {
        LOG.i ("Clicking on element [{}]...", name);
    }

    @Override
    public void beforeFindBy (final By by, final WebElement element, final WebDriver driver) {
        LOG.t ("Finding element [{}] using {}", name, by);
    }

    @Override
    public <X> void beforeGetScreenshotAs (final OutputType<X> target) {
        LOG.t ("Taking screenshot...");
    }

    @Override
    public void beforeGetText (final WebElement element, final WebDriver driver) {
        LOG.t ("Getting text from element [{}]...", name);
    }

    @Override
    public void beforeNavigateBack (final WebDriver driver) {
        LOG.i ("Navigating back...");
    }

    @Override
    public void beforeNavigateForward (final WebDriver driver) {
        LOG.i ("Navigating forward...");
    }

    @Override
    public void beforeNavigateRefresh (final WebDriver driver) {
        LOG.i ("Refreshing the page...");
    }

    @Override
    public void beforeNavigateTo (final String url, final WebDriver driver) {
        LOG.i ("Navigating to {}...", url);
    }

    @Override
    public void beforeScript (final String script, final WebDriver driver) {
        final String message = "Executing script {}...";
        LOG.t (message, script);
    }

    @Override
    public void beforeSwitchToWindow (final String windowName, final WebDriver driver) {
        LOG.i ("Switching to window {}...", windowName);
    }

    @Override
    public void onException (final Throwable throwable, final WebDriver driver) {
        LOG.c (throwable);
        LOG.e ("Error occurred: {}", throwable.getMessage ());
        stream (throwable.getStackTrace ()).forEach (s -> LOG.e ("\tat: {}", s));
    }
}