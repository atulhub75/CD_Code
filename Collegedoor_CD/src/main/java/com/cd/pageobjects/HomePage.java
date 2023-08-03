package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class HomePage extends BaseClass {
	Methods method=new Methods();
	
	@FindBy(xpath="//a[@class='w-nav-brand cd-logo']")
	WebElement homepageLogo;
	
	@FindBy(xpath="//span[normalize-space()='My Actions']")
	WebElement myActionbtn;
	
	@FindBy(xpath="//a[@href='../pages/cdmanualpaperlist.php']")
	WebElement tipsbtn;
	
	@FindBy(xpath="//span[normalize-space()='My Reports']")
	WebElement myReports;
	
	@FindBy(xpath="//a[normalize-space()='Test Level Report']")
	WebElement testLevelReports;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateHomePageLogo() {
		return method.isDisplayed(driver, homepageLogo);
	}

	public String getCurrURL() {
		String homepageURL=method.getCurrentURL(driver);
		return homepageURL;
	}
	
	public TipsQuestionListPage clickOnTips() {
	
		method.click(driver, myActionbtn);
	    method.click(driver, tipsbtn);
		return new TipsQuestionListPage();
	}
	
	public TestLevelReportPage clickTestLevelReport() {
		method.fluentWait(driver, myReports, 5);
		method.mouseHoverByJavaScript(myReports);
		method.fluentWait(driver, testLevelReports, 5);
		method.JSClick(driver, testLevelReports);
		return new TestLevelReportPage();
	}
}
