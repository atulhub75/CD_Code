package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class AnalysisReportPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//div[@class='cd-mr-ln-analysis']")
	WebElement pageLogo;
	
	public AnalysisReportPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo() throws Throwable {
		 return method.isDisplayed(driver, pageLogo);
	}
	
}

