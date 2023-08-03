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

public class ChangePassword_TC2 extends BaseClass{
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
	public void verifyBackButtonFunction() {
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		userListHomePage=homepage.clickUserManagement();
		setNewPasswordPage=userListHomePage.clickNewPassword();
		userListHomePage=setNewPasswordPage.clickBackButton();
		String actual=userListHomePage.getCurrURLforBackBtn();
		String expected="https://uatmigration.collegedoors.com/dynamicwl/user-activation-list";
		Assert.assertEquals(actual, expected);
	}
}
