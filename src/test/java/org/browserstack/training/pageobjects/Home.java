package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends Base{
    By loginButton = By.id("loginButton");
    By contactButton = By.id("contactButton");

    public Home(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() { driver.findElement(loginButton).click(); }
    public void goToContactPage() { driver.findElement(contactButton).click(); }
}
