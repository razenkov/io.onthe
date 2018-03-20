package io.onthe;

import io.onthe.core.WebDriverTestBase;
import io.onthe.pages.ArticlesPage;
import io.onthe.pages.LoginPage;
import io.onthe.pages.NavigationMenuBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArticlesSortingTest extends WebDriverTestBase {

    @Test
    public void finishedReadingBestFilter() throws InterruptedException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        List<String> arrOfValues = new ArrayList<>();
        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement sel = driver.findElement(By.xpath(articlesPage.getSelect()));
        sel.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement tim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getReadability())));
        tim.click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        List<WebElement> allPercentageLabels = driver.findElements(By.xpath(articlesPage.getAllPersentageBars()));
        List<String> percentageLabels = new ArrayList<>();

        //get all percentage labels on page
        for (int i = 0; i < allPercentageLabels.size(); ++i) {
            if (i % 2 == 0) {
                percentageLabels.add(allPercentageLabels.get(i).getAttribute("style"));
            }
        }

        //parse labels to get values
        for (int k = 0; k < percentageLabels.size(); ++k) {
            String temp = percentageLabels.get(k);
            if (temp.charAt(8) != '%') {
                String temp2 = temp.substring(7, 9);
                arrOfValues.add(temp2);
            } else {
                String temp2 = temp.substring(7, 8);
                arrOfValues.add(temp2);
            }
        }

        //check for values order
        for (int j = 0; j < arrOfValues.size() - 1; ++j) {
            Assert.assertTrue(Integer.parseInt(arrOfValues.get(j)) >= Integer.parseInt(arrOfValues.get(j + 1)));
        }
    }

    @Test
    public void finishedReadingWorstFilter() throws InterruptedException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        List<String> arrOfValues = new ArrayList<>();

        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement sel = driver.findElement(By.xpath(articlesPage.getSelect()));
        sel.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement tim = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getReadability())));
        tim.click();

        //switch slider for worst order
        articlesPage.switchWorst(driver);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        List<WebElement> allPercentageLabels = driver.findElements(By.xpath(articlesPage.getAllPersentageBars()));
        List<String> percentageLabels = new ArrayList<>();

        //get all percentage labels on page
        for (int i = 0; i < allPercentageLabels.size(); ++i) {
            if (i % 2 == 0) {
                percentageLabels.add(allPercentageLabels.get(i).getAttribute("style"));
            }
        }

        //parse labels to get values
        for (int k = 0; k < percentageLabels.size(); ++k) {
            String temp = percentageLabels.get(k);
            if (temp.charAt(8) != '%') {
                String temp2 = temp.substring(7, 9);
                arrOfValues.add(temp2);
            } else {
                String temp2 = temp.substring(7, 8);
                arrOfValues.add(temp2);
            }
        }

        //check for values order
        for (int j = 0; j < arrOfValues.size() - 1; ++j) {
            Assert.assertTrue(Integer.parseInt(arrOfValues.get(j))
                    <= Integer.parseInt(arrOfValues.get(j + 1)));
        }
    }

    @Test
    public void pageViewsBestFilter() throws InterruptedException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement selector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getSelect())));
        selector.click();

        WebElement pageViewFilter = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(articlesPage.getPageViewFilter()))));
        pageViewFilter.click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        //get all indexes to compare
        List<WebElement> indexList = driver.findElements(By.xpath(articlesPage.getPageviewsIndex()));

        for (int i = 0; i < indexList.size() - 1; ++i) {
            Assert.assertTrue(Integer.parseInt(indexList.get(i).getText())
                    >= Integer.parseInt(indexList.get(i + 1).getText()));
        }
    }

    @Test
    public void pageViewsWorstFilter() throws InterruptedException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement selector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getSelect())));
        selector.click();

        WebElement pageViewFilter = wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath(articlesPage.getPageViewFilter()))));
        pageViewFilter.click();

        pageViewFilter.click();

        //switch slider for worst order
        articlesPage.switchWorst(driver);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        //get all indexes to compare
        List<WebElement> indexList = driver.findElements(By.xpath(articlesPage.getPageviewsIndex()));

        for (int i = 0; i < indexList.size() - 1; ++i) {

            Assert.assertTrue(Integer.parseInt(indexList.get(i).getText())
                    <= Integer.parseInt(indexList.get(i + 1).getText()));
        }
    }

    @Test
    public void recirculationBestFilter() throws InterruptedException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        List<String> arrOfValues = new ArrayList<>();
        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement select = driver.findElement(By.xpath(articlesPage.getSelect()));
        select.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement recirculationFiler = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getRecirculation())));
        recirculationFiler.click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        List<WebElement> allPercentageLabels = driver.findElements(By.xpath(articlesPage.getAllPersentageBars()));
        List<String> percentageLabels = new ArrayList<>();

        //get all percentage labels on page
        for (int i = 0; i < allPercentageLabels.size(); ++i) {
            if (i % 2 == 1) {
                percentageLabels.add(allPercentageLabels.get(i).getAttribute("style"));
            }
        }

        //parse labels to get values
        for (int k = 0; k < percentageLabels.size(); ++k) {
            String temp = percentageLabels.get(k);

            if (temp.charAt(8) != '%') {
                if (temp.charAt(9) != '%') {
                    String temp2 = temp.substring(7, 10);
                    arrOfValues.add(temp2);
                } else {
                    String temp2 = temp.substring(7, 9);
                    arrOfValues.add(temp2);
                }
            } else {
                String temp2 = temp.substring(7, 8);
                arrOfValues.add(temp2);
            }
        }

        //check for values order
        for (int j = 0; j < arrOfValues.size() - 1; ++j) {
            Assert.assertTrue(
                    Integer.parseInt(arrOfValues.get(j)) >= Integer.parseInt(arrOfValues.get(j + 1)));
        }
    }

    @Test
    public void recirculationWorstFilter() throws InterruptedException {
        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        List<String> arrOfValues = new ArrayList<>();
        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement sel = driver.findElement(By.xpath(articlesPage.getSelect()));
        sel.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement tim = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getRecirculation())));
        tim.click();

        articlesPage.switchWorst(driver);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        List<WebElement> allPercentageLabels = driver.findElements(By.xpath(articlesPage.getAllPersentageBars()));
        List<String> percentageLabels = new ArrayList<>();

        //get all percentage labels on page
        for (int i = 0; i < allPercentageLabels.size(); ++i) {
            if (i % 2 == 1) {
                percentageLabels.add(allPercentageLabels.get(i).getAttribute("style"));
            }
        }
        //parse labels to get values
        for (int k = 0; k < percentageLabels.size(); ++k) {
            String temp = percentageLabels.get(k);

            if (temp.charAt(8) != '%') {
                if (temp.charAt(9) != '%') {
                    String temp2 = temp.substring(7, 10);
                    arrOfValues.add(temp2);
                } else {
                    String temp2 = temp.substring(7, 9);
                    arrOfValues.add(temp2);
                }
            } else {
                String temp2 = temp.substring(7, 8);
                arrOfValues.add(temp2);
            }
        }
        //check for values order
        for (int j = 0; j < arrOfValues.size() - 1; ++j) {
            Assert.assertTrue(
                    Integer.parseInt(arrOfValues.get(j)) <= Integer.parseInt(arrOfValues.get(j + 1)));
        }
    }

    @Test
    public void averageTimeBestFilter() throws InterruptedException, ParseException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Time timeValue;

        loginPage.login(driver);

        menuBar.switchToArticlesPage(driver);

        WebElement selector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getSelect())));
        selector.click();

        WebElement averageTimeFilter = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath(articlesPage.getTimeread()))));
        averageTimeFilter.click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        //get all time values
        List<WebElement> timeList = driver.findElements(By.xpath(articlesPage.getTimeValuesOnPage()));

        List<Time> timeToCompareList = new ArrayList<>(timeList.size());

        //parse
        for (int i = 0; i < timeList.size(); ++i) {
            timeValue = new java.sql.Time(formatter.parse(timeList.get(i).getText()).getTime());
            timeToCompareList.add(timeValue);
        }
        //compare time values order
        for (int j = 0; j < timeToCompareList.size() - 1; ++j) {
            Assert.assertTrue(timeToCompareList.get(j).after(timeToCompareList.get(j + 1))
                    || timeToCompareList.get(j).equals(timeToCompareList.get(j + 1)));
        }
    }

    @Test
    public void averageTimeWorstFilter() throws InterruptedException, ParseException {

        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        NavigationMenuBar menuBar = PageFactory.initElements(driver, NavigationMenuBar.class);
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Time timeValue;

        loginPage.login(driver);
        menuBar.switchToArticlesPage(driver);

        WebElement selector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(articlesPage.getSelect())));
        selector.click();

        WebElement averageTimeFilter = wait.until(
                ExpectedConditions.visibilityOf(driver.findElement(By.xpath(articlesPage.getTimeread()))));
        averageTimeFilter.click();

        //switch slider for worst order
        articlesPage.switchWorst(driver);

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(articlesPage.getLoader()))));

        //get all time values
        List<WebElement> timeList = driver.findElements(By.xpath(articlesPage.getTimeValuesOnPage()));
        List<Time> timeToCompareList = new ArrayList<>(timeList.size());

        //parse
        for (int i = 0; i < timeList.size(); ++i) {
            timeValue = new java.sql.Time(formatter.parse(timeList.get(i).getText()).getTime());
            timeToCompareList.add(timeValue);
        }

        //compare time values order
        for (int j = 0; j < timeToCompareList.size() - 1; ++j) {
            Assert.assertTrue(timeToCompareList.get(j).before(timeToCompareList.get(j + 1))
                    || timeToCompareList.get(j).equals(timeToCompareList.get(j + 1)));
        }
    }
}


