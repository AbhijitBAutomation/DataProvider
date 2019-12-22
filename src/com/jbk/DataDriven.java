package com.jbk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven {
	
		
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		 System.setProperty("webdriver.chrome.driver", "E:\\Selenium Software\\ChromeDriver 78\\chromedriver_win32 (1)\\chromedriver.exe");

		  driver =new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 driver.get("file:///E:/Selenium%20Software/Offline%20Website/index.html");
	}
	
	@Test(dataProvider="getTestData")
	public void AdminLteLoginPageTest(String Email,String Password  ) throws InterruptedException {
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys(Email);
		Thread.sleep(1000);
		
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("password")).sendKeys(Password);
		Thread.sleep(1000);
		
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=ReadExcel.getExcelData("Sheet1");
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
		
		
		
		

}
