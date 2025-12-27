package com.camcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {

	private WebDriver driver;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeaderText;

	@FindBy(xpath = "//a[text()='Create Quote']")
	private WebElement createQuoteLink;

	@FindBy(xpath = "//a[text()='More Information']")
	private WebElement moreInformationLink;

	@FindBy(name = "Edit")
	private WebElement editBtn;

	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPageHeaderText() {
		return pageHeaderText;
	}

	public WebElement getCreateQuoteLink() {
		return createQuoteLink;
	}

	public WebElement getMoreInformationLink() {
		return moreInformationLink;
	}

	public WebElement getEditBtn() {
		return editBtn;
	}

}
