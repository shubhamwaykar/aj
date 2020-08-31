package com.pomclasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath= "//a[@title='Log in to your customer account']") private WebElement signin;
	
	
	
	public HomePage(WebDriver driver) {     
		PageFactory.initElements(driver, this);
	}
	
	public void verifySignin() {
		signin.click();
	}
	
	public void logout () {
		
	}
	
	

}
