package com.googleTest.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCache {

    private Properties config = new Properties();
    private static final PropertiesCache INSTANCE = new PropertiesCache();

    private PropertiesCache() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("com.google_properties");
        try { config.load(inputStream); }
        catch (IOException e) { System.out.println(e.toString()); }
    }

    static String getProperty(String key) {
        return INSTANCE.config.getProperty(key);
    }
}
