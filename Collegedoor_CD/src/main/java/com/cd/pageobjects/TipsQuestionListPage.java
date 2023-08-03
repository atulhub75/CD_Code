package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class TipsQuestionListPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//a[normalize-space()='Create Question Paper']")
	WebElement createquetionPaperbtn;
	
	@FindBy(xpath="//input[@name='qpcheck-53292']")
	WebElement selectPaper;
	
	@FindBy(xpath="//button[@onclick='listScheduleQP()']")
	WebElement schedulebtn;
	
	@FindBy(xpath="//button[contains(@class,'schedule-btn custom-font12')]")
	WebElement scheduleButton;
	
	@FindBy(xpath="//div[1]//div[1][@class='col-md-1']")
	WebElement firstCheckBox;
	
	public TipsQuestionListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public TipsHomePage clickCreateQuestionPaper() {
		//method.fluentWait(driver, createquetionPaperbtn, 10);
		method.click(driver, createquetionPaperbtn);
		//method.JSClick(driver, createquetionPaperbtn);
		
		return new TipsHomePage();
	}
	
	public String getPageTitle() {
		
		String myTitel=method.getTitle(driver);
		return myTitel;
	}
	
	public ScheduleTestPage clickScheduleExam() {
		method.fluentWait(driver, selectPaper, 10);
		method.click(driver, selectPaper);
		method.click(driver, createquetionPaperbtn);
		return new ScheduleTestPage();
	}
	

	public void clickPaper() {
		method.click(driver, firstCheckBox);
	}
	
	public ScheduleTestPage clickScheduleButton() {
		method.click(driver, scheduleButton);
		return new ScheduleTestPage();
	}
	
}
