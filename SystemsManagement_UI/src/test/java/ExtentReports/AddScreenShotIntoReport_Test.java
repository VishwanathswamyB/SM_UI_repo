package ExtentReports;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AddScreenShotIntoReport_Test {
	String timestamp = LocalDateTime.now().toString().replace(":", "-");
	
	@Test
	public void addscreenshot() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		 TakesScreenshot ts = (TakesScreenshot) driver;
		   String sc = ts.getScreenshotAs(OutputType.BASE64);
		   
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentReport_"+ timestamp +".html");
		ExtentReports extReport = new ExtentReports();
		extReport.attachReporter(spark);
	    ExtentTest test = extReport.createTest("addscreenshot");
	    test.log(Status.PASS, "Logging is Successfull");
	    test.addScreenCaptureFromBase64String(sc);
	    extReport.flush();
	    driver.quit();
	}
}