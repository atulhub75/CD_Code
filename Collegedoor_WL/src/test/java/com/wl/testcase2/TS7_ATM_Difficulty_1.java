package com.wl.testcase2;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.ATMHomePage;
import com.wl.pageobjects.AtmCreatePaperPage;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;

public class TS7_ATM_Difficulty_1 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ATMHomePage aTMHomePage;
	private AtmCreatePaperPage atmCreatePaperPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyATMFunctionality() throws Throwable {
		Log.startTestCase("Test for paper Exam with full syllabus , Difficulty=easy and exam Jee Main");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		homepage=loginpage.verifyLogin(prop.getProperty("email"),prop.getProperty("password"));
		Log.info("Enter userName and password and Login successfull");
		Thread.sleep(2000);
		aTMHomePage=homepage.clickATM();
		Log.info("click ATM Utility");
		atmCreatePaperPage=aTMHomePage.clickCreateNewPaper();
		Log.info("click paper generation button");
		atmCreatePaperPage.paperDescription("AtulTest");
		Log.info("Enter paper discription");
		atmCreatePaperPage.selectExam("JEE Main");
		Log.info("exam selected");
		Thread.sleep(2000);
		atmCreatePaperPage.selectSyllabus("Full Syllabus");
		Log.info("select full syllabus");
		atmCreatePaperPage.selectDifficulty("Easy");
		Log.info("Enter dificulty");
		atmCreatePaperPage.TestDuration();
		Log.info("Enter test duration");
		Thread.sleep(2000);
		atmCreatePaperPage.clickGenerateBtn();
		Log.info("click generate button");
		Thread.sleep(5000);
		atmCreatePaperPage.clickPopUpYesBtn();
		Log.info("click popup button");
		Thread.sleep(8000);
		boolean result=atmCreatePaperPage.validatePaperCreatedMessage();
		Assert.assertTrue(result);
		Log.endTestCase("TS7_ATM_Difficulty_1");
	}
}
