package io.onthe;

import io.onthe.core.WebDriverTestBase;
import io.onthe.pages.LoginPage;
import io.onthe.pages.TimeFramesBar;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;

public class TimeFramesTest extends WebDriverTestBase {
    @Test
    public void TimeFramesTest() throws ParseException, InterruptedException {
        TimeFramesBar timeFramesBar = PageFactory.initElements(driver, TimeFramesBar.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(driver);

        timeFramesBar.getRealTimeReport();
        Assert.assertTrue(timeFramesBar.isRealTimePage(driver));

        System.out.println("RT is ok");


        timeFramesBar.getTenMinutesReport();
        Thread.sleep(1000);

        Assert.assertTrue(timeFramesBar.isTenMinsPage(driver));
        System.out.println("10 mins is ok");


        //
//        timeFramesBar.getTenMinutesReport();
//        Thread.sleep(2000);
//        System.out.println(timeFramesBar.getTimeDifference(driver));
//        Assert.assertTrue(timeFramesBar.getTimeDifference(driver) < 10);
//
//
//        timeFramesBar.getOneHourReport();
//        Thread.sleep(2000);
//        System.out.println(timeFramesBar.getTimeDifference(driver));
//        Assert.assertTrue(timeFramesBar.getTimeDifference(driver) < 60);
//
//
//        timeFramesBar.getOneDayReport();
//        Thread.sleep(2000);
//        System.out.println(timeFramesBar.getTimeDifference(driver));
//        Assert.assertTrue(timeFramesBar.getTimeDifference(driver) < 1440);
//
//
//        timeFramesBar.getYesterdayReport();
//        Thread.sleep(2000);
//        System.out.println(timeFramesBar.getTimeDifference(driver));
//        Assert.assertTrue(timeFramesBar.getTimeDifference(driver) < 144000);
//
//
//        timeFramesBar.getSevenDaysReport();
//        Thread.sleep(2000);
//        System.out.println(timeFramesBar.getTimeDifference(driver));
//        Assert.assertTrue(timeFramesBar.getTimeDifference(driver) < 10800);
//
//
//        timeFramesBar.getThirtyDaysReport();
//        Thread.sleep(2000);
//        System.out.println(timeFramesBar.getTimeDifference(driver));
//        Assert.assertTrue(timeFramesBar.getTimeDifference(driver) < 43200);
//
//
//        timeFramesBar.getRealTimeReport();
//        Thread.sleep(2000);
//        Assert.assertTrue(true);
    }
}
