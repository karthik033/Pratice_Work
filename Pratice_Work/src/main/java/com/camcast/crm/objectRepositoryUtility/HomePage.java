package com.camcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement Contactlink;
	
	@FindBy(linkText = "Documents")
	private WebElement Documentlink;

	

	@FindBy(xpath = "(//a[text()='Products'])[1]")
	private WebElement productlink;

	public WebElement getProductlink() {
		return productlink;
	}

	@FindBy(linkText = "Opportunities")
	private WebElement opportyLink;

	@FindBy(linkText = "Organizations")
	private WebElement Organizationlink;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement Administratorlink;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutBtn;

	@FindBy(xpath = "(//a[text()='Opportunities'])[1]")
	private WebElement Opportunitielink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOpportyLink() {
		return opportyLink;
	}

	public WebElement getContactlink() {
		return Contactlink;
	}

	public WebElement getAdministratorlink() {
		return Administratorlink;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}

	public WebElement getOrganizationlink() {
		return Organizationlink;
	}

	public WebElement getOpportunitielink() {
		return Opportunitielink;
	}

	public WebElement getDocumentlink() {
		return Documentlink;
	}
	
	public void tologoutApp(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(Administratorlink).perform();
		signoutBtn.click();
	}

	public void productClick() {
		productlink.click();
	}

	public void OrganizationLinkAction() {
		Organizationlink.click();
	}
	public void contactClick() {
		Contactlink.click();
	}
	public void OpportunitielinkAction() {
		Opportunitielink.click();
	}
}
