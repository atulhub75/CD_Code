package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.BulkUserUploadPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.UserListHomePage;
import com.wl.utility.Log;

public class BulkUserCreation_TC2 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private UserListHomePage userListHomePage;
	private BulkUserUploadPage bulkUserUploadPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyReCaptcha() throws InterruptedException {
		Log.startTestCase("Test for verify that captcha changes when click on re-captcha icon");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password And Login successfully");
		userListHomePage=homepage.clickUserManagement();
		Log.info("click on userlist");
		bulkUserUploadPage=userListHomePage.bulkUserCreation();
		Log.info("click on bulk user creation");
		Thread.sleep(2000);
		String oldCaptcha=bulkUserUploadPage.firstCaptcha();
		Log.info("Enter first captcha");
		Thread.sleep(2000);
		String newCaptcha=bulkUserUploadPage.secondCaptcha();
		Log.info("Enter second captcha");
		Assert.assertNotEquals(oldCaptcha, newCaptcha);
		Log.endTestCase("Finished Test BulkUserCreation_TC2");
	}
}
