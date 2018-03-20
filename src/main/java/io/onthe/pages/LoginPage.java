package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {

    public void login(WebDriver driver) {
        driver.get("https://onthe.io/auth");
        WebElement emailFiels = driver.findElement(By.name("email"));
        emailFiels.sendKeys("gexibawer@one2mail.info");
        WebElement pass = driver.findElement(By.name("pwd"));
        pass.sendKeys("q");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"auth\"]/button"));
        loginBtn.submit();
        WebElement RuHighloadBtn = driver.findElement(By.xpath("//a[@href='https://media.onthe.io/Gzb_9oMawcAHAd8s0jAcSuNwbWyIu9Ja']"));
        RuHighloadBtn.click();

        WebElement btn2 = driver.findElement(By.xpath("/html/body/div[10]/div[2]/button"));
        btn2.click();

        //To switch between tabs create tabsList
        ArrayList tabsList = new ArrayList(driver.getWindowHandles());

        if (!tabsList.isEmpty()) {
            if (tabsList.size() == 2){
                driver.switchTo().window(tabsList.get(0).toString());
                Map<String, String> tabsListNames = new HashMap<>();

                WebElement links = driver.findElement(By.xpath("//*[@id=\"posts\"]/li/a"));
                driver.switchTo().window(tabsList.get(0).toString());

                //Here linking of tabsNames with simple page names to operate with
                if(links.isDisplayed()){
                    tabsListNames.put("LinksPage", tabsList.get(0).toString());
                    tabsListNames.put("StatPage", tabsList.get(1).toString());
                }else {
                    tabsListNames.put("StatPage", tabsList.get(0).toString());
                    tabsListNames.put("LinksPage", tabsList.get(1).toString());
                }
                //Switching to project page to be sure page is right after login
                driver.switchTo().window(tabsListNames.get("StatPage"));
            }
        }
    }
}
