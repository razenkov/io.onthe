package com.googleTest.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

@Listeners({com.googleTest.core.TestListener.class})
public class WebDriverTestBase {

    protected WebDriver driver;
    protected WebDriverManager manager;
    private String browser = System.getProperty("browser", "chrome");

    @Parameters({"platform", "remoteBrowser"})

    @BeforeMethod
    protected void setup(@Optional String platform, @Optional String remoteBrowser) {
        switch (browser) {
            case "firefox": {
                manager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
                driver = new FirefoxDriver(options);
                break;
            }
            case "chrome": {
                manager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
                driver = new ChromeDriver(options);
                break;
            }
            case "edge": {
                manager.edgedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
                driver = new EdgeDriver(options);
                break;
            }
        }

        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(
                PropertiesCache.getProperty("wait.page")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(
                PropertiesCache.getProperty("wait.implicit")), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(Long.parseLong(
                PropertiesCache.getProperty("wait.script")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    protected void tearDown() {
       driver.quit();
    }
}
