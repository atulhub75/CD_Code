package com.cd.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.base.BaseClass;
import com.cd.pageobjects.HomePage;
import com.cd.pageobjects.IndexPage;
import com.cd.pageobjects.LoginPage;
import com.cd.pageobjects.TipsHomePage;
import com.cd.pageobjects.TipsQuestionListPage;


public class TC_001_TIPS extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private TipsQuestionListPage tipsquestionpaperList;
	private TipsHomePage tipshomePage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	/*@AfterMethod
	public void TearDown() {
		driver.quit();
	}*/
	
	@Test
	public void validateTipsPage() throws InterruptedException {
		indexPage=new IndexPage();
		loginpage=indexPage.clickONLogin();
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
		tipsquestionpaperList=homepage.clickOnTips();
		Thread.sleep(3000);
		tipshomePage=tipsquestionpaperList.clickCreateQuestionPaper();
		Thread.sleep(6000);
		tipshomePage.selectExam1("JEE Main");
		Thread.sleep(3000);
		tipshomePage.selectSubje();
		//tipshomePage.selectchap("Chemistry");
		//Thread.sleep(3000);
		//tipshomePage.selectDifficulty1();
		//tipshomePage.selectchap();
	}

}
