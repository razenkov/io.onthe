package io.onthe;

import com.ruhighload.pages.RuhighloadHomePage;
import io.onthe.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
//import sun.net.httpserver.HttpServerImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
//import java.util.Enumeration;
import java.util.List;

public class DataTrackingTest extends WebDriverTestBase {
    @Test
    public void checkForLinksMethodTypes() throws IOException{

        RuhighloadHomePage homePage = PageFactory.initElements(driver, RuhighloadHomePage.class);
        driver.get(homePage.getBaseUrl());

        int numberOfLinksToCheck = 3;

        List<WebElement> linksToCheck = driver.findElements(By.xpath(homePage.getAllLinks_loc()));

        if (!linksToCheck.isEmpty() && linksToCheck.size() >= numberOfLinksToCheck) {

            for (int i = 0; i < numberOfLinksToCheck; ++i) {
                String temp = linksToCheck.get(i).getAttribute("href");

                URL myUrl = new URL(temp);

                HttpURLConnection myUrlCon = (HttpURLConnection) myUrl.openConnection();

                String method = myUrlCon.getRequestMethod();

                System.out.println("-----------------------------" + method.toString());

                Assert.assertTrue("GET".equals(method));

//                Enumeration<String> params =   //request.getParameterNames();
//                while(params.hasMoreElements()){
//                    String paramName = params.nextElement();
//                    System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
//                }

            }
        }
    }
}
