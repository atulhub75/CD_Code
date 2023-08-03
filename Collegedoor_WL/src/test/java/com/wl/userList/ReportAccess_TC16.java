package com.wl.userList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ReportAccessHomePage;
import com.wl.utility.Log;

public class ReportAccess_TC16 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ReportAccessHomePage reportAccessHomePage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	public void vrifyDeleteAccess() throws Throwable {
		Log.startTestCase("Test for verify that when click on delete button report access are deleted");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		reportAccessHomePage.clickDeleteButton();
		Log.info("click on delete button");
		reportAccessHomePage.validateMessage();
		Log.endTestCase("Finished Test ReportAccess_TC16");
	}

}
