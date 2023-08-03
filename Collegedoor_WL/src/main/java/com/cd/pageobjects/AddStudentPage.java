package com.cd.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class AddStudentPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[@id='delete_record']")
	WebElement addselectedStudent;
	
	@FindBy(xpath="//input[@aria-controls='student_list']")
	WebElement searchStudent;
	
	@FindBy(xpath="//input[@id='name']")
	WebElement StudentName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement studentId;
	
	@FindBy(xpath="//input[@id='from_date']")
	WebElement createdFrom;
	
	@FindBy(xpath="//input[@id='to_date']")
	WebElement createdTo;
	
	@FindBy(xpath="//button[@id='student_info']")
	WebElement searchBtn;
	
	@FindBy(xpath="//button[@id='reset_all']")
	WebElement resetBtn;
	
	@FindBy(xpath="//input[@id='checkall']")
	WebElement checkAll;
	
	@FindBy(xpath="//tbody//tr[1]//td[1]//input[@class='delete_check']")
	WebElement firstCheck;
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	WebElement confirmYes;
	
	@FindBy(xpath="//button[normalize-space()='OK']")
	WebElement okAdded;
	
	@FindBy(xpath="//tbody//tr//td[2]")
	WebElement searchedValue;
	
	@FindBy(xpath="//span[normalize-space()='Export All Data']")
	WebElement exportAllDataBtn;
	
	@FindBy(xpath="//span[normalize-space()='Excel']")
	WebElement excelBtn;
	
	public AddStudentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void selectStudent() throws InterruptedException {
		method.sendKeys(searchStudent, "test.am5");
		Thread.sleep(2000);
		method.click(driver, checkAll);
	}
	
	public void clickSelectedStudent() {
		method.click(driver, addselectedStudent);
	}
	
	public ScheduleTestListPage clickYesNoPopup() throws InterruptedException {
		method.click(driver, confirmYes);
		Thread.sleep(2000);
		method.click(driver, okAdded);
		return new ScheduleTestListPage();
	}
	
	public void searchFromName() {
		method.sendKeys(StudentName, "am2");
	}
	
	public void searchFromUserId() {
		method.sendKeys(studentId, "test.am4");
	}
	
	public void clickSearchBtn() {
		method.click(driver, searchBtn);
	}
	
	public void selectFromAndToDate() throws InterruptedException {
		String date1="03-04-2023";
		String date2="06-06-2023";
		method.click(driver, createdFrom);
		method.sendKeys(createdFrom, date1);
		
		method.click(driver, createdTo);
		method.sendKeys(createdTo, date2);
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+date1+"')", createdFrom);
		Thread.sleep(2000);
		js.executeScript("arguments[0].setAttribute('value','"+date2+"')", createdTo);*/
	}
	
	public void clickResetBtn() {
		method.click(driver, resetBtn);
	}
	
	public boolean validateResultFromName() throws Throwable {
		 return method.isDisplayed(driver, searchedValue);
	}
	
	public void clickExportAllData() {
		method.click(driver, exportAllDataBtn);
	}
	
	public void clickExcel() {
		method.click(driver, excelBtn);
	}
}
