package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Tab_Closing {

	@Test
    public void GoogleSignIn() throws InterruptedException {
        //Initialize driver instance
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElementByName("txtUsername").sendKeys("Admin");
		driver.findElementByName("txtPassword").sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		//Checkpoint ( Verifying the Exp vs Act result)
		driver.findElementByLinkText("Dashboard").isDisplayed();
		driver.findElementByXPath("//img[@alt='OrangeHRM']").click();
		Thread.sleep(4000);
		driver.close();//Close will close current browser opened by WebDriver
		//driver.quit(); //Quit will close all browser opened by WebDriver
   }
}
