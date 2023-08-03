package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class LoginPage extends BaseClass{
	
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@placeholder='Phone Number or Email ID']")
	WebElement userid;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement clickLogin;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String id, String psd) throws InterruptedException {
		method.sendKeys(userid, id);
		method.sendKeys(password, psd);
		method.JSClick(driver, clickLogin);
		Thread.sleep(2000);
		return new HomePage();
		
	}
}
