package com.OrangeHRM;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OrangeHRM_Login_TestNG {
	ChromeDriver driver;
	@Test(priority=1)
	public void Login() {
		driver.findElementByName("txtUsername").sendKeys("Admin");
		driver.findElementByName("txtPassword").sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		// Checkpoint ( Verifying the Exp vs Act result)
		driver.findElementByLinkText("Dashboard").isDisplayed();
	}
	
	@Test(priority=2)
	public void Logout() throws InterruptedException {
			driver.findElementByPartialLinkText("Welcome").click();
			//driver.findElementByXPath("//a[contains(text(),'Welcome')]").click();
			Thread.sleep(4000);
		 //driver.findElement(By.id("welcome")).click();
		 driver.findElementByLinkText("Logout").click();
		 String ActValue = driver.findElementById("logInPanelHeading").getText();
		 String Expvalue="LOGIN Panel";
		 Assert.assertEquals(ActValue, Expvalue);
		 
		 String ActLoginURL=driver.getCurrentUrl();
		 
		 System.out.println(ActLoginURL);
		 
		 String ActLoginTile=driver.getTitle();
		 String ExpLoginTitle="OrangeHRMM";
		 Assert.assertEquals(ActLoginTile, ExpLoginTitle);
	}


	@BeforeTest
	public void LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}

	@AfterTest
	public void CloseBrowser() {
		driver.quit(); // Quit will close all browser opened by WebDriver
	}

}
