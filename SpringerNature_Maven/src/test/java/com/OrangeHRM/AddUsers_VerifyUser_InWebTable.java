package com.OrangeHRM;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AddUsers_VerifyUser_InWebTable {
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
	public void AddUser() throws InterruptedException {
		 WebElement adminTab= driver.findElementById("menu_admin_viewAdminModule");
		   adminTab.click();
		   WebElement addBtn= driver.findElementByName("btnAdd");
		   addBtn.click();
		   WebElement roleDD= driver.findElementById("systemUser_userType");
		   Select role= new Select(roleDD);
		   role.selectByValue("1");
		   driver.findElementById("systemUser_employeeName_empName").sendKeys("John Smith");
		   
		   driver.findElementById("systemUser_userName").sendKeys("Dixit");
		   driver.findElementById("systemUser_password").sendKeys("admin123");
		   driver.findElementById("systemUser_confirmPassword").sendKeys("admin123");
		   driver.findElementById("btnSave").click();
		   Thread.sleep(5000);
		   String username= "//a[text()='%s')]";
		   WebElement element = driver.findElement(By.xpath(String.format(username, "sssssssss")));
		   Assert.assertTrue(element.isDisplayed());
		   
		   // Delete user functionality
		   
		   driver.findElementByXPath("").click();
		   driver.findElementById("").click();
		   
		   
	}
	
	@Test(priority=4)
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
