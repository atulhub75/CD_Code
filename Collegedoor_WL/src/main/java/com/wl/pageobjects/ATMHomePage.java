package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ATMHomePage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//a[normalize-space()='Create New Paper']")
	WebElement createPaperBtn;
	
	@FindBy(xpath="//input[@id='question_paper_desc']")
	WebElement QPDes;
	
	@FindBy(xpath="//select[@id='test_type_id']")
	WebElement examFilter;
	
	@FindBy(xpath="//select[@id='test_component_id']")
	WebElement syllabusFilter;
	
	@FindBy(xpath="//button[@class='btn btn-primary ml-2']")
	WebElement searchBtn;
	
	@FindBy(xpath="//a[normalize-space()='Reset']")
	WebElement resetBtn;
	
	public ATMHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrURL() {
		String AtmpageURL=method.getCurrentURL(driver);
		return AtmpageURL;
	}
	
	public AtmCreatePaperPage clickCreateNewPaper() {
		method.click(driver, createPaperBtn);
		return new AtmCreatePaperPage();
	}
}
