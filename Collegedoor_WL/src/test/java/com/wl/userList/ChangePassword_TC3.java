package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.SetNewPasswordPage;
import com.wl.pageobjects.UserListHomePage;

public class ChangePassword_TC3 extends BaseClass {
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
	public void verifyResetButtonFunctionality() throws Exception {
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		userListHomePage=homepage.clickUserManagement();
		setNewPasswordPage=userListHomePage.clickNewPassword();
		setNewPasswordPage.newPassword();
		Thread.sleep(5000);
		setNewPasswordPage.clickResetButton();
		String actual=setNewPasswordPage.getCurrURLforResetBtn();
		String expected="https://uatmigration.collegedoors.com/dynamicwl/set-password";
		Assert.assertEquals(actual, expected);
	}
}
