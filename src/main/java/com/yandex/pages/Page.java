package com.yandex.pages;

import com.yandex.util.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

/**
 * Created by Василь on 09.06.2015.
 */
public abstract class Page {

    public WebDriver driver;

    public Page (WebDriver driver) { this.driver=driver; }

    public void type (WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }

    public abstract void open();

    public boolean isElementPresent(WebElement element){
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }
}
