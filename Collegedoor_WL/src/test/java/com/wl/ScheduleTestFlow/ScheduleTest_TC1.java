package com.wl.ScheduleTestFlow;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.pageobjects.AddStudentPage;
import com.cd.pageobjects.AnalysisReportPage;
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

public class ScheduleTest_TC1 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private CDHomePage cdHomePage;
	private TipsQpListPage tipsQpListPage;
	private TipsHomePage tipsHomePage;
	private ScheduleTestPage scheduleTestPage;
	private ScheduleTestDetailPage scheduleTestDetailPage;
	private AddStudentPage addStudentPage;
	private ScheduleTestListPage scheduleTestListPage;
	private TakeTestPage takeTestPage;
	private AnalysisReportPage analysisReportPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyTipsFunction() throws Exception {
		try {
			Log.startTestCase("Test for select Exam JEE Main, create question paper");
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
			tipsHomePage.selectExam("JEE Advanced");
			Log.info("select Exam");
			Thread.sleep(2000);
			tipsHomePage.selectSubject("Physics");
			Log.info("select subject");
			Thread.sleep(2000);
			tipsHomePage.SelectAllDifficulty();
			Log.info("select difficulty");
			Thread.sleep(2000);
			tipsHomePage.includeUsedQuestionYes();
			Log.info("select include used question yes");
			tipsHomePage.SelectQuestion("10");
			Log.info("select number of question");
			tipsHomePage.clickSearchButton();
			Log.info("click search button");
			Thread.sleep(30000);
			tipsHomePage.selectAllQuestion();
			Thread.sleep(2000);
			tipsHomePage.clickSummaryOfQuestion();
			Thread.sleep(2000);
			tipsHomePage.enterQPDescriptionTime();
			Thread.sleep(3000);
			tipsHomePage.clickProceedAndSchedule();
			Thread.sleep(2000);
			tipsQpListPage=tipsHomePage.clickFinalize();
			String actual=tipsQpListPage.getCurrURLforTips();
			String expected="https://uattests.collegedoors.com/pages/cdmanualpaperlist.php";
			Assert.assertEquals(actual, expected);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void verifySchedulePaperFunctionality() throws Throwable {
		try {
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
			scheduleTestListPage=addStudentPage.clickYesNoPopup();
			boolean result=scheduleTestListPage.validateMessage();
			Assert.assertTrue(result);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//(priority=2, dependsOnMethods= {"verifyTipsFunction"})
	@Test(priority=3, dependsOnMethods= {"verifySchedulePaperFunctionality"})
	public void takeTestMethod() throws Throwable 
	{
		try {
			Log.startTestCase("Test for select Exam and schedule");
			IndexPage indexPage=new IndexPage();
			loginpage=indexPage.clickLogin();
			Log.info("click Login button");
			homepage=loginpage.verifyLogin("test.am5", "abc123");
			
			Thread.sleep(2000);
			takeTestPage=homepage.clickTakeTest();
			Thread.sleep(35000);
			takeTestPage.clickTakeTestBtn();
			Thread.sleep(6000);
			takeTestPage.switchInFrmeOfTakeTest();
			Thread.sleep(6000);
			takeTestPage.clickAnswerAndSubmit();
			Thread.sleep(2000);
			analysisReportPage=takeTestPage.clickSubmitAlert();
			Thread.sleep(2000);
			boolean result=analysisReportPage.validateLogo();
			Assert.assertTrue(result);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
