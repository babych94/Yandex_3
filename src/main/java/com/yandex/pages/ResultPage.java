package com.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Василь on 09.06.2015.
 */
public class ResultPage extends Page {

    @FindBy (tagName = "title")
    public String UrlDomain;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    public String currentUrl() {
        return driver.getCurrentUrl();
    }
}
