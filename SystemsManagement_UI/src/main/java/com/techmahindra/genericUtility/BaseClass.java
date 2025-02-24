package com.techmahindra.genericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.techmahindra.ObjectRepository.Homepage;
import com.techmahindra.ObjectRepository.loginPage;
import com.techmahindra.ObjectRepository.welcomePage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extReport;
	public static ExtentTest test;
	
	public WebDriverUtility wUtil=new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public FileUtility fUtil = new FileUtility();
	
	public welcomePage wp;
	public loginPage lp;
	public Homepage hp;
	
	
	@BeforeSuite
	public void configReports() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentReport_"+jUtil.getSystemTime()+".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);
	}
	
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		wUtil.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(fUtil.getDataFromProperty("url"));
	}
	
	@BeforeMethod
	public void login() throws IOException {
		wp = new welcomePage(driver);
		wp.getLoginLink().click();
		
		lp=new loginPage(driver);
		lp.getEmailLink().sendKeys(fUtil.getDataFromProperty("email"));
		lp.getPwdLink().sendKeys(fUtil.getDataFromProperty("password"));
		lp.getLoginBtn().click();
	}
	
	@AfterMethod
	public void logout() {
		hp=new Homepage(driver);
		hp.getLogOutlink().click();
	}
		
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup() {
		extReport.flush();
	}
}
