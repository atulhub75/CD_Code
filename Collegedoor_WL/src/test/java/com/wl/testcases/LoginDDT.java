package com.wl.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.HomePage;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.utility.Log;
import com.wl.utility.XLUtility;


public class LoginDDT extends BaseClass {
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
	
	@Test(dataProvider="LoginData")
	public void verifyLoginFunction(String uid,String psd,String exp) throws Throwable {
		try {
			Log.info("Start test Case");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		homepage=loginpage.verifyLogin(uid, psd);
		Log.info("Enter user Name and password");
		boolean targetpage=homepage.validateMessage();
		Thread.sleep(2000);
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				//homepage.logoutMethod();
				Assert.assertTrue(true);
			}
			else
			{
				
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invalid"))
		{
			if(targetpage==true)
			{
				homepage.logoutMethod();
				Assert.assertTrue(false);
			}
			else
			{		
				
				Assert.assertTrue(true);
			}
		}
		Log.info("Finished Login Test");
		
	}catch(Exception e)
	{
		
		Assert.fail();
	}
			
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\WL_User.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)  
		{		
			for(int j=0;j<totalcols;j++)
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  
			}
		}
	return logindata;
				
	}
}
