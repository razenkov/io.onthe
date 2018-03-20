package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ArticlesPage {

    private String dates_loc = "//*[@data-tooltip='Publishing date']";
    private String select = "//*[@class='filter_title_value title filter_item {is_on}']";
    private String timeread = "//*[@data-name='timeread']";
    private String allPersentageBars = "//*[@class='persent_bar_value_bg']";
    private String worstSlider = "//*[@class='text_worst']";
    private String readability = "//*[@data-name='readability']";
    private String timeValuesOnPage = "//*[@class='time_value']";
    private String pageviewsIndex = "//*[@class='col col_12 clear value']";
    private String pageViewFilter = "//*[@data-name='pageviews']";
    private String recirculation = "//*[@data-name='recirculation']";
    private String loader = "//*[@class='showbox']";

    public boolean isArticlesPage(WebDriver driver) {

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

    public String getLoader() {
        return loader;
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

    public void switchWorst(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));
        driver.findElement(By.xpath(worstSlider)).click();
    }
}
