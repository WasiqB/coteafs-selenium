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

/**
 * @author Wasiq Bhamla
 * @since Apr 8, 2018 2:48:55 PM
 */
public class DelaySetting extends BasePojo {
    private long afterClick;
    private long afterKeyPress;
    private long afterMouseMove;
    private long beforeClick;
    private long beforeKeyPress;
    private long beforeMouseMove;
    private long explicit;
    private long highlight;
    private long implicit;
    private long pageLoad;
    private long scriptLoad;

    /**
     * @author Wasiq Bhamla
     * @since Aug 15, 2018 3:14:37 PM
     */
    public DelaySetting () {
        this.pageLoad = 60;
        this.scriptLoad = 60;
        this.implicit = 1;
        this.explicit = 30;
        this.highlight = 200;
    }

    /**
     * @author Wasiq Bhamla
     * @since May 1, 2018 4:53:44 PM
     * @return the afterClick
     */
    public long getAfterClick () {
        return this.afterClick;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the afterMouseMove
     */
    public long getAfterMouseMove () {
        return this.afterMouseMove;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the afterKeyPress
     */
    public long getAfterTyping () {
        return this.afterKeyPress;
    }

    /**
     * @author Wasiq Bhamla
     * @since May 1, 2018 4:53:44 PM
     * @return the beforeClick
     */
    public long getBeforeClick () {
        return this.beforeClick;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the beforeMouseMove
     */
    public long getBeforeMouseMove () {
        return this.beforeMouseMove;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the beforeKeyPress
     */
    public long getBeforeTyping () {
        return this.beforeKeyPress;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the explicit
     */
    public long getExplicit () {
        return this.explicit;
    }

    /**
     * @author wasiqb
     * @since Aug 31, 2018 10:15:33 PM
     * @return the highlight
     */
    public long getHighlight () {
        return this.highlight;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the implicit
     */
    public long getImplicit () {
        return this.implicit;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @return the pageLoad
     */
    public long getPageLoad () {
        return this.pageLoad;
    }

    /**
     * @author Wasiq Bhamla
     * @since May 1, 2018 4:56:52 PM
     * @return the scriptLoad
     */
    public long getScriptLoad () {
        return this.scriptLoad;
    }

    /**
     * @author Wasiq Bhamla
     * @since May 1, 2018 4:53:44 PM
     * @param afterClick the afterClick to set
     */
    public void setAfterClick (final long afterClick) {
        this.afterClick = afterClick;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param afterKeyPress the afterKeyPress to set
     */
    public void setAfterKeyPress (final long afterKeyPress) {
        this.afterKeyPress = afterKeyPress;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param afterMouseMove the afterMouseMove to set
     */
    public void setAfterMouseMove (final long afterMouseMove) {
        this.afterMouseMove = afterMouseMove;
    }

    /**
     * @author Wasiq Bhamla
     * @since May 1, 2018 4:53:44 PM
     * @param beforeClick the beforeClick to set
     */
    public void setBeforeClick (final long beforeClick) {
        this.beforeClick = beforeClick;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param beforeKeyPress the beforeKeyPress to set
     */
    public void setBeforeKeyPress (final long beforeKeyPress) {
        this.beforeKeyPress = beforeKeyPress;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param beforeMouseMove the beforeMouseMove to set
     */
    public void setBeforeMouseMove (final long beforeMouseMove) {
        this.beforeMouseMove = beforeMouseMove;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param explicit the explicit to set
     */
    public void setExplicit (final long explicit) {
        this.explicit = explicit;
    }

    /**
     * @author wasiqb
     * @since Aug 31, 2018 10:15:33 PM
     * @param highlight the highlight to set
     */
    public void setHighlight (final long highlight) {
        this.highlight = highlight;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param implicit the implicit to set
     */
    public void setImplicit (final long implicit) {
        this.implicit = implicit;
    }

    /**
     * @author Wasiq Bhamla
     * @since Apr 8, 2018 2:58:50 PM
     * @param pageLoad the pageLoad to set
     */
    public void setPageLoad (final long pageLoad) {
        this.pageLoad = pageLoad;
    }

    /**
     * @author Wasiq Bhamla
     * @since May 1, 2018 4:56:52 PM
     * @param scriptLoad the scriptLoad to set
     */
    public void setScriptLoad (final long scriptLoad) {
        this.scriptLoad = scriptLoad;
    }
}