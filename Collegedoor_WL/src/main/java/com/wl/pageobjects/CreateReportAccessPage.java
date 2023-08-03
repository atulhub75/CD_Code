package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class CreateReportAccessPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//span[@id='select2-from_user_id-container']")
	WebElement fUser;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")
	WebElement fUserSearchBox;
	
	@FindBy(xpath="//li[@role='option']")
	WebElement fUserSearchOption;
	
	@FindBy(xpath="//span[@id='select2-to_user_id-container']")
	WebElement lUser;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")
	WebElement lUserSearchBox;
	
	@FindBy(xpath="//li[@role='option']")
	WebElement lUserSearchOption;
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//input[@value='Create']")
	WebElement createBtn;
	
	@FindBy(xpath="//a[normalize-space()='Reset']")
	WebElement resetBtn;
	
	public CreateReportAccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ReportAccessHomePage clickBackBtn() {
		method.click(driver, backBtn);
		return new ReportAccessHomePage();
	}
	
	public void selectFromUser() throws InterruptedException {
		method.click(driver, fUser);
		Thread.sleep(2000);
		method.sendKeys(fUserSearchBox, "atul.dm");
		Thread.sleep(5000);
		method.click(driver, fUserSearchOption);
	}
	
	public void selectToUser() throws InterruptedException {
		method.click(driver, lUser);
		Thread.sleep(2000);
		method.sendKeys(lUserSearchBox, "institute");
		Thread.sleep(5000);
		method.click(driver, lUserSearchOption);
	}
	
	public void clickResetButton() {
		method.click(driver, resetBtn);
	}
	
	public ReportAccessHomePage clickCreateButton() {
		method.click(driver, createBtn);
		return new ReportAccessHomePage();
	}
}
