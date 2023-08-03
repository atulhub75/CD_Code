package com.wl.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;

public class LoginTest extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLoginFunctionality() {
		IndexPage indexPage=new IndexPage();
		Log.info("Start test Case");
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password");
		String actualURL=homepage.getCurrURL();
		Log.info("Login successfull");
		String expectedURL="https://uatmigration.collegedoors.com/dynamicwl/home";
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Finished Login Test");
	}
}
