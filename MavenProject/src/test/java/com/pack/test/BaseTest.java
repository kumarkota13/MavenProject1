package com.pack.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.aventstack.extentreports.ExtentReports;



public class BaseTest {
	
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		System.out.println("I am before Suite!!!!!");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver");
		
		
		File f = new File(System.getProperty("user.dir")+"/src/test/java/res/data.properties");
		FileInputStream fis = new FileInputStream(f);
		
		
		Properties prop= new Properties();
		prop.load(fis);
		
		
		String browsername = prop.getProperty("browser");
		//String browsername=System.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
			
		{
			driver=new ChromeDriver();
			
		}
		else
		{
			driver=new FirefoxDriver();	
		}
		
		System.out.println("git to jenkins");
		
		driver.get(prop.getProperty("urldemo"));
		
		//driver.close();
	}

	
	
	
}






