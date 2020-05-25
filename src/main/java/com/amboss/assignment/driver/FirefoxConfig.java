package com.amboss.assignment.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxConfig implements BrowserConfig {

    @Override
    public WebDriver getDriver() {
        return new FirefoxDriver(getCapabilities());
    }

    @Override
    public FirefoxOptions getCapabilities() {
        return new FirefoxOptions();
    }

}
