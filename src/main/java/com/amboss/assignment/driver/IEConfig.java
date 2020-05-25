package com.amboss.assignment.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class IEConfig implements BrowserConfig {
    @Override
    public WebDriver getDriver() {
        return new InternetExplorerDriver(getCapabilities());
    }

    @Override
    public InternetExplorerOptions getCapabilities() {
        return new InternetExplorerOptions();
    }
}
