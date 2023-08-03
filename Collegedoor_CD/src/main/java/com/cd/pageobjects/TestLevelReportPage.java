package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class TestLevelReportPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//tbody/tr[1]/td[8]/button[1]")
	WebElement viewRR;
	
	@FindBy(xpath="//div[@class='cd-mr-ln-analysis']")
	WebElement QuestionRR;
	
	public TestLevelReportPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickAnalysisReport() {
		method.fluentWait(driver, viewRR, 5);
		method.JSClick(driver, viewRR);
		
		}
	
	public void QuestionLevelAnalysis() {
		method.fluentWait(driver, QuestionRR, 10);
		method.JSClick(driver, QuestionRR);
	}
}
