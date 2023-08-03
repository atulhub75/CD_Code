package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class TipsSelectQuestionPage extends BaseClass {
  Methods method=new Methods();
	
	@FindBy(id="check_all")
	WebElement selectQuetion;
	
	@FindBy(xpath="//button[@id='openNav']")
	WebElement addedQuestionbtn;
	
	
	public TipsSelectQuestionPage() {
		PageFactory.initElements(driver, this);
	}
	
	public TipsSelectQuestionPage selectAllQuestion() {
		method.fluentWait(driver, selectQuetion, 5);
		method.click(driver, selectQuetion);
		//method.JSClick(driver, selectQuetion);
		return new TipsSelectQuestionPage();
	}
	
	public SummaryOfAddedQuetion clickOnAddedQuestion() {
		
		method.fluentWait(driver, addedQuestionbtn, 40);
		method.JSClick(driver, addedQuestionbtn);
		return new SummaryOfAddedQuetion();
		
	}
}
