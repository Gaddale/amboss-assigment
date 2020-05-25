package com.amboss.assignment.driver;


import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

public interface BrowserConfig {
    WebDriver getDriver();
    MutableCapabilities getCapabilities();

}
