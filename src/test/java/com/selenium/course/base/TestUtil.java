package com.selenium.course.base;

import com.selenium.course.tests.LoginTest;
import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

    public WebDriver driver;
    private String url;
    private int implicitWait;
    private String browser;

    @BeforeSuite
    public void readConfigProperties() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("driver3");// if i want to use firefox i need to write driver1
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void setUp() {
        setUpBrowserDriver();
        loadUrl();
    }

    private void loadUrl() {
        driver.get(url);
    }

    private void setUpBrowserDriver() {
        driver = DriverFactory.getFirefoxDriver(implicitWait);
        driver = DriverFactory.getChromeDriver(implicitWait);

        String driver1 = "Chrome";
        String driver2 = "Firefox";

        switch (browser) {
            case "Chrome":
                DriverFactory.getChromeDriver(implicitWait);
                break;
            case "Firefox":
                DriverFactory.getFirefoxDriver(implicitWait);
                break;
            default:
                System.out.println("browser : " + browser + " is invalid");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
