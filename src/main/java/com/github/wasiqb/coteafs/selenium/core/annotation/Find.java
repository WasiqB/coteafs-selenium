/**
 * Copyright (c) 2017, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.openqa.selenium.support.How;

import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

/**
 * @author Wasiq Bhamla
 * @since 09-Jun-2019
 */
@Documented
@Retention (RUNTIME)
@Target (FIELD)
public @interface Find {
	/**
	 * @author Wasiq Bhamla
	 * @since 09-Jun-2019
	 * @return find locator
	 */
	public String locator () default EMPTY;

	/**
	 * @author Wasiq Bhamla
	 * @since 10-Jun-2019
	 * @return parent
	 */
	public String parent () default EMPTY;

	/**
	 * @author Wasiq Bhamla
	 * @since 09-Jun-2019
	 * @return find strategy
	 */
	public How strategy () default How.ID;

	/**
	 * @author Wasiq Bhamla
	 * @since 09-Jun-2019
	 * @return wait strategy
	 */
	public WaitStrategy waitStrategy () default WaitStrategy.VISIBLE;
}