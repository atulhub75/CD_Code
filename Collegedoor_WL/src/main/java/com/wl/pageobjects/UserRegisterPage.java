package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class UserRegisterPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='name']")
	WebElement fName;
	
	@FindBy(xpath="//input[@name='lname']")
	WebElement lName;
	
	@FindBy(xpath="//input[@id='user_id']")
	WebElement userId;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='school_name']")
	WebElement school;
	
	@FindBy(xpath="//input[@name='city_name']")
	WebElement city;
	
	@FindBy(xpath="//input[@name='stream']")
	WebElement stream;
	
	@FindBy(xpath="//select[@name='student_class']")
	WebElement className;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement confirmPassword;
	
	@FindBy(xpath="//button[normalize-space()='Register']")
	WebElement registerbtn;
	
	@FindBy(xpath="//button[normalize-space()='Reset']")
	WebElement resetbtn;
	
	public UserRegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage registerUser() {
		method.sendKeys(fName, "atul");
		method.sendKeys(lName, "Margil");
		method.sendKeys(userId, "atul."+method.randomestring4());
		method.sendKeys(email, method.randomestring()+"@gmail.com");
		method.sendKeys(school, "ovent");
		method.sendKeys(city, "pune");
		method.sendKeys(stream, "Science");
		method.fluentWait(driver, className, 5);
		method.selectByVisibleText("12", className);
		method.sendKeys(password, "abc123");
		method.sendKeys(confirmPassword, "abc123");
		//method.fluentWait(driver, registerbtn, 5);
		method.scrollByVisibilityOfElement(driver, registerbtn);
		method.click(driver, registerbtn);
		return new LoginPage();
	}
	
	public void clickResetButton() {
		method.sendKeys(fName, "atul");
		method.sendKeys(lName, "Margil");
		method.sendKeys(userId, "atul."+method.randomestring4());
		method.sendKeys(email, method.randomestring()+"@gmail.com");
		method.sendKeys(school, "ovent");
		method.sendKeys(city, "pune");
		method.sendKeys(stream, "Science");
		method.fluentWait(driver, className, 5);
		method.selectByVisibleText("12", className);
		method.sendKeys(password, "abc123");
		method.sendKeys(confirmPassword, "abc123");
		//method.fluentWait(driver, registerbtn, 5);
		method.scrollByVisibilityOfElement(driver, registerbtn);
		method.click(driver, resetbtn);
	}
	
	public String getCurrURL() {
		String RegisterURL=method.getCurrentURL(driver);
		return RegisterURL;
	}
}
