package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class ProceedAndSchedule extends BaseClass {
	Methods methods=new Methods();
	
	@FindBy(xpath="//button[contains(@class,'btn btn-success btn-space waves-effect waves-light schedule-exam')]")
	WebElement proceedAndSchedulebtn;
	
	@FindBy(xpath="//button[contains(normalize-space(),'Ok')]")
	WebElement finalisePaperbtn;
	
	public ProceedAndSchedule() {
		PageFactory.initElements(driver, this);
	}

	public ProceedAndSchedule clickProceedAndSchedule() {
		methods.click(driver, proceedAndSchedulebtn);
		return new ProceedAndSchedule();
	}
	
	public TipsQuestionListPage finalizePaper() {
		methods.fluentWait(driver, finalisePaperbtn, 10);
		methods.click(driver, finalisePaperbtn);
		return new TipsQuestionListPage();
	}
}
