/**
 * Copyright (c) 2017-2020, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.config;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

import com.github.wasiqb.coteafs.selenium.constants.OS;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:42:01 PM
 */
public enum AvailableBrowser {
	/**
	 * Chrome.
	 */
	CHROME,FIREFOX;

	private AvailableBrowser() {
		driverSetUp();

	}
	private void driverSetUp(){
		WebDriverManager.chromedriver().setup();

	}
	}


