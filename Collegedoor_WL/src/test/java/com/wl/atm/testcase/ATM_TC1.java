package com.wl.atm.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.ATMHomePage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;

public class ATM_TC1 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ATMHomePage aTMHomePage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyAtmClick() throws Exception {
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Thread.sleep(2000);
		aTMHomePage=homepage.clickATM();
		String actual=aTMHomePage.getCurrURL();
		String expected="https://uatmigration.collegedoors.com/master/question-paper-generation";
		Assert.assertEquals(actual, expected);
	}
}
