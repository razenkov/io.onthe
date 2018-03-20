package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AuthorsPage {

    private String currentAuthorLable_loc = "//*[@class='data_regular_authors__header']";
    private String autor_loc = "//*[@data-type='author']";
    private String authorOfPublication_loc = "//*[@data-type='author']";
    private String allAuthors_loc = "//*[@data-type='author']";
    private String nameFromPublication = "//*[@data-tooltip='Author']";
    private String thirtyDaysFilter = "//*[@data-tooltip='Last 30 days']";

    public String getThirtyDaysFilter() {
        return thirtyDaysFilter;
    }

    public String getNameFromPublication() {
        return nameFromPublication;
    }

    public boolean isAuthorsPage(WebDriver driver) {
        WebElement header = driver.findElement(By.xpath(currentAuthorLable_loc));
        return header.isDisplayed();
    }
    public String getAllAuthors_loc() {
        return allAuthors_loc;
    }
}