package com.camcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class LoginPage {
	WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameTf;

	@FindBy(name = "user_password")
	private WebElement userpassworTf;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public void enterUsername(String username) {
		usernameTf.sendKeys(username);
	}

	public WebElement getUserpasswordEdt() {
		return userpassworTf;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void loginToApp(String url, String username, String password) {
		driver.get(url);
		usernameTf.sendKeys(username);
		userpassworTf.sendKeys(password);
		loginBtn.click();
		wlib.waitForPageToLoad(driver);
	}

}
