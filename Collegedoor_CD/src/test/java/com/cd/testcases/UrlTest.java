package com.cd.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.base.BaseClass;
import com.cd.pageobjects.IndexPage;

public class UrlTest extends BaseClass {
	private IndexPage indexPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogo() {
		indexPage=new IndexPage();
		boolean actualLogo=indexPage.validateIndexLogo();
		Assert.assertTrue(actualLogo);
	}
	
	@Test
	public void verifyTitle() {
		indexPage=new IndexPage();
		String actualTitle=indexPage.getCdTitle();
		Assert.assertEquals(actualTitle, "CollegeDoors: Online practice platform for JEE Mains | BITSAT | NEET | MHCET");
	}
}
