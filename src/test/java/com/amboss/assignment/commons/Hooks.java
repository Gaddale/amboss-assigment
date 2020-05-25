package com.amboss.assignment.commons;

import com.amboss.assignment.driver.DriverFactory;
import com.amboss.assignment.pages.PageFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.amboss.assignment.utils.CommonUtils.setBrowser;
import static com.amboss.assignment.utils.CommonUtils.setOs;
import static com.amboss.assignment.utils.CommonUtils.setUrl;

public class Hooks {
    private WebDriver driver;

    @Before
    public void initialiseTest() {

        String browser = setBrowser();
        String url = setUrl();
        String os = setOs();
        driver = DriverFactory.getNewDriver(os, browser);
        driver.get(url);
        PageFactory.updateDriver(driver);
    }

    @After
    public void endTest(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.close();
//        driver.quit();
    }
}
