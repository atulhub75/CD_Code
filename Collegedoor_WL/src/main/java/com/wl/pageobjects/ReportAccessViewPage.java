package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ReportAccessViewPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//tbody/tr[2]/td")
	WebElement user;
	
	public ReportAccessViewPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isPresent() {
		return method.isDisplayed(driver, user);
	}
}
