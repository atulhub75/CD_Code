package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class TestLevelReportPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//p[normalize-space()='Whitelabel']")
	WebElement whiteLableUtility;
	
	public TestLevelReportPage() {
		PageFactory.initElements(driver, this);
	}
}
