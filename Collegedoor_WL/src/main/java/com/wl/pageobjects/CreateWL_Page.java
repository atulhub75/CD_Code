package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class CreateWL_Page extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement OwnerFN;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement OwnerLN;
	
	@FindBy(xpath="//select[@name='status']")
	WebElement wlType;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement adminId;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='contact']")
	WebElement contact;

	@FindBy(xpath="//input[@id='ext_sys_name']")
	WebElement instituteName;
	
	@FindBy(xpath="//input[@id='ext_sys_code']")
	WebElement instituteCode;
	
	@FindBy(xpath="//input[@value='Create WL']")
	WebElement createWLbtn;
	
	public CreateWL_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyCreateWLfuncion() {
		method.sendKeys(OwnerFN, "atul");
		method.sendKeys(OwnerLN, "xyz");
		method.sendKeys(adminId, "id07");
		
	}
	
}
