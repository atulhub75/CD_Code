package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class SetNewPasswordPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//span[@id='select2-user_id-container']")
	WebElement selectUser;
	
	@FindBy(xpath="//input[@role='searchbox']")
	WebElement searchBox;
	
	@FindBy(xpath="//li[@role='option']")
	WebElement searchOption;
	
	@FindBy(xpath="//input[@id='npassword']")
	WebElement newPassword;
	
	@FindBy(xpath="//input[@id='cpassword']")
	WebElement confPassword;
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//input[@value='Reset']")
	WebElement resetbtn;
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backbtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement passwordChangeMsg;
	
	public SetNewPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void newPassword() throws Exception {
		method.click(driver, selectUser);
		Thread.sleep(2000);
		method.sendKeys(searchBox, "atul.dm");
		Thread.sleep(5000);
		method.click(driver, searchOption);
		
		}
	public void newPassword2() {
		method.fluentWait(driver, newPassword, 5);
		method.sendKeys(newPassword, "abc1234");
		method.sendKeys(confPassword, "abc1234");
		method.click(driver, submitbtn);
	}
	
	public void clickResetButton() {
		method.fluentWait(driver, newPassword, 5);
		method.sendKeys(newPassword, "abc1234");
		method.sendKeys(confPassword, "abc1234");
		method.click(driver, resetbtn);
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, passwordChangeMsg);
	}
	
	public UserListHomePage clickBackButton() {
		method.click(driver, backbtn);
		return new UserListHomePage();
	}
	
	public String getCurrURLforResetBtn() {
		String setPasswordpageURL=method.getCurrentURL(driver);
		return setPasswordpageURL;
	}
}
