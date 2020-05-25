package com.amboss.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class DashboardPage extends BasePage {

    private final By qBank = By.cssSelector("[data-e2e-test-id='L0Chevron-Qbank']");
    private final By customSession = By.cssSelector("[data-e2e-test-id='L0-secondlevel-Custom Session']");
    private final String qBankLocator = "[data-e2e-test-id='L0Chevron-Qbank']";

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getQBank() {
        return getElement(qBank);
    }

    public WebElement getCustomSession() {
        return getElement(customSession);
    }

    public void navigateToCustomSession() {
        visibilityOfElementLocatedCss(qBankLocator);
        getQBank().click();
        getCustomSession().click();
    }
}
