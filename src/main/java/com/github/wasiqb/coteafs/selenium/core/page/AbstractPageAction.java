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
package com.github.wasiqb.coteafs.selenium.core.page;

import static com.github.wasiqb.coteafs.selenium.core.base.driver.ParallelSession.getSession;

/**
 * @param <T>
 *
 * @author wasiqb
 * @since Sep 1, 2018 4:28:28 PM
 */
public abstract class AbstractPageAction<T extends AbstractPageAction<T>> implements IPageAction {
    @SuppressWarnings ("unchecked")
    @Override
    public T addInputValue (final ElementKey elementKey, final Object value) {
        getSession ().setContext (elementKey.getKey (), value);
        return (T) this;
    }

    @Override
    public <E> E value (final ElementKey elementKey) {
        return getSession ().getContext (elementKey.getKey ());
    }
}