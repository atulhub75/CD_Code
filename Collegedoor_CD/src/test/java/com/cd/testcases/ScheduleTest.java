package com.cd.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.base.BaseClass;
import com.cd.pageobjects.HomePage;
import com.cd.pageobjects.IndexPage;
import com.cd.pageobjects.LoginPage;
import com.cd.pageobjects.ProceedAndSchedule;
import com.cd.pageobjects.ScheduleTestPage;
import com.cd.pageobjects.SummaryOfAddedQuetion;
import com.cd.pageobjects.TipsHomePage;
import com.cd.pageobjects.TipsQuestionListPage;
import com.cd.pageobjects.TipsSelectQuestionPage;

public class ScheduleTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private TipsQuestionListPage tipsquestionpaperList;
	private ScheduleTestPage scheduleTestPage;
	

	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	/*@AfterMethod
	public void TearDown() {
		driver.quit();
	}*/
	
	@Test
	public void verifyQuestionSummary() throws InterruptedException {
		indexPage=new IndexPage();
		loginpage=indexPage.clickONLogin();
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
		tipsquestionpaperList=homepage.clickOnTips();
		Thread.sleep(3000);
		tipsquestionpaperList.clickPaper();
		scheduleTestPage=tipsquestionpaperList.clickScheduleButton();
		scheduleTestPage.enterTestName();
		scheduleTestPage.selectCurrentDate();
		Thread.sleep(3000);
		
		scheduleTestPage.selectCurrentTime();
		scheduleTestPage.selectEndDate();
		scheduleTestPage.selectEndTime();
		scheduleTestPage.clickSubmitButton();
		Thread.sleep(3000);
		scheduleTestPage.clickMessage();
	}
}
