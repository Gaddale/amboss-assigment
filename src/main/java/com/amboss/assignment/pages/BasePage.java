package com.amboss.assignment.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.apache.log4j.Logger.getLogger;

public abstract class BasePage {

  private static Logger logger = getLogger(BasePage.class.getName());

  protected WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public WebElement getElement(By locator) {
    WebElement element = null;
    try {
      element = driver.findElement(locator);
      return element;
    } catch (Exception e) {
      System.out.println("Some Error Occurred while creating Element" + locator.toString());
      e.printStackTrace();
    }
    return element;
  }

  public void waitForElementToLoad(By locator) {
    Wait<WebDriver> wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public void visibilityOfElementLocatedCss(String css) {
    new WebDriverWait(driver, 30)
        .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
  }

  public void scrollDown() {
    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
  }

  public void waitForSearchResults(By locator, String str) {
    WebDriverWait wait = new WebDriverWait(driver, 25);
    wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, str));
  }
}
