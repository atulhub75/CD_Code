package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class SummaryOfAddedQuetion extends BaseClass{
	Methods methods=new Methods();
	
	@FindBy(xpath="//input[@id='duration_test']")
	WebElement paperTime;
	
	@FindBy(xpath="//button[@id='0']")
	WebElement reviewQuetion;
	
	public SummaryOfAddedQuetion() {
		PageFactory.initElements(driver, this);
	}
	
	
	public ProceedAndSchedule reviewQuetion() {
		methods.sendKeys(paperTime, "20");
		methods.fluentWait(driver, reviewQuetion, 10);
		methods.scrollByVisibilityOfElement(driver, reviewQuetion);
		methods.JSClick(driver, reviewQuetion);
		return new ProceedAndSchedule();
	}

}
