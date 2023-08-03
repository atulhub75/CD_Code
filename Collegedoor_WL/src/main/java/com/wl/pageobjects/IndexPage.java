package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class IndexPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//img[@class='img-fluid']")
	WebElement indexLogo;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement registerbtn;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickLogin() {
		method.click(driver, loginbtn);
		return new LoginPage();
	}
	
	public UserRegisterPage clickRegister() {
		method.click(driver, registerbtn);
		return new UserRegisterPage();
	}
}
