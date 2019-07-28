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
package com.github.wasiqb.coteafs.selenium.core.element;

import java.util.List;

import org.openqa.selenium.By;

import com.github.wasiqb.coteafs.selenium.core.enums.WaitStrategy;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 */
public interface IFindableAction extends IWaitStrategy {
	/**
	 * @author Wasiq Bhamla
	 * @since 27-Jul-2019
	 * @param byLocator
	 * locator
	 * @return actions
	 */
	<E extends IFindableAction> E find (final By byLocator);

	/**
	 * @author Wasiq Bhamla
	 * @since 27-Jul-2019
	 * @param byLocator
	 * locator
	 * @param strategy
	 * wait strategy
	 * @return list of actions
	 */
	<E extends IFindableAction> E find (final By byLocator, WaitStrategy strategy);

	/**
	 * @author Wasiq Bhamla
	 * @since 27-Jul-2019
	 * @param byLocator
	 * locator
	 * @return list of actions
	 */
	<E extends IFindableAction> List <E> finds (final By byLocator);

	/**
	 * @author Wasiq Bhamla
	 * @since 27-Jul-2019
	 * @param byLocator
	 * locator
	 * @param strategy
	 * wait strategy
	 * @return list of actions
	 */
	<E extends IFindableAction> List <E> finds (final By byLocator, WaitStrategy strategy);
}