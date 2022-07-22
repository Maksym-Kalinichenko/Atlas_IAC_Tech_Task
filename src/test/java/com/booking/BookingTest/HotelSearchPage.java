package com.booking.BookingTest;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HotelSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By cityLocator = By.id("ss");
    private By checkInBtn = By.cssSelector("div.xp__dates__checkin");
    private By monthLocator = By.cssSelector("div.bui-calendar__month");
    private By monthBtn = By.cssSelector("div.bui-calendar__control--next");
    private By submitBtn = By.cssSelector("span.js-sb-submit-text");
    private By firstDay = By.cssSelector("td[class='bui-calendar__date'] span[aria-label=\"1 December 2022\"]");
    private By lastDay = By.cssSelector("td[class='bui-calendar__date'] span[aria-label=\"30 December 2022\"]");

    public HotelSearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.booking.com/index.en.html");
    }

    public void getStarted() {
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Booking.com | Official site | The best hotels, flights, car rentals & accommodations"));
    }
    public void enterCity(String arg1) {
        driver.findElement(cityLocator).sendKeys(arg1);
    }
    public void checkIn(String month) {
        driver.findElement(checkInBtn).click();

        String month_now = driver.findElement(monthLocator).getAttribute("innerHTML");

        while (!month_now.equals(month)) {
            driver.findElement(monthBtn).click();
            month_now = driver.findElement(monthLocator).getAttribute("innerHTML");
        }
        driver.findElement(firstDay).click();
    }
    public void clickCheckOut() {
        driver.findElement(lastDay).click();
    }
    public void clickSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
    }

}
