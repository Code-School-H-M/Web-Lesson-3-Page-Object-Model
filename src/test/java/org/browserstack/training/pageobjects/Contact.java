package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact extends Base {
    By nameFIeld = By.id("name");
    By emailField = By.id("email");
    By messageField = By.id("message");
    By submitContactElement = By.id("submitContactForm");
    By errorElement = By.id("contact-error");
    By successElement = By.id("contact-success");

    public Contact(WebDriver driver) {
        super(driver);
    }

    public void fillContactForm(String name, String email, String message) {
        waitForElementClickable(nameFIeld).sendKeys(name);
        waitForElementClickable(emailField).sendKeys(email);
        waitForElementClickable(messageField).sendKeys(message);

        waitForElementClickable(submitContactElement).click();
    }

    public WebElement getNameField() { return waitForElementClickable(nameFIeld); }
    public WebElement getEmailField() { return waitForElementClickable(emailField); }
    public WebElement getMessageField() { return waitForElementClickable(messageField); }
    public WebElement getSubmitContactButton() { return waitForElementClickable(submitContactElement); }
    public WebElement getErrorElement() { return waitForElementClickable(errorElement); }
    public WebElement getSuccessElement() { return waitForElementClickable(successElement); }
    
}
