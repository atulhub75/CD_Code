package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class BulkPasswordSheetPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//button[@id='adm-up-upload']")
	WebElement importDataBtn;
	
	@FindBy(xpath="//td[normalize-space()='Error Existing (Email id Not Found)']")
	WebElement notIdMsg;
	
	@FindBy(xpath="//input[@id='customCheckbox3']")
	WebElement checkBox;
	
	public BulkPasswordSheetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyNotUserMsg() {
		String message=notIdMsg.getText();
		return message;
	}
	
	public BulkNewPasswordPage clickBackButton() {
		method.click(driver, backBtn);
		return new BulkNewPasswordPage();
	}
	
	public BulkNewPasswordPage verifyBulkPasswordFunction() {
		method.click(driver, checkBox);
		method.click(driver, importDataBtn);
		return new BulkNewPasswordPage();
	}
}
