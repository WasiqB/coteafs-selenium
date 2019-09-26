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
package com.github.wasiqb.coteafs.selenium.core.base.driver;

import static com.github.wasiqb.coteafs.selenium.listeners.DriverListner.setAlias;
import static com.google.common.truth.Truth.assertThat;

import com.github.wasiqb.coteafs.selenium.core.driver.IAlertAction;
import com.github.wasiqb.coteafs.selenium.core.enums.AlertDecision;
import com.google.common.truth.StringSubject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Wasiq Bhamla
 * @since 27-Jul-2019
 * @param <D>
 */
public class AlertAction<D extends WebDriver> extends ScreenAction<D> implements IAlertAction {
    AlertAction (final D driver) {
        super (driver);
    }

    @Override
    public String alert (final AlertDecision decision) {
        final Alert alert = driverWait ().until (ExpectedConditions.alertIsPresent ());
        String message = null;
        if (alert != null) {
            message = alert.getText ();
            if (decision == AlertDecision.ACCEPT) {
                alert.accept ();
            } else {
                alert.dismiss ();
            }
            setAlias (message);
        }
        return message;
    }

    @Override
    public StringSubject verifyAlertMessage (final AlertDecision decision) {
        final String actual = alert (decision);
        return assertThat (actual);
    }
}