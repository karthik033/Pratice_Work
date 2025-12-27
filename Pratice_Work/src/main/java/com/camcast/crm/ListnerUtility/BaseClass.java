package com.camcast.crm.ListnerUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.camcast.crm.objectRepositoryUtility.HomePage;
import com.camcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.fileutility.PropertieFileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.UtilityClassObjext;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.crm.genericdatabaseutility.DataBaseUtility;

public class BaseClass {

	public DataBaseUtility dlib = new DataBaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public PropertieFileUtility plib = new PropertieFileUtility();
	public JavaUtility jlib = new JavaUtility();
	public JsonUtility jsonlib = new JsonUtility();
	public WebDriver driver;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void configBS() throws Throwable {
		System.out.println("===connect to Db , Refort to config====");
		dlib.getConnection();
	}

	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(String browser) throws IOException {
		System.out.println("===launch the browser====");
		String BROWSER = browser;
		// String BROWSER = plib.togetDataFromPropFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		UtilityClassObjext.setDriver(driver);
	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException {
		System.out.println("===login===");
		System.out.println("===logout===");
		String URL = plib.togetDataFromPropFile("url");
		String USERNAME = plib.togetDataFromPropFile("username");
		String PASSWORD = plib.togetDataFromPropFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() throws IOException {
		HomePage hp = new HomePage(driver);
		hp.tologoutApp(driver);
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("=== close browser===");
		driver.quit();

	}

	@AfterSuite(alwaysRun = true)
	public void configAS() {
		System.out.println("===close  to Db , Refort backup====");
		dlib.closeConnection();
	}

}
