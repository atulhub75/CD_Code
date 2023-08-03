package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.BulkReportAccessPage;
import com.wl.pageobjects.BulkReportAccessSheetPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ReportAccessHomePage;
import com.wl.utility.Log;

public class ReportAccess_TC13 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ReportAccessHomePage reportAccessHomePage;
	private BulkReportAccessPage bulkReportAccessPage;
	private BulkReportAccessSheetPage bulkReportAccessSheetPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyBulkReportAccessFunction() throws InterruptedException {
		Log.startTestCase("Test for verify bulk report access functinality");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		bulkReportAccessPage=reportAccessHomePage.clickBulkReportAccess();
		Log.info("click on bulk report access");
		bulkReportAccessPage.upoadFile();
		Log.info("upload file");
		bulkReportAccessSheetPage=bulkReportAccessPage.setCaptcha();
		Log.info("Enter captcha");
		Thread.sleep(2000);
		reportAccessHomePage=bulkReportAccessSheetPage.uploadSheet();
		Log.info("click upload sheet");
		Thread.sleep(2000);
		String actual=reportAccessHomePage.getCurrentURL();
		String expected="https://uatmigration.collegedoors.com/dynamicwl/report-access";
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Finished Test ReportAccess_TC13");
	}
}
