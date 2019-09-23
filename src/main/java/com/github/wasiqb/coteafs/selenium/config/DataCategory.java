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
package com.github.wasiqb.coteafs.selenium.config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wasiqb
 * @since Sep 10, 2018 5:47:31 PM
 */
public class DataCategory {
    private Map<String, Object> datas;
    private String              name;

    /**
     * @author wasiqb
     * @since Sep 13, 2018 1:58:45 PM
     */
    public DataCategory () {
        this.datas = new HashMap<> ();
    }

    /**
     * @author wasiqb
     * @since Sep 13, 2018 2:03:20 PM
     * @param dataName name
     * @return data
     */
    public Object getData (final String dataName) {
        return this.datas.get (dataName);
    }

    /**
     * @author wasiqb
     * @since Sep 10, 2018 5:49:26 PM
     * @return the dataList
     */
    public Map<String, Object> getDatas () {
        return this.datas;
    }

    /**
     * @author wasiqb
     * @since Sep 10, 2018 5:49:26 PM
     * @return the name
     */
    public String getName () {
        return this.name;
    }

    /**
     * @author wasiqb
     * @since Sep 10, 2018 5:49:26 PM
     * @param dataList the dataList to set
     */
    public void setDatas (final Map<String, Object> dataList) {
        this.datas = dataList;
    }

    /**
     * @author wasiqb
     * @since Sep 10, 2018 5:49:26 PM
     * @param name the name to set
     */
    public void setName (final String name) {
        this.name = name;
    }
}