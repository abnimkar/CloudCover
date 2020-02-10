package com.CloudCover.Automation.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.CloudCover.Automation.Base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//div[@aria-label='Primary']")
	WebElement PrimaryTab;
	
	@FindBy(xpath="//div[@aria-label='Social']")
	WebElement SocialTab;
	
	@FindBy(xpath="(//span[@class='ts'])[3]")
	WebElement CountofAllEmailsPresentInSocialTab;
	
	@FindBy(xpath="//span[@id=':qq']/span")
	WebElement TwelvethEmailSubject;
	
	@FindBy(xpath="//div[@id=':qn']/span/span")
	WebElement SenderOfTwelvethEmail;
	
	@FindBy(xpath="//tbody/tr[@role='row']")
	List<WebElement> allRows;

	@FindBy(xpath="//div[@aria-label='Older']")
	List<WebElement> Older_Button;
	
	// Home Page Constructor for Initializing WebElements
	public HomePage(){
	PageFactory.initElements(driver, this);

	}
	
	public boolean VerifyPrimaryTabIsSelected(){
		return PrimaryTab.isDisplayed();
	}
	
	public void ClickOnSocialTab(){
		SocialTab.click();
	}
	
	public int CountOfEmailsInSocialTab(){
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		int totalNumberOfRows = 0;
		
		if(Older_Button.size()==0)
		totalNumberOfRows = allRows.size();
		
		else if(Older_Button.size()>0){
			((WebElement) Older_Button).click();
			totalNumberOfRows = totalNumberOfRows + allRows.size();
		}
		
		return totalNumberOfRows;
		
		
				
	}
	
	public String GetEmilSubjectofTwelveEmail(){
		return TwelvethEmailSubject.getText();
		 
	}
	
	public String GetnameofSenderofTwelvethEmail(){
		return SenderOfTwelvethEmail.getText();
	}
	
	
}
