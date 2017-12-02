package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPages extends TestBase{
	
	
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="*//input[@type='submit']")
	WebElement Login;
	
	public LoginPages()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login(String uname, String pwd )
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Login.click();
	}

}
