package io.onthe.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@Listeners({io.onthe.core.TestListener.class})
public class WebDriverTestBase {

    protected WebDriver driver;
    protected WebDriverManager manager;
    private String browser = System.getProperty("browser", "chrome");
    //public String browser = "remote";
    //public String browser = "chrome";


     @Parameters({"platform", "remoteBrowser"})
     //@BeforeClass
    @BeforeMethod
     protected void setup(@Optional String platform, @Optional String remoteBrowser)  throws MalformedURLException{
        switch (browser) {
            case "firefox": {
                manager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--disable-notifications");
                driver = new FirefoxDriver(options);
                break;
            }
            case "chrome": {
                manager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;
            }
            case "edge": {
                manager.edgedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                break;
            }
            case "remote":{
                DesiredCapabilities caps = setDesiredCapabilities(platform, remoteBrowser);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
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

//    public void setUp(@Optional String platform, @Optional String remoteBrowser) throws MalformedURLException {
//        switch (browser) {
//            case CHROME:
//                ChromeDriverManager.getInstance().setup();
//                driver = new ChromeDriver();
//                break;
//            case FIREFOX:
//                FirefoxDriverManager.getInstance().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "remote":
//                DesiredCapabilities caps = setDesiredCapabilities(platform, remoteBrowser);
//                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
//                break;
//        }
//    }
    private DesiredCapabilities setDesiredCapabilities (String platform, String remoteBrowser) {
        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase(Platform.MAC.name())) {
            caps.setPlatform(Platform.MAC);
            caps.setBrowserName(remoteBrowser);
        }
//        DesiredCapabilities caps = DesiredCapabilities.chrome();
//        caps.setCapability("platform", "macOS 10.13");
//        caps.setCapability("version", "64.0");
        return caps;
    }


    @AfterMethod
    //@AfterClass
    protected void tearDown() {
        driver.quit();
    }
}
