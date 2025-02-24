package demo;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Sample {
	
	@Test
	public void demo() {
		Reporter.log("Demo Class Executed", true);
	}

}
