package io.onthe;

import io.onthe.core.WebDriverTestBase;
import io.onthe.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenuTest extends WebDriverTestBase {
    @Test
    public void switchBetweenMenuTabs() throws InterruptedException {

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        AuthorsPage authorsPage = PageFactory.initElements(driver, AuthorsPage.class);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        TvDashWelcomePage welcomePage = PageFactory.initElements(driver, TvDashWelcomePage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);

        loginPage.login(driver);

        //check for correct work of Article link
        menuBar.switchToArticlesPage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        Assert.assertTrue(articlesPage.isArticlesPage(driver));

        //check for correct work of Authors link
        menuBar.switchToAuthorsPage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        Assert.assertTrue(authorsPage.isAuthorsPage(driver));

        //check for correct work of Home link
        menuBar.switchToHomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        Assert.assertTrue(homePage.isHomePage(driver));

        //check for correct work of TV Dash link
        menuBar.switchToTvDashWelcomePage(driver);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        Assert.assertTrue(welcomePage.isTvDashWelcomePage());
    }
}

