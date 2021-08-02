package com.selenium.bookswagon.base;

import com.selenium.bookswagon.utility.EmailReport;
import com.selenium.bookswagon.utility.LogClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class BaseClass {

    public static WebDriver driver;
    URL url;
    URLConnection connection;

    @BeforeTest
    @Description("set up the browser")
    public void setUp() throws InterruptedException {
        LogClass.info("******************************* Starting test cases ****************************************");
        //handle browser level show notification pop window
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        LogClass.info("launching the Chrome browser");
        driver = new ChromeDriver(options);
        try {
            url = new URL("https://www.bookswagon.com/");
            connection = url.openConnection();
            connection.connect();
            LogClass.info("Internet is connected");
        } catch (IOException e) {
            e.printStackTrace();
            LogClass.info("Internet is not connected");
        }
        LogClass.info("Navigate to url : https://www.bookswagon.com/ ");
        driver.get("https://www.bookswagon.com/");
        driver.manage().window().maximize();
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterTest
    @Description("sending the test report to gmail and closing the browser")
    public void closeBrowser() {
        EmailReport.sendMail();
        LogClass.info("send report to gmail");
        LogClass.info("******************************* End Test Cases ****************************************");
        driver.quit();
    }
}
