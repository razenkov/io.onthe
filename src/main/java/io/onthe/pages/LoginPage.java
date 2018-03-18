package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {

    public void login(WebDriver driver) throws InterruptedException {
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

        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        if (!tabs2.isEmpty()) {
            //System.out.println(tabs2.get(0).toString());
            //System.out.println(tabs2.get(1).toString());
            //System.out.println("LIST SIZE  = " + tabs2.size());

            if (tabs2.size() == 2){
                //System.out.println("TAB ! = " + tabs2.get(0).toString());
                //System.out.println("TAB 2 = " + tabs2.get(1).toString());

                driver.switchTo().window(tabs2.get(0).toString());
                Map<String, String> tabsList = new HashMap<>();


                WebElement links = driver.findElement(By.xpath("//*[@id=\"posts\"]/li/a"));
                driver.switchTo().window(tabs2.get(0).toString());

                if(links.isDisplayed()){
                    tabsList.put("LinksPage", tabs2.get(0).toString());
                    tabsList.put("StatPage", tabs2.get(1).toString());
                }else {
                    tabsList.put("StatPage", tabs2.get(0).toString());
                    tabsList.put("LinksPage", tabs2.get(1).toString());
                }

                driver.switchTo().window(tabsList.get("StatPage"));


            }

        }



    }
}
