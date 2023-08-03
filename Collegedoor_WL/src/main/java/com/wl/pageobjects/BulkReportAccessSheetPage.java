package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class BulkReportAccessSheetPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement BackBtn;
	
	@FindBy(xpath="//input[@id='customCheckbox3']")
	WebElement checkBox;
	
	@FindBy(xpath="//button[@id='adm-up-upload']")
	WebElement importDataBtn;
	
	@FindBy(xpath="//tbody/tr[3]/td[6]")
	WebElement notfoundMessageTh;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/section[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[5]//td[6]")
	WebElement notfoundMessageStd;
	
	@FindBy(xpath="//tbody/tr[6]/td[6]")
	WebElement alreadyCombination;
	
	public BulkReportAccessSheetPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyNotTeacherMsg() {
		String message=notfoundMessageTh.getText();
		return message;
	}
	
	public String verifyNotStudentMsg() {
		String message=notfoundMessageStd.getText();
		return message;
	}
	
	public String verifyAlreadyExistCom() {
		String message=alreadyCombination.getText();
		return message;
	}
	
	public ReportAccessHomePage uploadSheet() {
		method.click(driver, checkBox);
		method.click(driver, importDataBtn);
		return new ReportAccessHomePage();
	}
}
