package com.wl.userList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.BulkReportAccessPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ReportAccessHomePage;
import com.wl.utility.Log;

public class ReportAccess_TC8 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ReportAccessHomePage reportAccessHomePage;
	private BulkReportAccessPage bulkReportAccessPage;
	
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyDownloadFileFunction() throws InterruptedException {
		Log.startTestCase("Test for verify file download function");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		bulkReportAccessPage=reportAccessHomePage.clickBulkReportAccess();
		Log.info("click on Add New Report access");
		bulkReportAccessPage.clickDownloadFile();
		Log.info("click on Download file");
		Thread.sleep(2000);
		Log.endTestCase("Finished Test ReportAccess_TC8");
	}
}
