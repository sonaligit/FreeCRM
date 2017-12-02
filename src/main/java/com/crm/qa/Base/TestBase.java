package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		try{
			
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\Selenium_Demo\\FreeCRMTest\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e )
		{ e.printStackTrace();}
		catch(IOException e)
		{ e.printStackTrace();}	
	}
	
	public static void Initialize()
	{
		String browserName = prop.getProperty("brower");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Downloads\\IEDriverServer\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.equals("ff"))
		{
			driver = new FirefoxDriver();
		}
		
		//driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait,TimeUnit.SECONDS);
	}
}
