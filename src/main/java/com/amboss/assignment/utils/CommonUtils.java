package com.amboss.assignment.utils;

import com.amboss.assignment.Configuration;

public class CommonUtils {

    public static String setBrowser() {
        String browser = System.getProperty("browser");
        if (browser == null) {
            browser = System.getenv("browser");
            if (browser == null) {
                browser = Configuration.BROWSER.getValue();
            }
        }
        return browser;
    }

    public static String setUrl() {
        String url = System.getProperty("url");
        if (url == null) {
            url = System.getenv("url");
            if (url == null) {
                url = Configuration.TEST_ENV.getValue();
            }
        }
        return url;
    }

    public static String setOs(){
        String os = System.getProperty("os");
        if (os == null) {
            os = System.getenv("url");
            if (os == null) {
                os = Configuration.OS.getValue();
            }
        }
        return os;
    }

}
