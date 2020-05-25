package com.amboss.assignment.pages;

import com.amboss.assignment.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private final By username = By.id("signin_username");
    private final By password = By.id("signin_password");
    private final By loginButton = By.xpath("//*[@class='amboss-field amboss-lastrow']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getUserName() {
        return getElement(username);
    }

    public WebElement getPassword() {
        return getElement(password);
    }

    public WebElement getLoginButton() {
        return getElement(loginButton);
    }

    public void login() {
        getUserName().clear();
        getUserName().sendKeys(Configuration.USERNAME.getValue());
        getPassword().clear();
        getPassword().sendKeys(Configuration.PASSWORD.getValue());
        getLoginButton().click();
    }

}
