package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class CDHomePage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//span[normalize-space()='My Actions']")
	WebElement actionBtn;
	
	@FindBy(xpath="//a[@href='cdmanualpaperlist.php']")
	WebElement tipsBtn;
	
	public CDHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public TipsQpListPage clickTips() {
		method.click(driver, actionBtn);
		method.click(driver, tipsBtn);
		return new TipsQpListPage();
	}
}
