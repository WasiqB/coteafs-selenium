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
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import static com.github.wasiqb.coteafs.selenium.config.ConfigUtil.appSetting;
import static java.time.Duration.ofSeconds;

import java.util.function.Consumer;
import java.util.function.Function;

import com.github.wasiqb.coteafs.selenium.core.driver.IWaitAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <D>
 */
public class BaseDriverAction <D extends WebDriver> implements IWaitAction <D> {
	protected D					driver;
	private final WebDriverWait	wait;

	BaseDriverAction (final D driver) {
		this.driver = driver;
		this.wait = new WebDriverWait (driver, ofSeconds (appSetting ().getPlayback ()
			.getDelays ()
			.getExplicit ())
			.getSeconds ());
	}

	@Override
	public D driver () {
		return this.driver;
	}

	@Override
	public WebDriverWait driverWait () {
		return this.wait;
	}

	protected <E> E get (final Function <D, E> func) {
		return func.apply (this.driver);
	}

	protected void perform (final Consumer <D> action) {
		action.accept (this.driver);
	}
}