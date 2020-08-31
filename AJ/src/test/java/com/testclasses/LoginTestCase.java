package com.testclasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import com.mediationClasses.ScreenshotClass;
import com.openBrowsers.Pojo;
import com.pomclasses.HomePage;
import com.pomclasses.SignInClass;

public class LoginTestCase extends Pojo {  
	
	WebDriver driver;
	HomePage home;
	SignInClass signin;
	Logger log= Logger.getLogger(LoginTestCase.class);
	SoftAssert softassert;
	
	
	ScreenshotClass screenshot;
	
	@BeforeClass
	@Parameters ("browsers")
	public void openBrowser(String browserName) throws Exception {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver= openChromeBrowser();
		}
		else
		if (browserName.equalsIgnoreCase("firefox")) {
			driver= openFirefoxBrowser();
		}
		else
		if(browserName.equalsIgnoreCase("ie")); {
			driver= openIEBrowser();
		}

	}
	
	@BeforeMethod
	public void screenshot() throws Exception {
		
		softassert= new SoftAssert();
		
		if (driver.getTitle().equals("My Store")) {
			
			softassert.assertTrue(true);
			log.info("*********************home page title verification passed************************");
		
		screenshot = new ScreenshotClass();
		screenshot.screenshotMethod("homepage", driver);
		log.info("*****************screenshot taken after opening browser***************************");
		}
		else {
			softassert.assertTrue(false);
			log.warn("********************home page title verification failed****************************");
		}
			
		
	}
	@Test
	public void Loginfunctionality () throws Exception {
		home= new HomePage(driver);
		home.verifySignin();
		
		signin= new SignInClass(driver);
		signin.verifyUsernameField();
		log.info("****************************username entered**************************");
		
		signin.verifyPasswordField();
		log.info("**************************password entered***************************");
		
		signin.verifySubmitTab(driver);
		log.info("**************************submit button clicked*************************");

		
		if(driver.getTitle().equals("Login - My Store"))
		{
			softassert.assertTrue(true);
			log.info("*******************Title verified after login************************");
		}
		else
		{
			softassert.assertTrue(false);
			log.info("**********************title verification after login failed****************");
		}
		
		
		
	}
	@AfterMethod
	public void logout() {
		
	}
	
	@AfterClass
	public void closeBrowser() {
		//driver.close();
	}
	
	
	

}
