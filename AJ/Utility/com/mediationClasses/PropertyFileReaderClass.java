package com.mediationClasses;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReaderClass {
	
	static Properties properties;
	
	
	public static String propertyFileReader(String key) throws Exception {
		properties = new Properties();
		String path= "F:\\eclipse\\eclipse\\workspace\\AJ\\src\\main\\resources\\config.properties";
		FileInputStream file= new FileInputStream(path);
		
		properties.load(file);
		return properties.getProperty(key);
	}

}
