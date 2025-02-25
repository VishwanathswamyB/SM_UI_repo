package com.techmahindra.genericUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	/**
	 * This method will capture the current system date and time and return to the
	 * caller.
	 * 
	 * @return
	 */
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");

	}

}
