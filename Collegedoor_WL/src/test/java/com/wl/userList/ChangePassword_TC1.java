package com.wl.userList;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.SetNewPasswordPage;
import com.wl.pageobjects.UserListHomePage;

public class ChangePassword_TC1 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private UserListHomePage userListHomePage;
	private SetNewPasswordPage setNewPasswordPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyNewPassword() throws Throwable {
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		userListHomePage=homepage.clickUserManagement();
		setNewPasswordPage=userListHomePage.clickNewPassword();
		setNewPasswordPage.newPassword();
		Thread.sleep(5000);
		setNewPasswordPage.newPassword2();
		Thread.sleep(2000);
		boolean actualMsg=setNewPasswordPage.validateMessage();
		Assert.assertTrue(actualMsg);
	}
}
