package com.wl.userList;

import org.testng.Assert;
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

public class ReportAccess_TC7 extends BaseClass{
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
	public void verifyRecaptchaFunction() throws InterruptedException {
		Log.startTestCase("Test for verify captcha changes when click on re-captcha icon");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		reportAccessHomePage=homepage.clickReportAccess();
		Log.info("click on Report access");
		bulkReportAccessPage=reportAccessHomePage.clickBulkReportAccess();
		Log.info("click on Add New Report access");
		String actual=bulkReportAccessPage.firstCaptcha();
		Log.info("Enter first captcha");
		Thread.sleep(2000);
		String expected=bulkReportAccessPage.secondCaptcha();
		Log.info("Enter first second captcha");
		Assert.assertNotEquals(actual, expected);
		Log.endTestCase("Finished Test ReportAccess_TC7");
	}
}
