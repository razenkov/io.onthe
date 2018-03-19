package io.onthe;

import io.onthe.core.WebDriverTestBase;
import io.onthe.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AuthorsFiltersTest extends WebDriverTestBase {

    @Test
    public void autorsAndPublications() throws InterruptedException {
        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        AuthorsPage authorsPage = PageFactory.initElements(driver, AuthorsPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        loginPage.login(driver);

        menuBar.switchToAuthorsPage(driver);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        WebElement thirtyDaysFilter = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(authorsPage.getThirtyDaysFilter()))));
        thirtyDaysFilter.click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        List<WebElement> allAuthors = driver.findElements(By.xpath(authorsPage.getAllAuthors_loc()));
        int size = allAuthors.size();

        for (int j = 0; j < size; ++j) {
            allAuthors = driver.findElements(By.xpath(authorsPage.getAllAuthors_loc()));
            allAuthors.get(j).click();

            List<WebElement> namesOnPage = driver.findElements(By.xpath(authorsPage.getNameFromPublication()));
                for (int k = 0; k < namesOnPage.size() - 1; ++k) {
                    Assert.assertTrue(namesOnPage.get(k).getText().equals(namesOnPage.get(k + 1).getText()));
                }
            driver.navigate().back();
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        }

    }
}