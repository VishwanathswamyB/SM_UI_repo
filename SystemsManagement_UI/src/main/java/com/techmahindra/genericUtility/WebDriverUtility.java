package com.techmahindra.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class WebDriverUtility {
	
String timestamp = LocalDateTime.now().toString().replace(":", "-");

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void scrollTo(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	public void selectDropDownByIndex(WebElement element, int index) {
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}
	
	public void selectDropDownByValue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}
	
	public void selectDropDownByVisibleText(WebElement element, String text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}
	
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);		
	}
	
	public void switchToFrame(WebDriver driver, String Name) {
		driver.switchTo().frame(Name);		
	}
	
	public void switchToFrame(WebDriver driver, WebElement frameelement) {
		driver.switchTo().frame(frameelement);
	}
	
	public void getPhoto(WebDriver driver) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		   File temp = ts.getScreenshotAs(OutputType.FILE);
		   File dest = new File("./Screenshots/"+jUtil.getSystemTime()+".png");
		   FileHandler.copy(temp, dest);
	}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void swtichToAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void swtichToWindow(WebDriver driver, String ID, String expUrl) {
	Set<String> IDs = driver.getWindowHandles();
	for (String id: IDs) {
		driver.switchTo().window(id);
		String actUrl = driver.getCurrentUrl();
				if(actUrl.contains(actUrl)) {
					break;
				}
	}
}
}
