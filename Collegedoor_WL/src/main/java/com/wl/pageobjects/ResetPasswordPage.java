package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ResetPasswordPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='uname']")
	WebElement userId;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement emailId;
	
	@FindBy(xpath="//button[normalize-space()='Send Email']")
	WebElement sendEmaiBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement confirmMsg;
	
	public ResetPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyResetPassword(String uid,String email) {
		method.sendKeys(userId, uid);
		method.sendKeys(emailId, email);
		method.click(driver, sendEmaiBtn);
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, confirmMsg);
	}
}
