package com.wl.testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wl.base.BaseClass;
import com.wl.pageobjects.IndexPage;
import com.wl.pageobjects.LoginPage;
import com.wl.pageobjects.ResetPasswordPage;
import com.wl.utility.Log;
import com.wl.utility.XLUtility;

public class ResetPasswordDDT extends BaseClass{
	private IndexPage indexPage;
	private LoginPage loginpage;
	private ResetPasswordPage resetPasswordPage;
	
	@BeforeMethod
	public void LaunchApp() {
		setup();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test(dataProvider="ResetPassword")
	public void verifyResetPasswordFunction(String uid,String email,String exp) throws Throwable {
		try {
			Log.info("Start ResetPassword testCase");
		IndexPage indexPage=new IndexPage();
		loginpage=indexPage.clickLogin();
		Log.info("click Login button");
		resetPasswordPage=loginpage.clickResetButton();
		Log.info("click Reset password button");
		resetPasswordPage.verifyResetPassword(uid, email);
		Log.info("Enter email id and password");
		boolean targetpage=resetPasswordPage.validateMessage();
		//Assert.assertTrue(result);

		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				
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
			
				Assert.assertTrue(false);
			}
			else
			{		
				
				Assert.assertTrue(true);
			}
		}
		Log.info("Finished Reset Password test");
		
	}catch(Exception e)
	{
		
		Assert.fail();
	}
			
	}
	
	
	
	@DataProvider(name="ResetPassword")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Reset_Password.xlsx";
		
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
