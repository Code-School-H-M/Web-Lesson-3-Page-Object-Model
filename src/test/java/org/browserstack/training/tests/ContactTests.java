package org.browserstack.training.tests;

import org.browserstack.training.pageobjects.Contact;
import org.browserstack.training.pageobjects.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTests {
    String name = "John Smith";
    String email = "john@smith.com";
    String message = "This is a message";

    String successMessage = "Thank you for your message! We'll get back to you soon.";

    WebDriver driver;
    Home homePage;
    Contact contactPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://training-site-2025.pages.dev/");
        driver.manage().window().maximize();
        homePage = new Home(driver);
        contactPage = new Contact(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void sendContactRequestTest() {
        try {
            homePage.goToContactPage();

            contactPage.fillContactForm(name, email, message);

            Assert.assertEquals(contactPage.getSuccessElement().getText(), successMessage);
        } catch (Exception e) {
            System.out.println("There was an error: " + e);
        }
    }
}
