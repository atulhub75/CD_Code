package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ReportAccessHomePage;
import com.wl.pageobjects.ReportAccessViewPage;
import com.wl.utility.Log;

public class ReportAccess_TC15 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ReportAccessHomePage reportAccessHomePage;
	private ReportAccessViewPage reportAccessViewPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyviewReportAccessBtn() {
		Log.startTestCase("Test for verify that when click on view button user report access details are display");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		reportAccessViewPage=reportAccessHomePage.clickViewDetails();
		Log.info("click on view button");
		boolean result=reportAccessViewPage.isPresent();
		Assert.assertTrue(result);
		Log.endTestCase("Finished Test ReportAccess_TC15");
		
	}
}
