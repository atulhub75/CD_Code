package com.cd.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class TipsQpListPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//a[normalize-space()='Create Question Paper']")
	WebElement createQpBtn;
	
	@FindBy(xpath="//select[@id='exam_id']")
	WebElement examType;
	
	@FindBy(xpath="//select[@id='qp_creator']")
	WebElement createdBy;
	
	@FindBy(xpath="//input[@id='question_paper_code']")
	WebElement paperCode;
	
	@FindBy(xpath="//select[@id='custom_section']")
	WebElement customSection;
	
	@FindBy(xpath="//div[1]//div[1][@class='col-md-1']")
	WebElement firstCheckBox;
	
	@FindBy(xpath="//body[1]/div[5]/div[2]/div[2]/div[1]/div[9]/form[1]/button[1]")
	WebElement rankReport;
	
	@FindBy(xpath="//body[1]/div[5]/div[2]/div[2]/div[1]/div[10]/select[1]")
	WebElement displayRank;
	
	@FindBy(xpath="//body[1]/div[5]/div[2]/div[2]/div[1]/div[11]/select[1]")
	WebElement shaffleQuestion;
	
	@FindBy(xpath="//button[@onclick='listOpenQP()']")
	WebElement editButton;
	
	@FindBy(xpath="//button[contains(@class,'duplicate-btn custom-font12')]")
	WebElement copyButton;
	
	@FindBy(xpath="//button[contains(@class,'schedule-btn custom-font12')]")
	WebElement scheduleButton;
	
	@FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchBtton;
	
	@FindBy(xpath="//button[normalize-space()='Reset']")
	WebElement resetBtton;
	
	public TipsQpListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public TipsHomePage clickCreateQp() {
		method.click(driver, createQpBtn);
		return new TipsHomePage();
	}
	
	public String getCurrURLforTips() {
		String tipsQpListpageURL=method.getCurrentURL(driver);
		return tipsQpListpageURL;
	}
	
	public void clickExamType() {
		examType.click();	
	}
	
	public void clickCreatedBy() {
		createdBy.click();
	}
	
	public void clickCustomSection() {
		customSection.click();
	}
	
	public void searchValue() {
		method.sendKeys(paperCode, "OTMIGR154370_644121d962e9a");
		method.click(driver, searchBtton);
	}
	
	public void resetValue() throws InterruptedException {
		method.sendKeys(paperCode, "OTMIGR154370_644121d962e9a");
		Thread.sleep(2000);
		method.click(driver, resetBtton);
	}
	
	public void clickPaper() {
		method.click(driver, firstCheckBox);
	}
	
	public TipsHomePage clickEditButton() {
		method.click(driver, editButton);
		return new TipsHomePage();
	}
	
	public TipsHomePage clickCopyPaper() {
		method.click(driver, copyButton);
		return new TipsHomePage();
	}
	
	public ScheduleTestPage clickScheduleButton() {
		method.click(driver, scheduleButton);
		return new ScheduleTestPage();
	}
	
	public RankReportPage clickRankReport() {
		method.click(driver, rankReport);
		return new RankReportPage();
	}
}
