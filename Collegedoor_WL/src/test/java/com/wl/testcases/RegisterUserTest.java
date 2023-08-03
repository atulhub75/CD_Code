package com.wl.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.UserRegisterPage;
import com.wl.utility.Log;

public class RegisterUserTest extends BaseClass {

	private UserRegisterPage userRegisterPage;
	private LoginPage loginPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyUserRegistration() throws Throwable {
		Log.info("Start Register testCase");
		IndexPage indexPage=new IndexPage();
		userRegisterPage=indexPage.clickRegister();
		Log.info("click Register button");
		loginPage=userRegisterPage.registerUser();
		Log.info("Register user successful");
		boolean result=loginPage.validateMessage();
		Assert.assertTrue(result);
		Log.info("Finished Register test");
	}
}
