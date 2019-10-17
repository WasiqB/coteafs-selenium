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

import com.github.wasiqb.coteafs.config.util.BasePojo;
import com.github.wasiqb.coteafs.selenium.core.enums.Protocol;
import com.github.wasiqb.coteafs.selenium.core.enums.RemoteSource;

/**
 * @author Wasiq Bhamla
 * @since 01-Aug-2019
 */
public class RemoteSetting extends BasePojo {
    private Map<String, Object> capabilities;
    private Map<String, Object> cloudCapabilities;
    private String              password;
    private int                 port;
    private Protocol            protocol;
    private RemoteSource        source;
    private String              url;
    private String              userId;

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     */
    public RemoteSetting () {
        setProtocol (Protocol.HTTP);
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return capabilities
     */
    public Map<String, Object> getCapabilities () {
        return this.capabilities;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return cloud capabilities
     */
    public Map<String, Object> getCloudCapabilities () {
        return this.cloudCapabilities;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return password
     */
    public String getPassword () {
        return this.password;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return port
     */
    public int getPort () {
        return this.port;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return protocol
     */
    public Protocol getProtocol () {
        return this.protocol;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return source
     */
    public RemoteSource getSource () {
        return this.source;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return url
     */
    public String getUrl () {
        return this.url;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @return user id
     */
    public String getUserId () {
        return this.userId;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param capabilities
     */
    public void setCapabilities (final Map<String, Object> capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param cloudCapabilities
     */
    public void setCloudCapabilities (final Map<String, Object> cloudCapabilities) {
        this.cloudCapabilities = cloudCapabilities;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param password
     */
    public void setPassword (final String password) {
        this.password = password;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param port
     */
    public void setPort (final int port) {
        this.port = port;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param protocol
     */
    public void setProtocol (final Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param source
     */
    public void setSource (final RemoteSource source) {
        this.source = source;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param url
     */
    public void setUrl (final String url) {
        this.url = url;
    }

    /**
     * @author Wasiq Bhamla
     * @since 01-Aug-2019
     * @param userId
     */
    public void setUserId (final String userId) {
        this.userId = userId;
    }
}