package com.googleTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultsPage {
    @FindBy(how = How.ID, using = "resultStats")
    private WebElement resultStats;

    public boolean isResultsPage(){
        return resultStats.isDisplayed();
    }
}
