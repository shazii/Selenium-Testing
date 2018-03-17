package Selenium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PM3_1 {

    static String myUserName = "username";
    static String myPassword = "password";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","C:\\Users\\Shameena\\AppData\\Local\\Temp\\Temp1_geckodriver-v0.20.0-win64.zip\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
       
        
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.get("http://localhost:8080");
        
        driver.findElement(By.id("username")).sendKeys("username");
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        driver.findElement(By.id("password")).sendKeys("password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).click();
        
        
        ((WebElement) driver.findElements(By.cssSelector("a[quiz']"))).click();
        
        driver.close();
        
        
    }
}

