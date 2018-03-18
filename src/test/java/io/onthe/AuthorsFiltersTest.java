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
        loginPage.login(driver);

        menuBar.switchToAuthorsPage(driver);
        WebElement thirtyDaysF = driver.findElement(By.xpath(authorsPage.getThirtyDaysFilter()));
        thirtyDaysF.click();


        List<WebElement> allAutors = new ArrayList<>();
        //WebDriverWait wait = new WebDriverWait(driver, 10);

//        for (int i = 0; i < allAutors.size(); ++i) {
//            System.out.println(allAutors.get(i).getAttribute("data-name"));
//        }


        for (int j = 0; j < allAutors.size(); ++j) {
            allAutors = driver.findElements(By.xpath(authorsPage.getAutor_loc()));
            allAutors.get(j).click();

            //WebElement authorLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(authorsPage.getAutor_loc())));
            //authorLink.click();

            Thread.sleep(3000);
            //Assert.assertTrue(authorsPage.isAuthorsPublications(driver, allAutors.get(j).getText()));
            List<WebElement> namesOnPage = driver.findElements(By.xpath(authorsPage.getNameFromPublication()));

            //if (authorsPage.isAuthorsPublications(driver, allAutors.get(j).getText())) {
                for (int k = 0; k < namesOnPage.size() - 1; ++k) {
                    //System.out.println("first = " + namesOnPage.get(k).getText());
                    //System.out.println("second = " + namesOnPage.get(k + 1).getText());
                    Assert.assertTrue(namesOnPage.get(k).getText().equals(namesOnPage.get(k + 1).getText()));
                }
            //}
            System.out.println("iteration = " + j + " is fin");
            driver.navigate().back();
            Thread.sleep(1000);

        }

    }
}