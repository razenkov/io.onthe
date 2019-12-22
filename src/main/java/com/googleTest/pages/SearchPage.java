package com.googleTest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage {
    @FindBy (how = How.NAME, using = "q")
    private WebElement searchField;

    public void searchFor(String searchRequest){
        searchField.sendKeys(searchRequest);
        searchField.submit();
    }
}
