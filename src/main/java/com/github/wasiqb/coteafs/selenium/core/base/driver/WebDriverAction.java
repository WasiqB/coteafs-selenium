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

import org.openqa.selenium.WebDriver;

import com.github.wasiqb.coteafs.selenium.core.driver.IWebDriverActions;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 */
public class WebDriverAction <D extends WebDriver> extends AbstractDriverAction <D>
	implements IWebDriverActions <D> {
	protected WebDriverAction (final D driver) {
		super (driver);
	}

	@Override
	public void back () {
		perform (d -> d.navigate ()
			.back ());
	}

	@Override
	public void deleteCookies () {
		perform (d -> d.manage ()
			.deleteAllCookies ());
	}

	@Override
	public void forward () {
		perform (d -> d.navigate ()
			.forward ());
	}

	@Override
	public void navigateTo (final String url) {
		perform (d -> d.navigate ()
			.to (url));
	}

	@Override
	public void refresh () {
		perform (d -> d.navigate ()
			.refresh ());
	}
}