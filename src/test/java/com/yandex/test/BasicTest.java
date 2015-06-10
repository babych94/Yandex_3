package com.yandex.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import com.yandex.util.ConfigProperties;

import java.util.concurrent.TimeUnit;

/**
 * Created by Василь on 09.06.2015.
 */
public class BasicTest {

    protected WebDriver driver;

    protected WebDriver getWebDriver() {
        if (driver==null){

            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);

        }
        return driver;
    }


    @AfterTest
    public void tearDown(){
      //  driver.close();
    }
}
