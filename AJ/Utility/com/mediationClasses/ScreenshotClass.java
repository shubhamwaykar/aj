package com.mediationClasses;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotClass {

	public void screenshotMethod(String s, WebDriver driver) throws Exception {
		
		String path= "F:\\eclipse\\eclipse\\workspace\\AJ\\Screenshots\\Ajscreenshot_"+timestamp()+".jpg";
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File (path);
		FileUtils.copyFile(source, dest);
	}
	
	public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

}
}
