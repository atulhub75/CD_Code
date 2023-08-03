package com.wl.testcase2;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.pageobjects.AddStudentPage;
import com.cd.pageobjects.CDHomePage;
import com.cd.pageobjects.ScheduleTestDetailPage;
import com.cd.pageobjects.ScheduleTestListPage;
import com.cd.pageobjects.ScheduleTestPage;
import com.cd.pageobjects.TakeTestPage;
import com.cd.pageobjects.TipsHomePage;
import com.cd.pageobjects.TipsQpListPage;
import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;

public class Tips_schedule extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private CDHomePage cdHomePage;
	private TipsQpListPage tipsQpListPage;
	private ScheduleTestPage scheduleTestPage;
	private ScheduleTestDetailPage scheduleTestDetailPage;
	private AddStudentPage addStudentPage;
	private ScheduleTestListPage scheduleTestListPage;
	private TakeTestPage takeTestPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	/*@AfterMethod
	public void TearDown() {
		driver.quit();
	}*/
	
	@Test(priority=1)
	public void verifyTipsFunction() throws Exception {
		Log.startTestCase("Test for select Exam and schedule");
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
		scheduleTestPage=tipsQpListPage.clickScheduleButton();
		scheduleTestPage.enterTestName();
		scheduleTestPage.selectCurrentDate();
		scheduleTestPage.selectCurrentTime();
		scheduleTestPage.selectEndDate();
		scheduleTestPage.selectEndTime();
		scheduleTestPage.clickSubmitButton();
		Thread.sleep(3000);
		scheduleTestDetailPage=scheduleTestPage.clickMessage();
		addStudentPage=scheduleTestDetailPage.clickAddStudent();
		addStudentPage.selectStudent();
		addStudentPage.clickSelectedStudent();
		Thread.sleep(3000);
		addStudentPage.clickYesNoPopup();
		
	}
	//(priority=2, dependsOnMethods= {"verifyTipsFunction"})
	@Test(priority=2, dependsOnMethods= {"verifyTipsFunction"})
	public void takeTestMethod() throws InterruptedException 
	{
		Log.startTestCase("Test for select Exam and schedule");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		homepage=loginpage.verifyLogin("ovent.01", "abc123");
		
		Thread.sleep(2000);
		takeTestPage=homepage.clickTakeTest();
		takeTestPage.clickTakeTestBtn();
		Thread.sleep(4000);
		takeTestPage.switchInFrmeOfTakeTest();
		Thread.sleep(4000);
		takeTestPage.clickAnswerAndSubmit();
		Thread.sleep(2000);
		takeTestPage.clickSubmitAlert();
		
	}
}
