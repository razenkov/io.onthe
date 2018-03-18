package com.ruhighload.pages;

public class RuhighloadHomePage {

    private String BaseUrl = "https://ruhighload.com/";

    private String allLinks_loc = "//ul[@id='posts']/li/a";

    private String publications_loc = "//input[@id='login_txt']";

    public String getAllLinks_loc() {
        return allLinks_loc;
    }

    public String getBaseUrl() {
        return BaseUrl;
    }

    public String getPublications_loc() {
        return publications_loc;
    }
}
