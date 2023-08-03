package com.cd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class TakeTestPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//a[@href='#'][normalize-space()='Take Test']")
	WebElement takeTestBtn;
	
	
	@FindBy(xpath="//button[@id='btn-ready']")
	WebElement readyBtn;
	
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/div[2]/div[4]/div[4]/table[1]/tr[1]/td[1]/div[1]/label[1]/input[1]")
	WebElement selectAns;
	
	@FindBy(xpath="//button[@id='btn-save-next']")
	WebElement saveNextBtn;
	
	@FindBy(xpath="//button[@id='btn-submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//button[normalize-space()='Yes, I am done.']")
	WebElement submitAlertBtn;
	
	public TakeTestPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickTakeTestBtn() {
		method.click(driver, takeTestBtn);
	}
	//div[@class='modal-body resume-body']//iframe
	
	public void switchInFrmeOfTakeTest() {
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='modal-body resume-body']//iframe")));
		method.fluentWait(driver, readyBtn, 5);
		method.click(driver, readyBtn);
		
	}
	
	public void clickAnswerAndSubmit() {
		method.click(driver, selectAns);
		method.click(driver, saveNextBtn);
		method.fluentWait(driver, submitBtn, 5);
		method.click(driver, submitBtn);
	}
	
	public AnalysisReportPage clickSubmitAlert() {
		method.click(driver, submitAlertBtn);
		driver.switchTo().defaultContent();
		return new AnalysisReportPage();
	}
}
