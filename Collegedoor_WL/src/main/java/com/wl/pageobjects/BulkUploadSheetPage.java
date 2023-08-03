package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class BulkUploadSheetPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//input[@id='customCheckbox3']")
	WebElement checkBoxbtn;
	
	@FindBy(xpath="//td[normalize-space()='Error Existing (User Id already exist)']")
	WebElement oldUserMsg;
	
	@FindBy(xpath="//td[normalize-space()='Error User Type (Student or Teacher)']")
	WebElement notUserMsg;
	
	@FindBy(xpath="//button[@id='adm-up-upload']")
	WebElement exportbtn;
	
	public BulkUploadSheetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectUser() {
		//method.fluentWait(driver, checkBoxbtn, 5);
		method.click(driver, checkBoxbtn);
		//method.click(driver, exportbtn);
	}
	
	public void exportUser() {
		method.click(driver, exportbtn);
	}
	
	public String validateAlreadyUserMsg() {
		String message=oldUserMsg.getText();
		System.out.println(message);
		return message;
	}
	
	public UserListHomePage ClickBackButton() {
		method.click(driver, backBtn);
		return new UserListHomePage();
	}
	
	public String verifyValidUser() {
		String message=notUserMsg.getText();
		return message;
	}
}
