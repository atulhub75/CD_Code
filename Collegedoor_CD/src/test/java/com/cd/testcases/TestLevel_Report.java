package com.cd.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.base.BaseClass;
import com.cd.pageobjects.HomePage;
import com.cd.pageobjects.IndexPage;
import com.cd.pageobjects.LoginPage;
import com.cd.pageobjects.TestLevelReportPage;

public class TestLevel_Report extends BaseClass {
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	private TestLevelReportPage testLevelReportPage;
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	/*@AfterMethod
	public void TearDown() {
		driver.quit();
	}*/
	
	@Test
	public void ValidateTestLevelReport() throws InterruptedException  {
		indexPage=new IndexPage();
		loginpage=indexPage.clickONLogin();
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
		testLevelReportPage=homepage.clickTestLevelReport();
		Thread.sleep(3000);
		testLevelReportPage.clickAnalysisReport();
		testLevelReportPage.QuestionLevelAnalysis();
	}
}
