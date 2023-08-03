package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;



public class BulkUserUploadPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='csv']")
	WebElement uploadFile;
	
	@FindBy(xpath="//button[@id='adm-up-upload']")
	WebElement uploadBtn;
	
	String filePath="C:\\TestData\\student_upload_wl.csv";
	String filePath2="C:\\TestData\\testDoc.pdf";
	
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement wrongFileMsg;
	
	@FindBy(xpath="//a[normalize-space()='Refresh']")
	WebElement refreshBtn;
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//i[@class='fa fa-download']")
	WebElement downloadFile;
	
	@FindBy(xpath="//h3[@id='set_captcha']")
	WebElement captcha;
	
	@FindBy(xpath="//i[@class='fa fa-undo']")
	WebElement Recaptcha;
	
	
	@FindBy(xpath="//input[@id='input_chaptch']")
	WebElement captchaField;
	
	public BulkUserUploadPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyBulkUpload() {
		method.fluentWait(driver, uploadFile, 5);
		method.sendKeys(uploadFile, filePath);
	
	}
	public void checkFileUpload() {
		method.fluentWait(driver, uploadFile, 5);
		method.sendKeys(uploadFile, filePath2);
	}

	public BulkUploadSheetPage enterCaptchaValue() {
		String cpt=captcha.getText();
		System.out.println("captcha is"+cpt);
		method.sendKeys(captchaField, cpt);
		method.click(driver, uploadBtn);
		return new BulkUploadSheetPage();
		
	}
	
	public void enterCaptchaValue1() {
		String cpt=captcha.getText();
		System.out.println("captcha is"+cpt);
		method.sendKeys(captchaField, cpt);
		method.click(driver, uploadBtn);
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
		method.click(driver, downloadFile);
	}
	
	public UserListHomePage clicBackButton() {
		method.click(driver, backBtn);
		return new UserListHomePage();
	}
	
	public void clicRefreshButton() {
		method.click(driver, refreshBtn);
	}
	
	public boolean validateWrongFileMessage() throws Throwable {
		 return method.isDisplayed(driver, wrongFileMsg);
	}
}
