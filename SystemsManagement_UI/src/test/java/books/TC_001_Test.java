package books;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.techmahindra.ObjectRepository.Homepage;
import com.techmahindra.genericUtility.BaseClass;
import com.techmahindra.genericUtility.ListenerUtility;
@Listeners(ListenerUtility.class)

public class TC_001_Test extends BaseClass {
	@Test
	public void clickOnBooks() {
		 hp=new Homepage(driver);
		 		
		 hp.getBookslink().click();
		 Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Book","Books page is not displayed");
		 test.log(Status.PASS,"Books Page is Displayed");		 
	}
}
