package com.pack.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.pages.LoginPage;

@Listeners(res.Listener.class)


public class LoginTest extends BaseTest {

	public LoginPage lpage;
	
	@BeforeTest
	public void beforeTest() {

		System.out.println("I am before Test");
	}

	@BeforeClass
	public void beforeClass() {

		System.out.println("I am before Class");
	}

	@BeforeMethod
	public void beforeMethod() {

		System.out.println("I am before Method");
	}

	@Test
	public void testLogin() {
		// TODO Auto-generated method stub
		System.out.println("I am Test Method");
//     driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
//     driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//     driver.findElement(By.id ("btnLogin")).click();

		// lpage = new LoginPage(driver);
	lpage=PageFactory.initElements(driver,LoginPage.class);
		lpage.setUsername("Admin");
		lpage.setPassword("admin123");
		lpage.login();
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard1"));
	}

	 @Test
	public void testSearchUser() {

		System.out.println("I am Register Method");

		driver.findElement(By.xpath("//b[contains(text(),'Admin')]")).click();
		;
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
		String text=driver.findElement(By.linkText("Admin")).getText();
	     
	     Assert.assertEquals(text,"Admin");
	     
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("I am After Method");

	}

	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("I am After Class");
	}

	@AfterSuite
	public void Aftersuite() {
		System.out.println("I am After Suite");
		// driver.quit();
	}

	@AfterTest
	public void Aftertest() {
		System.out.println("I am After Test");
	}

}
