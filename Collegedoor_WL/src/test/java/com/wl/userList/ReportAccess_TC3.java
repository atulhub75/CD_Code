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

public class ReportAccess_TC3 extends BaseClass{
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
	public void verifyBackButtonFunction() {
		Log.startTestCase("Test for verify back button functionality");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		createReportAccessPage=reportAccessHomePage.clickAddNewReport();
		Log.info("click on Add New Report access");
		reportAccessHomePage=createReportAccessPage.clickBackBtn();
		Log.info("click on back button");
		String actual=reportAccessHomePage.getCurrURLforBackBtn();
		String result="https://uatmigration.collegedoors.com/dynamicwl/report-access";
		Assert.assertEquals(actual, result);
		Log.endTestCase("Finished Test ReportAccess_TC3");
	}

}
