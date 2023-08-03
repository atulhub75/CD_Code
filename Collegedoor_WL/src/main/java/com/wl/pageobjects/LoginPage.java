package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class LoginPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@placeholder='User Id']")
	WebElement userId;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement clickLogin;
	
	@FindBy(xpath="//h5[normalize-space()='Reset Password']")
	WebElement resetPass;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement registerMessage;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage verifyLogin(String uid,String psd) {
		method.sendKeys(userId, uid);
		method.sendKeys(password, psd);
		method.click(driver, clickLogin);
		return new HomePage();
	}
	
	public ResetPasswordPage clickResetButton() {
		method.click(driver, resetPass);
		return new ResetPasswordPage();
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, registerMessage);
	}
	
}
