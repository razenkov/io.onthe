package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    private String oneDay_id = "1D";
    private String oneHour_id = "1H";
    private String realTime_id = "RT";
    private String tenMins_id = "10M";
    private String sevenDays_id = "7D";
    private String thirtyDays_id = "30D";
    private String yesterday_id = "YD";

    public String getYesterday_id() {
        return yesterday_id;
    }

    public String getOneDay_id() {
        return oneDay_id;
    }

    public String getOneHour_id() {
        return oneHour_id;
    }

    public String getRealTime_id() {
        return realTime_id;
    }

    public String getTenMins_id() {
        return tenMins_id;
    }

    public String getSevenDays_id() {
        return sevenDays_id;
    }

    public String getThirtyDays_id() {
        return thirtyDays_id;
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

    public boolean isCurrentTab(WebDriver driver, String nameOfTab){
        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        WebElement currentTab = driver.findElement(By.xpath("//*[@class='period_switch_item on']"));
        if(currentTab.getText().equals(nameOfTab)){
            return true;
        }else {
            return false;
        }
    }
}



