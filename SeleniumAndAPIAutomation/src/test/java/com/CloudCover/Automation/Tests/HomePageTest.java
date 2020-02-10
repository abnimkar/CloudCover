package com.CloudCover.Automation.Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CloudCover.Automation.Base.TestBase;
import com.CloudCover.Automation.Pages.HomePage;
import com.CloudCover.Automation.Pages.LoginPage;

public class HomePageTest extends TestBase {

	HomePage homepage;
	LoginPage loginpage;
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
	
	@Test()
	public void ActionsOnHomePage(){
		homepage.VerifyPrimaryTabIsSelected();
		homepage.ClickOnSocialTab();
		System.out.println("Count of Email in Social tab is:" +homepage.CountOfEmailsInSocialTab());
		System.out.println("Subject of Twelveth email is :" +homepage.GetEmilSubjectofTwelveEmail());
		System.out.println("Sender's name of Twelveth email is :" +homepage.GetnameofSenderofTwelvethEmail());
	}
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
	

	
}
