package com.constant.pageElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageUIDs {
	
	WebDriver driver;
	
	@FindBy(id="navTitleMenu")
	WebElement TITLE_MENU;
	
	@FindBy(linkText = "Top 250")
	WebElement LINK_TOP_250;
	
	
	
	public HomePageUIDs(WebDriver driver){
		this.driver = driver;
		//Create WebElements
		PageFactory.initElements(driver, this);
	}

	public void clickTitleMenu(){
		TITLE_MENU.click();		
	}
	
	

	
	public void clickTop250(){
		TITLE_MENU.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement objTop250 = wait.until(ExpectedConditions.visibilityOf(LINK_TOP_250));
		objTop250.click();
		
	}
	
	
}

