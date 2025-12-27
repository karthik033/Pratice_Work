package com.comcat.crm.conTactModule;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

public class CreateOrganiazationTest {

	@Test(groups = "smoke")
	public void toCreateContact_001() throws EncryptedDocumentException, IOException {

		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		System.out.println("Create Organization");
		System.out.println("Create Organization done");

	}
}