package com.wl.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.UserRegisterPage;
import com.wl.utility.Log;


public class RegisterResetBtnTest extends BaseClass {
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
	public void verifyRegisterResetButton() throws InterruptedException {
		Log.info("Start Register testCase");
		IndexPage indexPage=new IndexPage();
		userRegisterPage=indexPage.clickRegister();
		Log.info("click Register button");
		userRegisterPage.clickResetButton();
		Log.info("Reset data successfull");
		Thread.sleep(2000);
		String expected=userRegisterPage.getCurrURL();
		String Actual="https://uatmigration.collegedoors.com/dynamicwl/register";
	    Assert.assertEquals(expected, Actual);
	    Log.info("Finished Register test");
	}
}
