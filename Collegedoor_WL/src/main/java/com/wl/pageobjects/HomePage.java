package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.pageobjects.CDHomePage;
import com.cd.pageobjects.TakeTestPage;
import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class HomePage extends BaseClass {
	Methods method=new Methods();
	
	@FindBy(xpath="//p[normalize-space()='Whitelabel']")
	WebElement whiteLableUtility;
	
	@FindBy(xpath="(//a[@class='nav-link'])[contains(.,'My Account')]")
	WebElement myAccountUtility;
	
	@FindBy(xpath="//a[@href='https://uatmigration.collegedoors.com/dynamicwl/user-activation-list']//i[@class='far fa-circle nav-icon']")
	WebElement userListbtn;
	
	@FindBy(xpath="//a[@href='https://uatmigration.collegedoors.com/dynamicwl/cd_dashboard']//i[@class='far fa-circle nav-icon']")
	WebElement dashboardBtn;
	
	@FindBy(xpath="//a[@href='/dynamicwl/take-test']")
	WebElement takeTestBtn;
	
	@FindBy(xpath="//a[@href='https://uatmigration.collegedoors.com/dynamicwl/whitelabel']//i[@class='far fa-circle nav-icon']")
	WebElement createWLBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement loginMsg;
	
	@FindBy(xpath="//span[@class='d-none d-md-inline']")
	WebElement adminbtn;
	
	@FindBy(xpath="//a[normalize-space()='Sign out']")
	WebElement signoutbtn;
	
	@FindBy(xpath="//a[@href='https://uatmigration.collegedoors.com/dynamicwl/report-access']//i[@class='far fa-circle nav-icon']")
	WebElement reportAccessBtn;
	
	@FindBy(xpath="//body[1]/div[1]/aside[1]/div[1]/nav[1]/ul[1]/li[6]/a[1]")
	WebElement ATMbtn;
	
	@FindBy(xpath="//a[@href='https://uatmigration.collegedoors.com/master/question-paper-generation']//i[@class='far fa-circle nav-icon']")
	WebElement paperGen;
	
	@FindBy(xpath="//a[@href='https://demo.collegedoors.com/master/question-paper-generation']//i[@class='far fa-circle nav-icon']")
	WebElement paperGenp;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrURL() {
		String homepageURL=method.getCurrentURL(driver);
		return homepageURL;
	}
	
	public UserListHomePage clickUserList() {
		//method.fluentWait(driver, whiteLableUtility, 5);
		method.scrollByVisibilityOfElement(driver, whiteLableUtility);
		method.click(driver, whiteLableUtility);
		method.fluentWait(driver, userListbtn, 10);
		method.scrollByVisibilityOfElement(driver, userListbtn);	
		method.click(driver, userListbtn);
		return new UserListHomePage();
	}
	
	public UserListHomePage clickUserManagement() {
		method.click(driver, myAccountUtility);
		//method.fluentWait(driver, userListbtn, 5);
		method.click(driver, userListbtn);
		return new UserListHomePage();
	}
	
	
	public CDHomePage clickDashboard() {
		//method.fluentWait(driver, whiteLableUtility, 3);
		//method.scrollByVisibilityOfElement(driver, whiteLableUtility);
		method.click(driver, whiteLableUtility);
		method.fluentWait(driver, userListbtn, 5);
		method.scrollByVisibilityOfElement(driver, dashboardBtn);	
		method.click(driver, dashboardBtn);
		return new CDHomePage();
	}
	
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, loginMsg);
	}
	
	public void logoutMethod() {
		method.click(driver, adminbtn);
		method.fluentWait(driver, signoutbtn, 5);
		method.click(driver, signoutbtn);
	}
	
	public ReportAccessHomePage clickReportAccess() {
		method.click(driver, myAccountUtility);
		method.fluentWait(driver, reportAccessBtn, 2);
		method.click(driver, reportAccessBtn);
		return new ReportAccessHomePage();
	}
	
	public ATMHomePage clickATM() throws Exception {
		method.fluentWait(driver, ATMbtn, 5);
		//method.click(driver, ATMbtn);
		method.JSClick(driver, ATMbtn);
		method.JSClick(driver, paperGenp);
		return new ATMHomePage();
	}
	
	public TakeTestPage clickTakeTest() {
		method.click(driver, takeTestBtn);
		return new TakeTestPage();
	}
}
