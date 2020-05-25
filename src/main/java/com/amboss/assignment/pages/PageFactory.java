package com.amboss.assignment.pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {

    private static WebDriver currentDriver = null;

    public static void updateDriver(WebDriver driver) {
        currentDriver = driver;
    }

    public static <TScreen extends BasePage> TScreen getInstance(Class<TScreen> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(currentDriver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
