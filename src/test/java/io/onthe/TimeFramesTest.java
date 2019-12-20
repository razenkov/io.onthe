package io.onthe;

import io.onthe.core.WebDriverTestBase;
import io.onthe.pages.ArticlesPage;
import io.onthe.pages.LoginPage;
import io.onthe.pages.TimeFramesBar;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TimeFramesTest extends WebDriverTestBase {
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.google.com1/");
        Assert.assertTrue(false);
        Thread.sleep(5000);
    }
//    public void TimeFramesTest() throws InterruptedException {
//        TimeFramesBar timeFramesBar = PageFactory.initElements(driver, TimeFramesBar.class);
//        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
//        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//
//        loginPage.login(driver);
//
//        //switch to realTime tab
//        timeFramesBar.getRealTimeReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getRealTime_id()));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
//
//        //switch to tenMinutes tb
//        timeFramesBar.getTenMinutesReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getTenMins_id()));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
//
//        //switch to oneHour tab
//        timeFramesBar.getOneHourReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getOneHour_id()));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
//
//        //switch to oneDay tab
//        timeFramesBar.getOneDayReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getOneDay_id()));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
//
//        //switch to yesterday tab
//        timeFramesBar.getYesterdayReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getYesterday_id()));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
//
//        //switch to sevenDays tab
//        timeFramesBar.getSevenDaysReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getSevenDays_id()));
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
//
//        //switch to thirtyDays tab
//        timeFramesBar.getThirtyDaysReport();
//        Assert.assertTrue(timeFramesBar.isCurrentTab(driver, timeFramesBar.getThirtyDays_id()));
//    }
}
