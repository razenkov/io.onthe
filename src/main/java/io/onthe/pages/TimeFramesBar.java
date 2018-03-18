package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

import static java.time.temporal.ChronoUnit.MINUTES;

public class TimeFramesBar {

    private String eventTimeStamps_loc = "//*[@class='col col_4 clear']";

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Realtime']")
    private WebElement realTime;

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Last 10 minutes']")
    private WebElement tenMins;

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Last hour']")
    private WebElement oneHour;

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Today']")
    private WebElement oneDay;

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Yesterday']")
    private WebElement yesterday;

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Last 7 days']")
    private WebElement sevenDays;

    @FindBy(how = How.XPATH, using = "//*[@data-tooltip='Last 30 days']")
    private WebElement thirtyDays;

    public long getTimeDifference(WebDriver driver) throws ParseException {
        List<WebElement> timeStampsList = driver.findElements(By.xpath(eventTimeStamps_loc));

        DateFormat formatter = new SimpleDateFormat("HH:mm");

        List<Time> timeOfEvents = new ArrayList<>();

        for (int i = 0; i < timeStampsList.size(); ++i){

            Time timeValue = new java.sql.Time(formatter.parse(timeStampsList.get(i).getText()).getTime());
            timeOfEvents.add(timeValue);
        }

        Time min = timeOfEvents.get(0);
        Time max = timeOfEvents.get(0);

        for(int j = 0; j < timeOfEvents.size(); ++j){
            if(timeOfEvents.get(j).before(min)){
                min = timeOfEvents.get(j);
            }
            if(timeOfEvents.get(j).after(max)){
                max = timeOfEvents.get(j);
            }
        }

        LocalTime minimal = min.toLocalTime();
        LocalTime maximal = max.toLocalTime();

        System.out.println(min.toString());
        System.out.println(max.toString());

        System.out.println( "------------------" + minimal.until(maximal, MINUTES));
        return  MINUTES.between(minimal, maximal);
    }

    public void getRealTimeReport(){
        realTime.click();
    }

    public void getTenMinutesReport(){
        tenMins.click();
    }

    public void getOneHourReport(){
        oneHour.click();
    }

    public void getOneDayReport(){
        oneDay.click();
    }

    public void getYesterdayReport(){
        yesterday.click();
    }

    public void getSevenDaysReport(){
        sevenDays.click();
    }

    public void getThirtyDaysReport(){
        thirtyDays.click();
    }

    public boolean isRealTimePage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement realtime = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='value__circle-title']"))));
        if(realtime.getText().equals("realtime") && realtime.isDisplayed()) {
            return true;
        }else {
            return false;
        }
    }
    public boolean isTenMinsPage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //WebElement tenMins = driver.findElement(By.xpath("//*[@class='value__circle-title']"));
        WebElement tenMins = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='value__circle-title']"))));

        if(tenMins.getText().equals("last 10 minutes") && tenMins.isDisplayed()) {
            return true;
        }else {
            return false;
        }
    }
}



