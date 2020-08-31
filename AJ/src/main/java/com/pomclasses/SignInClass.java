package com.pomclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mediationClasses.PropertyFileReaderClass;



public class SignInClass {
	
	@FindBy(xpath="//input[@id='email']") private WebElement username;
	@FindBy(id="passwd") private WebElement password;
	@FindBy(name="SubmitLogin") private WebElement submit;
	
	public SignInClass(WebDriver driver) {
		PageFactory.initElements(driver, this);
			}
	
	public void verifyUsernameField() throws Exception {
		boolean un= username.isDisplayed();
		if(un==true) {
			username.sendKeys(PropertyFileReaderClass.propertyFileReader("emailid"));
		}
	}
	
	public void verifyPasswordField() throws Exception {
		boolean pass= password.isDisplayed();
		if(pass==true) {
			password.sendKeys(PropertyFileReaderClass.propertyFileReader("password"));
		}
	}
	
	public void verifySubmitTab(WebDriver driver1) {
		boolean enter= submit.isEnabled();
		if(enter==true) {
			JavascriptExecutor js= (JavascriptExecutor)driver1;
			js.executeScript("arguments[0].scrollIntoView(true);", submit);
			driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			submit.click();
		}
	}
	

}
