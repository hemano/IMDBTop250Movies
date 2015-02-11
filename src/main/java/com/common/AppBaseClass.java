package com.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class AppBaseClass {
	
	WebDriver driver = null;
		
	@BeforeClass
	public void start(){

		driver = new FirefoxDriver();		
		driver.get("http://www.imdb.com");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	
	public WebDriver getDriver(){
		return this.driver;
	}

}
