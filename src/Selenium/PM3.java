package Selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PM3 {

    public static void main(String[] args) {
    	 System.setProperty("webdriver.ie.driver","C:\\Users\\Shameena\\Desktop\\50.003 ESC\\ESC Project 2018\\IEDriverServer_x64_3.4.0\\IEDriverServer.exe");

         WebDriver driver = new InternetExplorerDriver();
         driver.get("http://localhost:8080/dashboard/courses/courses");
        

        // click the link with name "press release"
         driver.findElement(By.className("nav-text")).click();

//        // click the link name "Event"
//        driver.findElement(By.linkText("Events")).click();
//
//        // click the link name "Newsletter"
//        driver.findElement(By.linkText("Newsletter")).click();

    }
}

