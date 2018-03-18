package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TvDashWelcomePage {

    @FindBy(how = How.XPATH, using = "//*[@class='report details']")
    private WebElement reportDetails;

    public WebElement getSelectDashTittle(){
        return reportDetails;
    }

    public boolean isTvDashWelcomePage(){
        return reportDetails.isDisplayed();
    }
}
