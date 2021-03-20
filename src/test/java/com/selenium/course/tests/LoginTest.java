package com.selenium.course.tests;

import com.opencsv.exceptions.CsvException;
import com.selenium.course.base.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CsvReader;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class LoginTest extends TestUtil {
   // private WebDriver driver;

  //  @BeforeTest
    //public void setUp() {
      //  WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();}

 //   @DataProvider(name="login-data")
   // public static Object[][] dataProviderHardcodedData(){
     //   return new Object[][]{
       //         {"user1","pass1"},
         //       {"user2","pass2"},};}

   @DataProvider(name="login-data-file")
   public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
       return CsvReader.readCsvFile("src/test/resources/login-data.csv");
        };


    @Test(dataProvider = "login-data-file")
    public void executeSimpleTest(String userName, String password){
       // driver.get("https://www.saucedemo.com/");

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.clear();

        userNameInput.sendKeys(userName);

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();

        passwordInput.sendKeys(password);

        WebElement logInButton = driver.findElement(By.cssSelector("[value=LOGIN]"));
        logInButton.click();

    }

   // @AfterTest
  //  public void tearDown() {
    //    driver.quit();
    }



