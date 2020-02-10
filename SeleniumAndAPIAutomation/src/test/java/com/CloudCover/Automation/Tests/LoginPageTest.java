package com.CloudCover.Automation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.CloudCover.Automation.Base.TestBase;
import com.CloudCover.Automation.Pages.HomePage;
import com.CloudCover.Automation.Pages.LoginPage;

 public class LoginPageTest extends TestBase {

	 LoginPage loginpage;
	 HomePage homepage;
	 
	@BeforeMethod
    public void setup(){
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void logintest(){
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
    }
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
