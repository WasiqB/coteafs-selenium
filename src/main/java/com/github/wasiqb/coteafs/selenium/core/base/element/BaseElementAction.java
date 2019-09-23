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

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import static java.text.MessageFormat.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import java.util.function.Consumer;
import java.util.function.Function;

import com.github.wasiqb.coteafs.selenium.config.ConfigUtil;
import com.github.wasiqb.coteafs.selenium.config.DelaySetting;
import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.github.wasiqb.coteafs.selenium.core.element.IWaitStrategy;
import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <E>
 * @param <D>
 * @param <B>
 */
@SuppressWarnings ("unchecked")
public class BaseElementAction<E extends WebElement, D extends WebDriver, B extends IDriverActions<D>>
    implements IWaitStrategy {
    private static final Logger LOG = LogManager.getLogger (BaseElementAction.class);

    static void pause (final long delay) {
        try {
            sleep (delay);
        } catch (final InterruptedException e) {
            LOG.error ("Error while pausing: {}", e.getMessage ());
            currentThread ().interrupt ();
        }
    }

    final Actions               actions;
    final B                     browserAction;
    final DelaySetting          delays;
    private boolean             alreadyHighlighted;
    private By                  by;
    private final D             driver;
    private E                   element;
    private WaitStrategy        strategy;
    private String              style;
    private boolean             useBy;
    private final WebDriverWait wait;

    BaseElementAction (final B browserAction, final By by) {
        this (browserAction);
        this.by = by;
        this.useBy = true;
    }

    BaseElementAction (final B browserAction, final By by, final WaitStrategy strategy) {
        this (browserAction, by);
        if (strategy != null) {
            this.strategy = strategy;
        }
    }

    BaseElementAction (final B browserAction, final E element) {
        this (browserAction);
        this.element = element;
        this.useBy = false;
    }

    BaseElementAction (final B browserAction, final E element, final WaitStrategy strategy) {
        this (browserAction, element);
        if (strategy != null) {
            this.strategy = strategy;
        }
    }

    private BaseElementAction (final B browserAction) {
        this.browserAction = browserAction;
        this.driver = browserAction.driver ();
        this.actions = new Actions (this.driver);
        this.wait = browserAction.driverWait ();
        this.alreadyHighlighted = false;
        this.delays = ConfigUtil.appSetting ()
            .getPlayback ()
            .getDelays ();
        this.strategy = WaitStrategy.NONE;
    }

    @Override
    public void waitUntilAttributeIs (final String attribute, final String value) {
        if (this.useBy) {
            waitUntilLocatorAttributeIs (attribute, value);
        } else {
            this.wait.until (attributeToBe (this.element, attribute, value));
        }
    }

    @Override
    public void waitUntilClickable () {
        if (this.useBy) {
            waitUntilLocatorClickable ();
        } else {
            this.wait.until (elementToBeClickable (this.element));
        }
    }

    @Override
    public void waitUntilInvisible () {
        if (this.useBy) {
            waitUntilLocatorInvisible ();
        } else {
            this.wait.until (invisibilityOf (this.element));
        }
    }

    @Override
    public void waitUntilVisible () {
        if (this.useBy) {
            waitUntilLocatorVisible ();
        } else {
            this.wait.until (visibilityOf (this.element));
        }
    }

    protected <T> T get (final Function<E, T> func) {
        prepareForAction ("green");
        return func.apply (this.element);
    }

    protected void perform (final Consumer<E> action) {
        prepareForAction ("red");
        action.accept (this.element);
    }

    protected void waitForStrategy (final By locator, final WaitStrategy newStrategy) {
        final BaseElementAction<E, D,
            B> elementAction = new BaseElementAction<> (this.browserAction, locator, newStrategy);
        elementAction.waitForStrategy ();
    }

    private void highlight (final String color) {
        if (!this.alreadyHighlighted) {
            this.style = this.element.getAttribute ("style");
            this.browserAction.execute ("arguments[0].setAttribute('style', arguments[1] + arguments[2]);",
                this.element, this.style, format ("color: {0}; border: 3px solid {0};", color));
        }
    }

    private void prepareForAction (final String color) {
        waitForStrategy ();
        highlight (color);
        pause (this.delays.getHighlight ());
        unhighlight ();
    }

    private void unhighlight () {
        if (!this.alreadyHighlighted) {
            this.browserAction.execute ("arguments[0].setAttribute('style', arguments[1]);", this.element, this.style);
            this.alreadyHighlighted = true;
        }
    }

    private void waitForStrategy () {
        switch (this.strategy) {
            case CLICKABLE:
                waitUntilClickable ();
                break;
            case VISIBLE:
                waitUntilVisible ();
                break;
            case INVISIBLE:
                waitUntilInvisible ();
                break;
            case NONE:
            default:
                if (this.useBy) {
                    this.element = (E) this.driver.findElement (this.by);
                }
                break;
        }
    }

    private void waitUntilLocatorAttributeIs (final String attribute, final String value) {
        this.wait.until (attributeToBe (this.by, attribute, value));
    }

    private void waitUntilLocatorClickable () {
        this.element = (E) this.wait.until (elementToBeClickable (this.by));
    }

    private void waitUntilLocatorInvisible () {
        this.wait.until (invisibilityOfElementLocated (this.by));
    }

    private void waitUntilLocatorVisible () {
        this.element = (E) this.wait.until (visibilityOfElementLocated (this.by));
    }
}