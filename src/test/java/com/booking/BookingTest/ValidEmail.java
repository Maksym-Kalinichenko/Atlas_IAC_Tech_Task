package com.booking.BookingTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class ValidEmail {
    private WebDriver driver;
    private WebDriverWait wait;
    private By emailLocator = By.cssSelector("input[type=\"email\"]");
    private By btnSubmit = By.cssSelector("button[type=\"submit\"] span[class=\"bui-button__text\"]");

    public ValidEmail(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open(){
        driver.get("https://www.booking.com/index.en.html");
    }

    public void getStarted() {
        String title = driver.getTitle();

        Assert.assertTrue(title.equals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations"));
    }
    public void enterEmail(String email) {
        Random random = new Random();
        int rand = random.nextInt(100) + 1;
        email = email + rand + "@gmail.com";
        driver.findElement(emailLocator).click();
        driver.findElement(emailLocator).sendKeys(email);
    }
    public void sendEmail() {
        driver.findElement(btnSubmit).click();
    }
}

