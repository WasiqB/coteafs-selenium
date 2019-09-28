/**
 * Copyright (c) 2019, Wasiq Bhamla.
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
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import com.github.wasiqb.coteafs.selenium.core.BrowserSession;

/**
 * @author Wasiq Bhamla
 * @since 27-Sep-2019
 */
public class ParallelSession {
    private static final ThreadLocal<BrowserSession> SESSION = new ThreadLocal<> ();

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     * @return session
     */
    public static BrowserSession getSession () {
        return SESSION.get ();
    }

    /**
     * @author Wasiq Bhamla
     * @since 28-Sep-2019
     * @param session
     */
    public static void setSession (final BrowserSession session) {
        SESSION.set (session);
    }
}