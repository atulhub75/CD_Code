package com.wl.userList;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.AddNewUserPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.UserListHomePage;
import com.wl.utility.Log;

public class AddUser_TC4 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private UserListHomePage userListHomePage;
	private AddNewUserPage addNewUserPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyBackButtonFunctionality() throws InterruptedException {
		Log.startTestCase("Add user back button test");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter user Name and password");
		userListHomePage=homepage.clickUserManagement();
		Log.info("click on userlist");
		Thread.sleep(3000);
		addNewUserPage=userListHomePage.clickAddNewUser();
		Log.info("click AddNewUser button");
		userListHomePage=addNewUserPage.clickBackButton();
		Log.info("click back button");
		String actual=userListHomePage.getCurrURLforBackBtn();
		String expected="https://uatmigration.collegedoors.com/dynamicwl/user-activation-list";
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Finished Test AddUser_TC4 ");
	}
}
