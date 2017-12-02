package com.crm.qa.testcases;

import org.testng.annotations.*;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.LoginPages;

public class LoginPageTest extends TestBase {
	
	LoginPages loginPage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		Initialize();
		loginPage = new LoginPages(); 
		
	}

	@Test
	public void LoginSuccessful()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
}
