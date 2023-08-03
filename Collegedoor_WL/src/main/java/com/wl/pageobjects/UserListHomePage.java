package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class UserListHomePage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[normalize-space()='Add User']")
	WebElement addUserbtn;
	
	@FindBy(xpath="//button[normalize-space()='Bulk User Creation']")
	WebElement bulkUserbtn;
	
	@FindBy(xpath="//a[@title='Set New Password']//button[1]")
	WebElement setNewPassword;
	
	@FindBy(xpath="//button[normalize-space()='Bulk Set New Password']")
	WebElement setBulkPassword;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement confirmMsg;
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement name;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userId;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath="//input[@id='start_dt']")
	WebElement selectDate;
	
	@FindBy(xpath="//tbody//tr[1]//td[6]")
	WebElement searchedByDate;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement searchBtn;
	
	@FindBy(xpath="//td[normalize-space()='OTMIGR_atul.am']")
	WebElement searchUser;
	
	@FindBy(xpath="//a[normalize-space()='Reset']")
	WebElement resetBtn;
	
	@FindBy(xpath="//a[normalize-space()='Download']")
	WebElement downloadBtn;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/section[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/a[1]/button[1]/i[1]")
	WebElement editBtn;
	
	@FindBy(xpath="//body[1]/div[1]/div[1]/section[1]/main[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/form[1]/button[1]/i[1]")
	WebElement deleteBtn;
	//div[@class='alert alert-success']
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement deleteMessage;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement editMessage;
	
	@FindBy(xpath="//input[@placeholder='Search...']")
	WebElement searchField;
	
	public UserListHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public AddNewUserPage clickAddNewUser() {
		method.click(driver, addUserbtn);
		return new AddNewUserPage();
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, confirmMsg);
	}
	
	public SetNewPasswordPage clickNewPassword() {
		method.click(driver, setNewPassword);
		return new SetNewPasswordPage();
	}
	
	public BulkUserUploadPage bulkUserCreation() {
		method.click(driver, bulkUserbtn);
		return new BulkUserUploadPage();
	}
	
	public BulkNewPasswordPage clickBulkNewPassword() {
		method.click(driver, setBulkPassword);
		return new BulkNewPasswordPage();
	}
	public String getCurrURLforBackBtn() {
		String userListpageURL=method.getCurrentURL(driver);
		return userListpageURL;
	}
	
	public void searchByDate() {
		method.datePickerByJS(driver, "26-02-2023", selectDate);
		System.out.println("date selected");
		method.click(driver, searchBtn);
	}
	
	public void searchData() {
		method.sendKeys(name, "teacher");
		method.sendKeys(userId, "atul.am");
		method.selectByVisibleText("TEACHER", userType);
		method.click(driver, searchBtn);	
	}
	
	public boolean isPresent() {
		return method.isDisplayed(driver, searchUser);
	}
	
	public boolean isPresent1() {
		return method.isDisplayed(driver, searchedByDate);
	}
	
	public void verifyDownloadData() {
		method.click(driver, downloadBtn);
	}
	
	public void clickDeleteUser() {
		method.click(driver, deleteBtn);
		method.Alert(driver);
	}
	
	public boolean validateDeleteMessage() throws Throwable {
		 return method.isDisplayed(driver, deleteMessage);
	}
	
	public EditUserPage clickEditButton() {
		method.click(driver, editBtn);
		return new EditUserPage();
	}
	
	
	public boolean validateEditMessage() throws Throwable {
		 return method.isDisplayed(driver, editMessage);
	}
}
