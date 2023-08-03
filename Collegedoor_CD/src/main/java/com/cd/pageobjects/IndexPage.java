package com.cd.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class IndexPage extends BaseClass {
	
	Methods method=new Methods();
	
	@FindBy(xpath="//div[@class='col-xs-10 text-right menu-1 main-nav']//a[@class='external'][normalize-space()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//div[@id='gtco-logo']//a[@href='index.php']//img")
	WebElement indexLogo;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public LoginPage clickONLogin() {
		method.click(driver, loginbtn);
		return new LoginPage();
		
	}
	
	public boolean validateIndexLogo() {
		return method.isDisplayed(driver, indexLogo);
	}
	
	public String getCdTitle() {
		String myTitel=driver.getTitle();
		return myTitel;
	}

}
