package com.wl.tips.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.pageobjects.CDHomePage;
import com.cd.pageobjects.TipsHomePage;
import com.cd.pageobjects.TipsQpListPage;
import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;

public class TS4_Tips_TC4 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private CDHomePage cdHomePage;
	private TipsQpListPage tipsQpListPage;
	private TipsHomePage tipsHomePage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyTipsFunction() throws Exception {
		Log.startTestCase("Test for select Exam JEE Main,sub=Physics and difficulty=Easy,Medium, verify display questions");
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
		Thread.sleep(2000);
		tipsHomePage=tipsQpListPage.clickCreateQp();
		Log.info("click create Question paper");
		Thread.sleep(6000);
		tipsHomePage.selectExam("JEE Main");
		Log.info("select Exam");
		Thread.sleep(2000);
		tipsHomePage.selectSubject("Physics");
		Log.info("select subject");
		Thread.sleep(2000);
		tipsHomePage.selectEasyMedium();
		Log.info("select difficulty");
		Thread.sleep(2000);
		tipsHomePage.SelectQuestion("10");
		Log.info("select number of question");
		tipsHomePage.clickSearchButton();
		Log.info("click search button");
		Thread.sleep(30000);
		boolean result=tipsHomePage.isPresent();
		Assert.assertTrue(result);
		Log.info("validate Question displayed");
		Log.endTestCase("TS4_Tips_TC4");
	}
}
