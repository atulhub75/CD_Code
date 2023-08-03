package com.wl.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ResetPasswordPage;
import com.wl.utility.Log;

public class ResetPasswordTest extends BaseClass {

	private IndexPage indexPage;
	private LoginPage loginpage;
	private ResetPasswordPage resetPasswordPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyResetPasswordFunction() throws Throwable {	
		Log.info("Start ResetPassword testCase");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		resetPasswordPage=loginpage.clickResetButton();
		Log.info("click Reset password button");
		resetPasswordPage.verifyResetPassword("atulinst1", "atulinst1@gmail.com");
		Log.info("Enter email id and password");
		boolean result=resetPasswordPage.validateMessage();
		Assert.assertTrue(result);	
		Log.info("Finished Reset Password test");
	}
}
