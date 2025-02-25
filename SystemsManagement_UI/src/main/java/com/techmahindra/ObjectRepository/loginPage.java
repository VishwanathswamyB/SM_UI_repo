package com.techmahindra.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	//declaration
	@FindBy(id = "Email")
	private WebElement emailLink;
	
	@FindBy(id = "Password")
	private WebElement pwdLink;
	
	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBtn;
	
	//Initialization
	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//getters & setters
	public WebElement getEmailLink() {
		return emailLink;
	}

	public void setEmailLink(WebElement emailLink) {
		this.emailLink = emailLink;
	}

	public WebElement getPwdLink() {
		return pwdLink;
	}

	public void setPwdLink(WebElement pwdLink) {
		this.pwdLink = pwdLink;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(WebElement loginBtn) {
		this.loginBtn = loginBtn;
	}
	

}
