package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class BulkNewPasswordPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backbtn;
	
	@FindBy(xpath="//i[@class='fa fa-download']")
	WebElement downloadFile;
	
	@FindBy(xpath="//input[@id='csv']")
	WebElement uploadFile;
	
	String filePath="C:\\TestData\\bulk_password_wl.csv";
	String filePath2="C:\\TestData\\testDoc.pdf";
	
	@FindBy(xpath="//h3[@id='set_captcha']")
	WebElement captcha;
	
	@FindBy(xpath="//i[@class='fa fa-undo']")
	WebElement Recaptcha;
	
	@FindBy(xpath="//input[@id='input_chaptch']")
	WebElement captchaField;
	
	@FindBy(xpath="//button[@id='adm-up-upload']")
	WebElement uploadBtn;
	
	@FindBy(xpath="//a[normalize-space()='Refresh']")
	WebElement refreshBtn;
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	WebElement wrongFileMsg;
	
	public BulkNewPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyUploadFunction() {
		method.fluentWait(driver, uploadFile, 3);
		method.sendKeys(uploadFile, filePath);	
	}
	
	public void verifyUploadFunction2() {
		method.fluentWait(driver, uploadFile, 3);
		method.sendKeys(uploadFile, filePath2);	
	}
	
	public BulkPasswordSheetPage verifyCaptcha() {
		String capValue=captcha.getText();
		method.sendKeys(captchaField, capValue);
		method.click(driver, uploadBtn);
		return new BulkPasswordSheetPage();
	}
	
	public void verifyCaptcha1() {
		String capValue=captcha.getText();
		method.sendKeys(captchaField, capValue);
		method.click(driver, uploadBtn);		
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
		method.click(driver, downloadFile);
	}
	
	public UserListHomePage clickBackButton() {
		method.click(driver, backbtn);
		return new UserListHomePage();
	}
	
	public void clickRefreshButton() {
		String capValue=captcha.getText();
		method.sendKeys(captchaField, capValue);
		method.click(driver, refreshBtn);
	}
	
	public String getCurrURLforBackBtn() {
		String bulkPasswordpageURL=method.getCurrentURL(driver);
		return bulkPasswordpageURL;
	}
}
