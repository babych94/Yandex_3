package com.yandex.pages;

import com.yandex.util.ConfigProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.security.krb5.Config;

import java.util.List;
import java.util.Random;

/**
 * Created by Василь on 09.06.2015.
 */
public class Yandex extends Page {

    public String RandomLink;

    @FindBy(id = "text")
    public WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(className = "serp-list")
    public WebElement searchResult;


    public Yandex(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("base.url"));

    }

    public void makeSearch(String searchString) {
        type(searchField, searchString);
        searchButton.click();
    }

    public boolean isDisplayedResult() {
        if (searchResult.isDisplayed()) {
            return true;
        } else return false;
    }

    public void randomClick() {

        List<WebElement> allResult=driver.findElements(By.xpath("//h2/a"));
        System.out.println(allResult.size());
        WebElement result[]=new WebElement[allResult.size()];
        int i=0;
        for (WebElement element: allResult) {

            result[i]=element;

            i++;

        }
        int randomLinkNumber = (int) (Math.random() * (allResult.size() -1));
        result[randomLinkNumber].click();

    }


}
