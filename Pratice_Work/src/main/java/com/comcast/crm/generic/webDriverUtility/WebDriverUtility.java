package com.comcast.crm.generic.webDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void ToMaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void ToMinimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementOwnPolling(WebDriver driver,WebElement element) {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.withTimeout(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		for (String id : allId) {
			driver.switchTo().window(id);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialURL)) {
				break;
			}
		}

	}

	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		allId.remove(parentId);
		for (String id : allId) {
			driver.switchTo().window(id);

			String actURL = driver.getCurrentUrl();
			if (actURL.contains(partialTitle)) {
				break;
			}
		}}
		public void switchToWindow(WebDriver driver) {
			String parentId = driver.getWindowHandle();
			Set<String> allId = driver.getWindowHandles();
			allId.remove(parentId);
			for (String id : allId) {
				driver.switchTo().window(id).getTitle();
			}
	}

	public void switchBackToWindow(WebDriver driver, String parentId) {
		driver.switchTo().window(parentId);
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);

	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);

	}

	public void switchBackToFrame(WebDriver driver) {
		driver.switchTo().defaultContent();

	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToAlertAndSendTextFeild(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);

	}

	public void selectByVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);

	}

	public void selectByValue(String value, WebElement element) {
		Select sel = new Select(element);
		sel.selectByValue(value);

	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).build().perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).build().perform();
	}

	public void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions action = new Actions(driver);
		action.scrollByAmount(x, y).build().perform();
	}

	public void drgaAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element1, element2).build().perform();
	}

	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.scrollToElement(element).build().perform();
	}
	public String ToTakesScreenshot(WebDriver driver, String screenshotName) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File src=new File("./errorshot"+screenshotName+".png");
	FileHandler.copy(temp, src);
	String pathOfScreenshot=src.getAbsolutePath();
	return pathOfScreenshot;
	}
	public void javaScriptExecutorElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("addArguments[0].click()", element);
	}
	public void  toCloseTheServer(WebDriver driver) {
		driver.quit();
	}
	

}
