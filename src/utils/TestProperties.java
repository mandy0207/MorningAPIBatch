package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import context.Constants;

public class TestProperties {

	public static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		System.out.println(Constants.PROPERTYFILEPATH);
		FileInputStream fis = new FileInputStream(Constants.PROPERTYFILEPATH);
		prop.load(fis);
		return prop;
		
	}
	
}
