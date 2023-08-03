package com.wl.ScheduleTestFlow;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.pageobjects.AddStudentPage;
import com.cd.pageobjects.CDHomePage;
import com.cd.pageobjects.ScheduleTestDetailPage;
import com.cd.pageobjects.ScheduleTestPage;
import com.cd.pageobjects.TipsQpListPage;
import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;

public class ScheduleTest_TC10 extends BaseClass{

	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private CDHomePage cdHomePage;
	private TipsQpListPage tipsQpListPage;
	private ScheduleTestPage scheduleTestPage;
	private ScheduleTestDetailPage scheduleTestDetailPage;
	private AddStudentPage addStudentPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifySchedulePaperFunctionality() throws Throwable {
		Log.startTestCase("Test for validate download Export All data");
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
		tipsQpListPage.clickPaper();
		Log.info("click question paper");
		scheduleTestPage=tipsQpListPage.clickScheduleButton();
		Log.info("click Schedule button");
		scheduleTestPage.enterTestName();
		Log.info("Enter Test Name");
		scheduleTestPage.selectCurrentDate();
		Log.info("Enter Start Date");
		scheduleTestPage.selectCurrentTime();
		Log.info("Enter Start Time");
		scheduleTestPage.selectEndDate();
		Log.info("Enter End Date");
		scheduleTestPage.selectEndTime();
		Log.info("Enter End Time");
		scheduleTestPage.clickSubmitButton();
		Log.info("Click submit button");
		Thread.sleep(3000);
		scheduleTestDetailPage=scheduleTestPage.clickMessage();
		Log.info("Click successfull schedule message");
		addStudentPage=scheduleTestDetailPage.clickAddStudent();
		Log.info("Click add student");
		Thread.sleep(3000);
		addStudentPage.clickExportAllData();
		Log.info("click Export All data button");
		Thread.sleep(3000);
	}
}
