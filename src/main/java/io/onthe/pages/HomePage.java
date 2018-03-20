package io.onthe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {

    private String eventTimeStamps_loc = "//*[@class='time_value']";

    public boolean isHomePage(WebDriver driver){

        List<WebElement> listOfTimeStamps = driver.findElements(By.xpath(eventTimeStamps_loc));

        return !listOfTimeStamps.isEmpty();
    }

}
