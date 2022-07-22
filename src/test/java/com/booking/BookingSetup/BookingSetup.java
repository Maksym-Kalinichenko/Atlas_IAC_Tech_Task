package com.booking.BookingSetup;

import com.booking.BookingTest.HotelSearchPage;
import com.booking.BookingTest.ValidEmail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class BookingSetup {
    public ChromeDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void Close() {
        driver.quit();
    }

    @Test
    public void HotelSearch() {
        HotelSearchPage hotelSearchPage = PageFactory.initElements(driver, HotelSearchPage.class);
        hotelSearchPage.open();
        hotelSearchPage.getStarted();
        hotelSearchPage.enterCity("New York");
        hotelSearchPage.checkIn("December 2022");
        hotelSearchPage.clickCheckOut();
        hotelSearchPage.clickSubmit();

    }

    @Test
    public void validEmail(){
        ValidEmail validEmail = PageFactory.initElements(driver, ValidEmail.class);
        validEmail.open();
        validEmail.getStarted();
        validEmail.enterEmail("maxkalinichenko");
        validEmail.sendEmail();

    }

}
