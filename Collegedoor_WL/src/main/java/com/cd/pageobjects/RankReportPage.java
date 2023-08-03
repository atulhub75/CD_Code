package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class RankReportPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//h4[normalize-space()='Rank Report']")
	WebElement rankReoprtHeader;
	
	public RankReportPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayRankReoprtPage() {
		return method.isDisplayed(driver, rankReoprtHeader);
	}
}
