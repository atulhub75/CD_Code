package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class EditUserPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement fname;
	
	@FindBy(xpath="//input[@id='lname']")
	WebElement lname;
	
	@FindBy(xpath="//input[@value='Update']")
	WebElement updateBtn;
	
	public EditUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	public UserListHomePage editUserInfo() {
		method.sendKeys(fname, "atul");
		method.sendKeys(lname, "margil");
		method.click(driver, updateBtn);
		return new UserListHomePage();
	}
}
