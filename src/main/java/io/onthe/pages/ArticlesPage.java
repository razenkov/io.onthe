package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ArticlesPage {

    private String dates_loc = "//*[@data-tooltip='Publishing date']";
    String select = "//*[@class='filter_title_value title filter_item {is_on}']";
    String timeread = "//*[@data-name='timeread']";
    String allPersentageBars = "//*[@class='persent_bar_value_bg']";
    String worstSlider = "//*[@class='text_worst']";
    String bestSlider = "//*[@class='text_best']";
    String readability = "//*[@data-name='readability']";

    String timeValuesOnPage = "//*[@class='time_value']";

    String pageviewsIndex = "//*[@class='col col_12 clear value']";

    String pageViewFilter = "//*[@data-name='pageviews']";

    String recirculation = "//*[@data-name='recirculation']";




    public boolean isArticlesPage(WebDriver driver){

        List<WebElement> listOfDatesOnPage = driver.findElements(By.xpath(dates_loc));

        return !listOfDatesOnPage.isEmpty();
    }

    public String getAllPersentageBars() {
        return allPersentageBars;
    }

    public String getSelect() {
        return select;
    }

    public String getTimeread() {
        return timeread;
    }

    public String getTimeValuesOnPage() {
        return timeValuesOnPage;
    }

    public String getReadability() {
        return readability;

    }

    public String getPageviewsIndex() {
        return pageviewsIndex;
    }

    public String getPageViewFilter() {
        return pageViewFilter;
    }

    public String getRecirculation() {
        return recirculation;
    }

    public void switchBest(WebDriver driver){
        driver.findElement(By.xpath(bestSlider)).click();
    }

    public void switchWorst(WebDriver driver){
        driver.findElement(By.xpath(worstSlider)).click();
    }

}
