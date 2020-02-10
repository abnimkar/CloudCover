package com.CloudCover.Automation.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CloudCover.Automation.Base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory -OR
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email_id;
		
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(id="identifierNext")
	WebElement Email_next_button;
	
	@FindBy(xpath="//div[@id='passwordNext']/span")
	WebElement Password_next_button;
	
	// Login Page Constructor for Initializing WebElements
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Login Method
	public HomePage login(String un,String pass){
	 email_id.sendKeys(un);
	 Email_next_button.click();
	 
	 WebDriverWait wait = new WebDriverWait(driver,10);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='passwordNext']/span")));
	 
	 password.sendKeys(pass);
	 
	 Password_next_button.click();
	 return new HomePage();
	}
	
}