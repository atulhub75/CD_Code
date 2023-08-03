package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.CreateReportAccessPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ReportAccessHomePage;
import com.wl.utility.Log;

public class ReportAccess_TC2 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ReportAccessHomePage reportAccessHomePage;
	private CreateReportAccessPage createReportAccessPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyAddNewReportFunction() throws Throwable {
		Log.startTestCase("Test for verify that add new report access functionality");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		createReportAccessPage=reportAccessHomePage.clickAddNewReport();
		Log.info("click on Add New Report access");
		createReportAccessPage.selectFromUser();
		Log.info("select from user");
		createReportAccessPage.selectToUser();
		Log.info("select to user");
		reportAccessHomePage=createReportAccessPage.clickCreateButton();
		Log.info("click on create report access");
		Thread.sleep(3000);
		boolean result=reportAccessHomePage.validateMessage();
		Assert.assertTrue(result);
		Log.endTestCase("Finished Test ReportAccess_TC2");
		
	}
}
