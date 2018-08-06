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

import java.util.Map;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:39:58 PM
 */
public class UISetting {
	private Map <String, ApplicationSetting> applications;

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:03:13 PM
	 * @return the applications
	 */
	public Map <String, ApplicationSetting> getApplications () {
		return this.applications;
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:04:03 PM
	 * @param name
	 * @return the application.
	 */
	public ApplicationSetting getApplicationSetting (String name) {
		return this.applications.get (name);
	}

	/**
	 * @author Wasiq Bhamla
	 * @since Apr 8, 2018 3:03:13 PM
	 * @param applications
	 *            the applications to set
	 */
	public void setApplications (Map <String, ApplicationSetting> applications) {
		this.applications = applications;
	}
}