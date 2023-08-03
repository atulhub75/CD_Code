package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ReportAccessHomePage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@name='from_user']")
	WebElement fUser;
	
	@FindBy(xpath="//input[@name='to_user']")
	WebElement tUser;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement search;
	
	@FindBy(xpath="//tbody/tr/td[3]")
	WebElement searchedUser;
	
	@FindBy(xpath="//a[normalize-space()='Add New']")
	WebElement addNewBtn;
	
	@FindBy(xpath="//a[normalize-space()='Bulk Upload']")
	WebElement addBulkNewBtn;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/section[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/form[1]/button[1]/i[1]")
	WebElement deleteBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement confirmMsg;
	
	@FindBy(xpath="//tbody/tr[1]/td[6]/a[1]/button[1]/i[1]")
	WebElement viewButton;
	
	public ReportAccessHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrentURL() {
		String reportAccesspageURL=method.getCurrentURL(driver);
		return reportAccesspageURL;
	}
	
	public CreateReportAccessPage clickAddNewReport() {
		method.click(driver, addNewBtn);
		return new CreateReportAccessPage();
	}
	
	public String getCurrURLforBackBtn() {
		String reportAccesspageURL=method.getCurrentURL(driver);
		return reportAccesspageURL;
	}
	
	public BulkReportAccessPage clickBulkReportAccess() {
		method.click(driver, addBulkNewBtn);
		return new BulkReportAccessPage();
	}
	
	public void clickDeleteButton() {
		method.click(driver, deleteBtn);
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, confirmMsg);
	}
	
	public void searchResult() {
		method.sendKeys(fUser, "atul.dm");
		method.sendKeys(tUser, "institute");
		method.click(driver, search);
	}
	
	public boolean isPresent() {
		return method.isDisplayed(driver, searchedUser);
	}
	
	public ReportAccessViewPage clickViewDetails() {
		method.click(driver, viewButton);
		return new ReportAccessViewPage();
	}
}
