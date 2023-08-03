package com.wl.tipsQplistPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.pageobjects.CDHomePage;
import com.cd.pageobjects.TipsQpListPage;
import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;

public class TC_TipsQplist_2 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private CDHomePage cdHomePage;
	private TipsQpListPage tipsQpListPage;
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyTipsQplistFunctionality() throws InterruptedException {
		Log.startTestCase("Test for verify created by dropdown");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter userName and password and Login successfull");
		Thread.sleep(2000);
		cdHomePage=homepage.clickDashboard();
		Log.info("click dashboard Utility");
		tipsQpListPage=cdHomePage.clickTips();
		Log.info("click on click Tips button");
		tipsQpListPage.clickCreatedBy();
		Thread.sleep(2000);
	}
}
