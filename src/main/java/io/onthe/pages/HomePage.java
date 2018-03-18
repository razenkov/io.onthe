package io.onthe.pages;

import io.onthe.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePage {

    private String eventTimeStamps_loc = "//*[@class='time_value']";

    public boolean isHomePage(WebDriver driver){

        List<WebElement> listOfTimeStamps = driver.findElements(By.xpath(eventTimeStamps_loc));

        return !listOfTimeStamps.isEmpty();
    }

}
