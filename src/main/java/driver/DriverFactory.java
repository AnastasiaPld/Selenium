package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final String IGNORE_CERTIFICATE = "--ignore-certificate-errors";

    public static WebDriver getFirefoxDriver(int wait) {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(IGNORE_CERTIFICATE);

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getChromeDriver(int wait) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches",
                Arrays.asList("disable-popup-blocking"));

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver((Capabilities) options);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        return driver;
        //implement the same for Chrome same method

    }
    }





