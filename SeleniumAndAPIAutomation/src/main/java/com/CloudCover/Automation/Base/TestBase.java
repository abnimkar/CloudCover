package com.CloudCover.Automation.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\CloudCover\\Automation\\Config\\Config.properties");
		    prop.load(fis);
			
		} 
		catch (IOException e) {
				
				e.printStackTrace();
			}
		
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("Browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\latestDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		else if(browsername.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\latestDriver\\IEDriverServer.exe");
		    driver = new InternetExplorerDriver();
		
		}
		
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\latestDriver\\geckodriver.exe");
			 
			driver = new FirefoxDriver();
		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	}

	}

	

