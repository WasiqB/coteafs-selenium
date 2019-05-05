package com.github.wasiqb.coteafs.selenium.config;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdrivermangerSetting {


    public WebdrivermangerSetting() {
        driverSetUp();
    }

    private void driverSetUp(){

        WebDriverManager.chromedriver().setup();

    }
}
