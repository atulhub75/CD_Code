package com.cd.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cd.base.BaseClass;
import com.cd.pageobjects.HomePage;
import com.cd.pageobjects.IndexPage;
import com.cd.pageobjects.LoginPage;
import com.cd.utility.XLUtility;



public class LoginDDT extends BaseClass{
	
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
	public void loginTest(String uname, String psw) throws InterruptedException {
		indexPage=new IndexPage();
		loginpage=indexPage.clickONLogin();
		homepage=loginpage.login(uname,psw);
		String actualURL=homepage.getCurrURL();
		String expectedURL="https://ssluat.collegedoors.com/pages/cdmypage.php";
		Assert.assertEquals(actualURL, expectedURL);
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		
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
