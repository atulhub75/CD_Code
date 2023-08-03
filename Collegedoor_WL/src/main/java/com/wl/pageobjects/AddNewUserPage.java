package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class AddNewUserPage extends BaseClass {
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement fName;

	@FindBy(xpath="//input[@id='lname']")
	WebElement lName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userId;
	
	@FindBy(xpath="//input[@id='user_email_id']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='school_name']")
	WebElement school;
	
	@FindBy(xpath="//input[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//select[@id='class']")
	WebElement className;
	
	@FindBy(xpath="//input[@id='stream']")
	WebElement stream;
	
	@FindBy(xpath="//select[@id='activation_status']")
	WebElement activationStatus;
	
	@FindBy(xpath="//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath="//input[@id='contact']")
	WebElement contact;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Add']")
	WebElement addbtn;
	
	@FindBy(xpath="//a[normalize-space()='Reset']")
	WebElement resetbtn;
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backbtn;
	
	public AddNewUserPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public UserListHomePage verifyAddNewUserFunctionality() {
		method.fluentWait(driver, fName, 5);
		method.sendKeys(fName, "atul");
		method.sendKeys(lName, "margil");
		method.sendKeys(userId, "atul."+method.randomestring4());
		method.sendKeys(email, method.randomestring()+"@gmail.com");
		method.sendKeys(school, "RCC school");
		//method.sendKeys(city, "pune");
		//method.selectByVisibleText("12", className);
		//method.sendKeys(stream, "JEE");
		method.selectByVisibleText("Active", activationStatus);
		method.selectByVisibleText("STUDENT", userType);
		method.sendKeys(contact, "8999916687");
		method.sendKeys(password, "abc123");
		method.click(driver, addbtn);
		return new UserListHomePage();
	}
	public UserListHomePage verifyAddNewUserFunctionality1() {
		method.fluentWait(driver, fName, 5);
		method.sendKeys(fName, "atul");
		method.sendKeys(lName, "margil");
		method.sendKeys(userId, "atul."+method.randomestring4());
		method.sendKeys(email, method.randomestring()+"@gmail.com");
		method.sendKeys(school, "RCC school");
		method.sendKeys(city, "pune");
		method.selectByVisibleText("12", className);
		method.sendKeys(stream, "JEE");
		method.selectByVisibleText("Active", activationStatus);
		method.selectByVisibleText("TEACHER", userType);
		method.sendKeys(password, "abc123");
		method.click(driver, addbtn);
		return new UserListHomePage();
	}
	
	public UserListHomePage verifyAddNewUserFunctionality2() {
		method.fluentWait(driver, fName, 5);
		method.sendKeys(fName, "atul");
		method.sendKeys(lName, "margil");
		method.sendKeys(userId, "atul."+method.randomestring4());
		method.sendKeys(email, method.randomestring()+"@gmail.com");
		method.sendKeys(school, "RCC school");
		method.sendKeys(city, "pune");
		method.selectByVisibleText("12", className);
		method.sendKeys(stream, "JEE");
		method.selectByVisibleText("Active", activationStatus);
		method.selectByVisibleText("INSTITUTE", userType);
		method.sendKeys(password, "abc123");
		method.click(driver, addbtn);
		return new UserListHomePage();
	}
	
	public UserListHomePage clickBackButton() {
		method.click(driver, backbtn);
		return new UserListHomePage();
	}
	
	public void clickResetButton() {
		method.fluentWait(driver, fName, 5);
		method.sendKeys(fName, "atul");
		method.sendKeys(lName, "margil");
		method.sendKeys(userId, "atul."+method.randomestring4());
		method.sendKeys(email, method.randomestring()+"@gmail.com");
		method.sendKeys(school, "RCC school");
		method.sendKeys(city, "pune");
		method.selectByVisibleText("12", className);
		method.sendKeys(stream, "JEE");
		method.selectByVisibleText("Active", activationStatus);
		method.selectByVisibleText("INSTITUTE", userType);
		method.sendKeys(password, "abc123");
		method.click(driver, resetbtn);
	}
	
	public String getCurrURLforResetBtn() {
		String addUserpageURL=method.getCurrentURL(driver);
		return addUserpageURL;
	}
}
