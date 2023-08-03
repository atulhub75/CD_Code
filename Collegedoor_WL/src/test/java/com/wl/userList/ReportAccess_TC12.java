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

public class ReportAccess_TC12 extends BaseClass{
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
	public void verifyWrongMessage() throws InterruptedException {
		Log.startTestCase("Test for verify that in bulk report access sheet page \"combination already exist\" message ");
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
		String actual=bulkReportAccessSheetPage.verifyAlreadyExistCom();
		String expected="Error Existing (Student Not Found)";
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Finished Test ReportAccess_TC11");
	}
}
