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

import com.github.wasiqb.coteafs.config.util.BasePojo;

/**
 * @author Wasiq Bhamla
 * @since 03-Aug-2019
 */
public class DriverSetting extends BasePojo {
    private String  exeUrl;
    private boolean forceCache;
    private boolean forceDownload;
    private String  path;
    private String  version;

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @return exe url
     */
    public String getExeUrl () {
        return this.exeUrl;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @return local path
     */
    public String getPath () {
        return this.path;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @return version
     */
    public String getVersion () {
        return this.version;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @return force cache
     */
    public boolean isForceCache () {
        return this.forceCache;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @return force download
     */
    public boolean isForceDownload () {
        return this.forceDownload;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @param exeUrl
     */
    public void setExeUrl (final String exeUrl) {
        this.exeUrl = exeUrl;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @param forceCache
     */
    public void setForceCache (final boolean forceCache) {
        this.forceCache = forceCache;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @param forceDownload
     */
    public void setForceDownload (final boolean forceDownload) {
        this.forceDownload = forceDownload;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @param path
     */
    public void setPath (final String path) {
        this.path = path;
    }

    /**
     * @author Wasiq Bhamla
     * @since 03-Aug-2019
     * @param version
     */
    public void setVersion (final String version) {
        this.version = version;
    }
}