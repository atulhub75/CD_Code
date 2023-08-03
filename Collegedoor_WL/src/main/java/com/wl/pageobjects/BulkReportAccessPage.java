package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class BulkReportAccessPage extends BaseClass{
	Methods method=new Methods();
	

	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//i[@class='fa fa-download']")
	WebElement downloadFileBtn;
	
	@FindBy(xpath="//input[@id='csv']")
	WebElement uploadCsv;
	
	@FindBy(xpath="//h4[@id='set_captcha']")
	WebElement captcha;
	
	String filePath="C:\\TestData\\report_access_wl.csv";
	String filePath2="C:\\TestData\\testDoc.pdf";

	@FindBy(xpath="//a[@class='btn btn-danger captch_Reload']")
	WebElement Recaptcha;
	
	@FindBy(xpath="//input[@id='input_chaptch']")
	WebElement captchaField;
	
	@FindBy(xpath="//button[@id='adm-up-upload']")
	WebElement uploadBtn;
	
	@FindBy(xpath="//a[normalize-space()='Refresh']")
	WebElement refreshBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement wrongFileMsg;
	
	public BulkReportAccessPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ReportAccessHomePage clickBackBtn() {
		method.click(driver, backBtn);
		return new ReportAccessHomePage();
	}
	
	public void verifyFileUpload() {
		method.fluentWait(driver, uploadCsv, 5);
		method.sendKeys(uploadCsv, filePath2);
	}
	
	public void upoadFile() {
		method.fluentWait(driver, uploadCsv, 5);
		method.sendKeys(uploadCsv, filePath);
	}
	public BulkReportAccessSheetPage setCaptcha() {
		String cap=captcha.getText();
		method.sendKeys(captchaField, cap);
		method.click(driver, uploadBtn);
		return new BulkReportAccessSheetPage();
	}
	
	public void setCaptcha2() {
		String cap=captcha.getText();
		method.sendKeys(captchaField, cap);
		method.click(driver, refreshBtn);
	}
	
	public boolean validateWrongFileMessage() throws Throwable {
		 return method.isDisplayed(driver, wrongFileMsg);
	}
	
	public String firstCaptcha() {
		String newcapt=captcha.getText();
		return newcapt;
	}
	
	public String secondCaptcha() {
		Recaptcha.click();
		String oldcap=captcha.getText();
		return oldcap;
	}
	
	public void clickDownloadFile() {
		method.click(driver, downloadFileBtn);
	}
}
