package com.wl.atm.testcase;

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

public class TS3_ATM_JeeM_TC1 extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private ATMHomePage aTMHomePage;
	private AtmCreatePaperPage atmCreatePaperPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	/*@AfterMethod
	public void TearDown() {
		driver.quit();
	}*/
	
	@Test
	public void verifyATMFunctionality() throws Throwable {
		Log.startTestCase("Test for create paper for sub=chem, diff=easy,area=organi,topic=biomolecule");
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
		atmCreatePaperPage.paperDescription("atulTest");
		Log.info("Enter paper discription");
		atmCreatePaperPage.selectExam("JEE Main");
		Log.info("exam selected");
		Thread.sleep(2000);
		atmCreatePaperPage.selectDifficulty("Medium");
		Log.info("Enter dificulty");
		atmCreatePaperPage.TestDuration();
		Log.info("Enter test duration");
		atmCreatePaperPage.selectSubject("Chem");
		Log.info("subject selected");
		Thread.sleep(2000);
		atmCreatePaperPage.selectArea("Organic");
		Log.info("enter area");
		atmCreatePaperPage.selectChapter("Biomolecules");
		Log.info("enter chapter");
		Thread.sleep(2000);
		atmCreatePaperPage.clickAddBtn();
		Log.info("click add button");
		Thread.sleep(2000);
		atmCreatePaperPage.enterQuestionInBox1("1");
		Log.info("Enter question count");
		Thread.sleep(2000);
		atmCreatePaperPage.clickGenerateBtn();
		Log.info("click generate button");
		Thread.sleep(5000);
		atmCreatePaperPage.clickPopUpYesBtn();
		Log.info("click popup button");
		Thread.sleep(2000);
		boolean result=atmCreatePaperPage.validatePaperCreatedMessage();
		Assert.assertTrue(result);
		Log.endTestCase("TS3_ATM_JeeM_TC3");
	}
}
