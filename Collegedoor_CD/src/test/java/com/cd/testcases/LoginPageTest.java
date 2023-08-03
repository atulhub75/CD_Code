package com.cd.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.base.BaseClass;
import com.cd.pageobjects.HomePage;
import com.cd.pageobjects.IndexPage;
import com.cd.pageobjects.LoginPage;


public class LoginPageTest extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private HomePage homepage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		indexPage=new IndexPage();
		loginpage=indexPage.clickONLogin();
		homepage=loginpage.login(prop.getProperty("email"),prop.getProperty("password"));
		String actualURL=homepage.getCurrURL();
		String expectedURL="https://ssluat.collegedoors.com/pages/cdmypage.php";
		Assert.assertEquals(actualURL, expectedURL);
		
	}

}
