package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ScheduleTestListPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//h4[normalize-space()='Scheduled Test List']")
	WebElement heading;
	
	public ScheduleTestListPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, heading);
	}
}
