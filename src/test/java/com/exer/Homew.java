package com.exer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.TableHeaderUI;

public class Homew {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test

    public void simpleTest() throws InterruptedException {

        driver.get("https://www.saucedemo.com/");

        WebElement inPutName = driver.findElement(By.cssSelector("input#user-name"));
        inPutName.sendKeys("standard_user");

        WebElement inPutpas = driver.findElement(By.cssSelector("input#password"));
        inPutpas.sendKeys("secret_sauce");

        WebElement btnLN = driver.findElement(By.cssSelector("input#login-button"));
        btnLN.click();

        WebElement selectElement = driver.findElement(By.className("product_sort_container"));
        Select list = new Select(selectElement);

        list.selectByValue("za");
        Thread.sleep(2000);
        list.selectByValue("hilo");
        Thread.sleep(4000);

        WebElement addToCart = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']//ancestor::div[@class='inventory_item']//button"));
        addToCart.click();
        Thread.sleep(4000);

        WebElement addToCart1 = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']//ancestor::div[@class='inventory_item']//button"));
        addToCart1.click();
        Thread.sleep(3000);

        WebElement cart = driver.findElement(By.cssSelector("#shopping_cart_container "));
        cart.click();

        WebElement btnContinue = driver.findElement(By.xpath("//a[contains(text(),'Continue Shopping')]"));
        Thread.sleep(3000);
        btnContinue.click();


        WebElement selectElementMenu = driver.findElement(By.id("react-burger-menu-btn"));
        Thread.sleep(3000);
        selectElementMenu.click();

        WebElement menuOpen = driver.findElement(By.id("logout_sidebar_link"));
       Thread.sleep(3000);
        menuOpen.click();


    }


}
