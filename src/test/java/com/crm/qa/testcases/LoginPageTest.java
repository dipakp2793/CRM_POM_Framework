package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		LoginPage loginPage=new LoginPage();	
	}
	@Test(priority=1)
	public void loginPageTitle() {
		String title=loginPage.validateLoginPagetitle();
		Assert.assertEquals("title","Cogmento CRM");
	}
	@Test(priority=2)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
