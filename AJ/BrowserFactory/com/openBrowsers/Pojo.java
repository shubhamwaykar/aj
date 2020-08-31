package com.openBrowsers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.mediationClasses.PropertyFileReaderClass;

public class Pojo {

	public static WebDriver openChromeBrowser() throws Exception {
	
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//BrowserDrivers//chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get(PropertyFileReaderClass.propertyFileReader("url"));
		String title= driver1.getTitle();
		System.out.println(title);
		driver1.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver1;
		
	}
	
	
	public static WebDriver openFirefoxBrowser() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//BrowserDrivers//geckodriver.exe");
		WebDriver driver2 = new FirefoxDriver();
		driver2.manage().window().maximize();
		driver2.get(PropertyFileReaderClass.propertyFileReader("url"));
		driver2.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver2;
	}
	
    public static WebDriver openIEBrowser() throws Exception {
		
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//BrowserDrivers//IEDriverServer.exe");
		WebDriver driver3 = new InternetExplorerDriver();
		driver3.manage().window().maximize();
		driver3.get(PropertyFileReaderClass.propertyFileReader("url"));
		driver3.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver3;
	}
		
	
}
