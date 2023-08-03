package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.BulkNewPasswordPage;
import com.wl.pageobjects.BulkPasswordSheetPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.UserListHomePage;
import com.wl.utility.Log;

public class BulkChangePassword_TC7 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private UserListHomePage userListHomePage;
	private BulkNewPasswordPage bulkNewPasswordPage;
	private BulkPasswordSheetPage bulkPasswordSheetPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyBackButtonFunction() throws InterruptedException {
		Log.startTestCase("Test for verify back button function");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		userListHomePage=homepage.clickUserManagement();
		Log.info("click on userlist");
		bulkNewPasswordPage=userListHomePage.clickBulkNewPassword();
		Log.info("click on bulk password change");
		Thread.sleep(2000);
		bulkNewPasswordPage.verifyUploadFunction();
		Log.info("upload file");
		bulkPasswordSheetPage=bulkNewPasswordPage.verifyCaptcha();
		Log.info("Enter Captcha");
		Thread.sleep(2000);
		bulkNewPasswordPage=bulkPasswordSheetPage.clickBackButton();
		Log.info("click back button");
		String actual=bulkNewPasswordPage.getCurrURLforBackBtn();
		String expected="https://uatmigration.collegedoors.com/dynamicwl/set-bulk-password";
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Finished Test BulkChangePassword_TC7");
	}
}
