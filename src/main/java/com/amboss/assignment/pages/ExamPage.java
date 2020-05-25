package com.amboss.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExamPage extends BasePage {

    private final By endBlock = By.cssSelector("footer [class='end']");
    private final By firstOption = By.xpath("//*[@class='NBOptionInput' and @value='A']");
    private final By proceedToNextItemButton = By.xpath("//*[contains(text(),'Proceed to Next Item')]");
    private final By endBlockButton = By.cssSelector("[id='modal-ok']");
    private final String endBlockLocator = "footer [class='end']";

    public ExamPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEndBlockButton() {
        return getElement(endBlockButton);
    }

    public WebElement getEndBlock() {
        visibilityOfElementLocatedCss(endBlockLocator);
        return getElement(endBlock);
    }

    public WebElement getProceedToNextItemButton() {
        return getElement(proceedToNextItemButton);
    }

    public WebElement getFirstOption() {
        return getElement(firstOption);
    }

    public void simulateExam(int questions) {
        for (int i = 0; i < questions; i++) {
            getFirstOption().click();
            getProceedToNextItemButton().click();
        }
    }

    public void clickEndBlock() {
        getEndBlock().click();
    }

}
