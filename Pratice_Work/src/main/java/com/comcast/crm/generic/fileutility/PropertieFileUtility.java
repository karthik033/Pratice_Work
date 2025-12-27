package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertieFileUtility {
public String togetDataFromPropFile(String key) throws IOException {
	FileInputStream fis=new FileInputStream("C:\\Users\\nallathambi p\\eclipse-workspace\\nallathambi\\ComcastCRMGUIFramework\\ConfigAppData\\browser.properties.txt");
	Properties prop=new Properties();
	prop.load(fis);
	String data = prop.getProperty(key);
	return data;
}
}
