package com.tvn.browser;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.network.Network;
import org.openqa.selenium.devtools.v106.performance.Performance;
import org.openqa.selenium.devtools.v106.performance.model.Metric;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OpenChromeBrowserTest {

    @Test
    void openSeleniumHomePage() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void openSeleniumHomePageInHeadlessMode(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void openSeleniumHomePageInMobileMode(){

        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 390);
        deviceMetrics.put("height", 844);
        deviceMetrics.put("pixelRatio", 1.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

    @Test
    void openSeleniumHomePageAndCapturePerformanceMetrics(){
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
        driver.get("https://selenium.dev");

        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();

        for(Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }

    }


    @Test
    void openSeleniumHomePageCaptureNetworkInterception(){
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), requestSent -> {
            System.out.println("Request URL => " + requestSent.getRequest().getUrl());
            System.out.println("Request Method => " + requestSent.getRequest().getMethod());
            System.out.println("Request Headers => " + requestSent.getRequest().getHeaders().toString());
            System.out.println("------------------------------------------------------");
        });

        driver.get("https://selenium.dev");
        Assert.assertEquals(driver.getTitle(),"Selenium");
        driver.quit();
    }

}
