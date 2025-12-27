package com.camcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createorgbtn;
	
	@FindBy(name = "accountname")
	private WebElement orgnameedt;
	
	@FindBy(name = "button")
	private WebElement savebtn;
	
	
	public void createOrg() {
		createorgbtn.click();
		
	}
	
	public void orgname() {
		orgnameedt.sendKeys("BILLA");
	}
	
	public void saveorg() {
		savebtn.click();
	}
	
	public void createOrganisationWithMandatory() {
		orgnameedt.sendKeys("BILLA");
		savebtn.click();
	}
	
	

}
