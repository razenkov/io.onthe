package io.onthe.core;

import org.openqa.selenium.By;

public class AvoidSlaleElements extends WebDriverTestBase{
    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                driver.findElement(by).click();
                result = true;
                break;
            } catch(Exception e) {
            }
            attempts++;
        }
        return result;
    }
}
