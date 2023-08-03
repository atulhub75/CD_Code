package com.cd.testcases;

import org.testng.annotations.BeforeMethod;

import com.cd.base.BaseClass;
import com.cd.pageobjects.HomePage;
import com.cd.pageobjects.IndexPage;
import com.cd.pageobjects.LoginPage;
import com.cd.pageobjects.ProceedAndSchedule;
import com.cd.pageobjects.SummaryOfAddedQuetion;
import com.cd.pageobjects.TipsHomePage;
import com.cd.pageobjects.TipsQuestionListPage;
import com.cd.pageobjects.TipsSelectQuestionPage;

public class TC_003_TIPS extends BaseClass{

	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private TipsQuestionListPage tipsquestionpaperList;
	private TipsHomePage tipshomePage;
	private TipsSelectQuestionPage tipsSelectQuestionPage;
	private SummaryOfAddedQuetion summaryOfAddedQuetion;
	private ProceedAndSchedule proceedAndSchedule;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	public void verifyScheduleQuestionPaper() throws InterruptedException {
		indexPage=new IndexPage();
		loginpage=indexPage.clickONLogin();
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
		tipsquestionpaperList=homepage.clickOnTips();
		Thread.sleep(3000);
		tipshomePage=tipsquestionpaperList.clickCreateQuestionPaper();
		Thread.sleep(8000);
		tipshomePage.addQuestionCode();
		Thread.sleep(3000);
		tipshomePage.SelectExam();
		Thread.sleep(5000);
		tipsSelectQuestionPage=tipshomePage.SelectRequiredField2();
		Thread.sleep(90000);
		tipsSelectQuestionPage.selectAllQuestion();
		Thread.sleep(10000);
		summaryOfAddedQuetion=tipsSelectQuestionPage.clickOnAddedQuestion();
		Thread.sleep(5000);
		proceedAndSchedule=summaryOfAddedQuetion.reviewQuetion();
		Thread.sleep(10000);
		proceedAndSchedule.clickProceedAndSchedule();
		Thread.sleep(3000);
		tipsquestionpaperList=proceedAndSchedule.finalizePaper();
	}
}
