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

import com.github.wasiqb.coteafs.config.util.BasePojo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:48:55 PM
 */
@Getter
@Setter
public class DelaySetting extends BasePojo {
    private long afterClick;
    private long afterFrameSwitch;
    private long afterKeyPress;
    private long afterMouseMove;
    private long afterWindowSwitch;
    private long beforeClick;
    private long beforeKeyPress;
    private long beforeMouseMove;
    private long explicit;
    private long highlight;
    private long implicit;
    private long pageLoad;
    private long scriptLoad;

    DelaySetting () {
        this.pageLoad = 60;
        this.scriptLoad = 60;
        this.implicit = 1;
        this.explicit = 30;
        this.highlight = 200;
        this.afterFrameSwitch = 500;
        this.afterWindowSwitch = 500;
    }
}