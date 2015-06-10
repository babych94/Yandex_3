package com.yandex.test;

import com.yandex.pages.Page;
import com.yandex.pages.ResultPage;
import com.yandex.pages.Yandex;
import com.yandex.util.ConfigProperties;
import junit.framework.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by Василь on 09.06.2015.
 */
public class YandexSearch extends BasicTest {

    private Yandex yandex = PageFactory.initElements(getWebDriver(), Yandex.class);

    private ResultPage resultPage;

    @Test (priority = 1)

    public void YandexOpen() throws Exception {
        openYandex();
        textSearch();
        displayedResult();

    }

    @Step
    public void openYandex(){
        yandex.open();
    }

    @Step
    public void textSearch() {
        yandex.makeSearch(ConfigProperties.getProperty("search.text"));
    }

    @Step
    public void displayedResult(){
        Assert.assertTrue(yandex.isDisplayedResult());
    }

    @Test (priority = 2)

    public void LinkSearch() throws Exception {

        linkSearch();
    }
    @Step
    public void linkSearch(){
        yandex.randomClick();
    }


}
