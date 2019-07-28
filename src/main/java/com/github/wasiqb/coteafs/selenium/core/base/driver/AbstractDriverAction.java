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

import static com.google.common.truth.Truth.assertThat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.github.wasiqb.coteafs.selenium.core.driver.IDriverActions;
import com.google.common.truth.StringSubject;

/**
 * @author Wasiq Bhamla
 * @since 26-Jul-2019
 * @param <D>
 */
public class AbstractDriverAction <D extends WebDriver> extends AlertAction <D>
	implements IDriverActions <D> {
	private static final Logger LOG = LogManager.getLogger (AbstractDriverAction.class);

	AbstractDriverAction (final D driver) {
		super (driver);
	}

	@Override
	public String title () {
		return get (WebDriver::getTitle);
	}

	@Override
	public StringSubject verifyTitle () {
		return assertThat (title ());
	}
}
