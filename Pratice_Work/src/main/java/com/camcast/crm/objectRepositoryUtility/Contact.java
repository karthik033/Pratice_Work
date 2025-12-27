package com.camcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class Contact {

	public class LoginPage {
		WebDriverUtility wlib=new WebDriverUtility();
		WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(linkText = "Contacts")
		private WebElement Contactlink;

		public WebElement getContactlink() {
			return Contactlink;
		}

		@FindBy(xpath = "//img[@alt='Create Contact...']")
		private WebElement createContactBtn;

		public WebElement getCreateContactBtn() {
			return createContactBtn;
		}

		@FindBy(name = "//input[@name='lastname']")
		private WebElement lastName;
		
		public WebElement getLastName() {
			return lastName;
		}

		}
	}
