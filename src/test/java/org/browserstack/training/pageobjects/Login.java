package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class Login extends Base {
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By submitButton = By.id("submitButton");
    By errorElement = By.id("error");
    By successElement = By.id("success");

    public Login(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String username, String password) {
        waitForElementClickable(usernameField).sendKeys(username);
        waitForElementClickable(passwordField).sendKeys(password);

        waitForElementClickable(submitButton).click();
    }

    public WebElement getUsernameField() { return waitForElementClickable(usernameField); }
    public WebElement getPasswordField() { return waitForElementClickable(passwordField); }
    public WebElement getSubmitButton() { return waitForElementClickable(submitButton); }
    public WebElement getErrorElement() { return waitForElementClickable(errorElement); }
    public WebElement getSuccessElement() { return waitForElementClickable(successElement); }
}
