package com.amboss.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AnalysisPage extends BasePage {

    public final By analysisSection = By.cssSelector("[data-e2e-test-id='Session analysisPage']");

    public AnalysisPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAnalysisSection() {
        return getElement(analysisSection);
    }

}
