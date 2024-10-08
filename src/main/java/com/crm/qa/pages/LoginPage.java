package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(@class,'ui fluid large blue submit button')]")
	WebElement btn;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}
	public HomePage login(String em,String pass ) {
		email.sendKeys("em");
		password.sendKeys("pass");
		btn.click();
		
		return new HomePage();
		
	}
	
	

}
