package com.wl.userList;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.BulkNewPasswordPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.UserListHomePage;
import com.wl.utility.Log;

public class BulkChangePassword_TC3 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private UserListHomePage userListHomePage;
	private BulkNewPasswordPage bulkNewPasswordPage;
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyDownloadFileTemplate() throws InterruptedException {
		Log.startTestCase("Test for verify Download csv file");
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
		bulkNewPasswordPage.clickDownloadFile();
		Log.info("click on download file");
		Thread.sleep(2000);
	}
}
