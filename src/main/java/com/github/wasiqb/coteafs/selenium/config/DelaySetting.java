/*
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

import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:48:55 PM
 */
@Data
public class DelaySetting {
    private long afterClick;
    private long afterFrameSwitch  = 500;
    private long afterKeyPress;
    private long afterMouseMove;
    private long afterWindowSwitch = 500;
    private long beforeClick;
    private long beforeKeyPress;
    private long beforeMouseMove;
    private long explicit          = 30;
    private long highlight         = 200;
    private long implicit          = 1;
    private long pageLoad          = 60;
    private long scriptLoad        = 60;
}