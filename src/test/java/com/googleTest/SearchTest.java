package com.googleTest;

import com.googleTest.core.WebDriverTestBase;
import com.googleTest.pages.SearchPage;
import com.googleTest.pages.SearchResultsPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends WebDriverTestBase {

    /**
     *  Test case description
     */

    @Test
    public void searchTest(){
        driver.get("https://www.google.com/");
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchFor("selenium");

        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        Assert.assertTrue(searchResultsPage.isResultsPage());
    }

    /**
     *  Test case description
     */

    @Test
    public void searchWithEmptyRequestTest(){
        driver.get("https://www.google.com/");
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchFor("");

        SearchResultsPage searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        Assert.assertFalse(searchResultsPage.isResultsPage());
    }
}
