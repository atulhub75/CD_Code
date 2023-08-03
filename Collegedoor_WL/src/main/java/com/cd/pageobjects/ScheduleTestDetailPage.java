package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ScheduleTestDetailPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[contains(.,'Add Students')]")
	WebElement addStudent;
	
	@FindBy(xpath="//button[normalize-space()='Edit Scheduled Test']")
	WebElement editTest;
	
	@FindBy(xpath="//button[normalize-space()='Delete Schedule Test']")
	WebElement deleteTest;
	
	@FindBy(xpath="//button[@id='back_btn']")
	WebElement backBtn;
	
	@FindBy(xpath="//span[normalize-space()='Export All Data']")
	WebElement exportAllDataBtn;
	
	@FindBy(xpath="//span[normalize-space()='Excel']")
	WebElement excelBtn;
	
	@FindBy(xpath="//body/div[@class='container-fluid']/div[@class='row']/div[@class='col-sm-12']/div[1]/div[1]/h4[1]")
	WebElement Heading;
	
	public ScheduleTestDetailPage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddStudentPage clickAddStudent() {
		method.click(driver, addStudent);
		return new AddStudentPage();
	}
	
	public ScheduleTestPage clickEditScheduleTest() {
		method.click(driver, editTest);
		return new ScheduleTestPage();
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, Heading);
	}
	
	public void clickDeleteScheduleTest() {
		method.click(driver, deleteTest);
	}
	
	public ScheduleTestListPage clickAlert() throws InterruptedException {
		method.Alert(driver);
		Thread.sleep(2000);
		method.Alert(driver);
		return new ScheduleTestListPage();
	}
	
	public void clickExportAllData() {
		method.click(driver, exportAllDataBtn);
	}
	
	public void clickExcel() {
		method.click(driver, excelBtn);
	}
}
