package org.browserstack.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 10;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> getWait(int timeout) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout ))  // Maximum time to wait
                .pollingEvery(Duration.ofMillis(500)) // Interval between each poll
                .ignoring(NoSuchElementException.class); // Exceptions to ignore
    }

    public WebElement waitForElementVisible(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForTitle(String title) {
        return getWait(DEFAULT_TIMEOUT)
                .until(ExpectedConditions.titleIs(title));
    }

    public WebElement waitForElementVisible(By locator, int timeout) {
        return getWait(timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator, int timeout) {
        return getWait(timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }
}
