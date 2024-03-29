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
package com.github.wasiqb.coteafs.selenium.error;

import java.io.Serial;

import com.github.wasiqb.coteafs.error.CoteafsError;

/**
 * @author Wasiq Bhamla
 * @since 28-Nov-2019
 */
public class VideoRecordingError extends CoteafsError {
    @Serial
    private static final long serialVersionUID = 6184267334962964373L;

    /**
     * @param message Message
     * @param cause Exception
     *
     * @author Wasiq Bhamla
     * @since 28-Nov-2019
     */
    public VideoRecordingError (final String message, final Throwable cause) {
        super (message, cause);
    }
}