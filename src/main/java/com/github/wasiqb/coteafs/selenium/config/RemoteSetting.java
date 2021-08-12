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
package com.github.wasiqb.coteafs.selenium.config;

import java.util.Map;

import com.github.wasiqb.coteafs.selenium.core.enums.Protocol;
import com.github.wasiqb.coteafs.selenium.core.enums.RemoteSource;
import lombok.Data;

/**
 * @author Wasiq Bhamla
 * @since 01-Aug-2019
 */
@Data
public class RemoteSetting {
    private Map<String, Object> capabilities;
    private Map<String, Object> cloudCapabilities;
    private String              password;
    private int                 port;
    private Protocol            protocol = Protocol.HTTP;
    private RemoteSource        source;
    private String              url;
    private String              userId;
}