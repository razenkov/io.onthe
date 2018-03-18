package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthorsPage {

    private String authorsHeader_loc = "//*[@class='data_regular_authors__header']";
    private String autor_loc = "//*[@data-type='author']";
    private String nameFromPublication = "//*[@data-tooltip='Author']";
    private String thirtyDaysFilter = "//*[@data-tooltip='Last 30 days']";

    public String getThirtyDaysFilter() {
        return thirtyDaysFilter;
    }

    public String getNameFromPublication() {
        return nameFromPublication;
    }

    public String getAutor_loc() {
        return autor_loc;
    }

    public boolean isAuthorsPage(WebDriver driver) {
        WebElement header = driver.findElement(By.xpath(authorsHeader_loc));
        return header.isDisplayed();
    }

    public boolean isAuthorsPublications(WebDriver driver, String author){
        WebElement authorElement = driver.findElement(By.xpath(autor_loc));
        return authorElement.getText().equals(author);
    }
}