package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;
	//defining page object
	@FindBy(id = "txtUsername")
	WebElement Username;
	@FindBy(id = "txtPassword")
	WebElement Password;
	@FindBy(id = "btnLogin")
	WebElement Login;
	
	
	
	//define the behviour
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		
	}

	public void setUsername(String user)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(user);
		 

	}
	
	public void setPassword(String password)
	{
//		Password.sendKeys(password);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
	}

	public void login() 
	
	{
		//Login.click();
     driver.findElement(By.id("btnLogin")).click();
	}
	
	
	
	
}
