package com.OrangeHRM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_Hover_Example {
	
	@Test()
	public void MouseOverFlipCart() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get( "https://www.flipkart.com/");
		Thread.sleep(6000);
		driver.findElementByXPath("/html/body/div[2]/div/div/button").click();
		 WebElement element = driver.findElementByXPath("//span[contains(text(),'Men')]");
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        Thread.sleep(6000);
		driver.findElementByXPath("//a[@title='Jeans']").click();
		Thread.sleep(4000);
		driver.findElementByXPath("//a[@title='Slim Men Grey Jeans']").click();
		Thread.sleep(4000);
		//driver.close();
		driver.quit();

	}
}
