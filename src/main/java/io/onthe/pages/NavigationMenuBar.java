package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class NavigationMenuBar {

    private String home_loc = "//*[@data-id='10']";
    private String article_loc = "//*[@data-id='20']";
    private String authors_loc = "//*[@data-id='30']";
    private String tvWelcome_loc = "//*[@data-tooltip='Launch fullscreen mode']";


    public void switchToHomePage(WebDriver driver){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        WebElement homeLink = driver.findElement(By.xpath(home_loc));
        homeLink.click();
    }
    public void switchToArticlesPage(WebDriver driver){
        ArticlesPage articlesPage = PageFactory.initElements(driver, ArticlesPage.class);
        WebElement articleLink = driver.findElement(By.xpath(article_loc));
        articleLink.click();
    }
    public void switchToAuthorsPage(WebDriver driver){
        AuthorsPage authorsPage = PageFactory.initElements(driver, AuthorsPage.class);
        WebElement authorsLink = driver.findElement(By.xpath(authors_loc));
        authorsLink.click();
    }
    public void switchToTvDashWelcomePage(WebDriver driver){
        TvDashWelcomePage welcomePage = PageFactory.initElements(driver, TvDashWelcomePage.class);
        WebElement welcomePageLink = driver.findElement(By.xpath(tvWelcome_loc));
        welcomePageLink.click();

        //here I need to switch to Dash tab
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        boolean isCorrectTab = false;
        if(!tabs.isEmpty()){
            for(int i = 0; i < tabs.size() && !isCorrectTab; ++i){
                driver.switchTo().window(tabs.get(i).toString());
                try {
                    if (welcomePage.getSelectDashTittle().isDisplayed()) ;
                    isCorrectTab = true;
                }catch (Exception e){
                    System.out.println(e.getStackTrace());
                }
            }
        }
    }
}
