package com.cd.pageobjects;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class ScheduleTestPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//h4[normalize-space()='Scheduled Test Edit / Add']")
	WebElement scheduleTestHome;
	
	@FindBy(xpath="//input[@name='schedule_test_name']")
	WebElement testName;
	
	@FindBy(xpath="//input[@name='cd-schdl-dt-start']")
	WebElement startDate;
	
	@FindBy(xpath="//input[@id='timepicker1']")
	WebElement startTime;
	
	@FindBy(xpath="//label[normalize-space()='Hold Result']")
	WebElement clickExternal;
	
	@FindBy(xpath="//input[@name='cd-schdl-dt-end']")
	WebElement endDate;
	
	@FindBy(xpath="//button[@id='submit-schedule']")
	WebElement submitBtn;
	
	@FindBy(xpath="//button[@id='_pa_msg_btn0']")
	WebElement successMsg;
	
	public ScheduleTestPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplaySchedulePage() {
		return method.isDisplayed(driver, scheduleTestHome);
	}
	
	public void enterTestName() {
		method.sendKeys(testName, method.randomestring());
	}
	
	public void selectCurrentDate() {
		LocalDate localdate=LocalDate.now();
		String curDate=localdate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+curDate+"')", startDate);
		
	}
	
	
	public void selectCurrentTime() throws InterruptedException {
		LocalTime currentTime=LocalTime.now();
		LocalTime newTime=currentTime.plusMinutes(1);
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime=newTime.format(formatter);
		WebElement time=driver.findElement(By.id("timepicker1"));
		time.click();
		time.clear();
		Thread.sleep(2000);
		time.sendKeys(formattedTime);
		clickExternal.click();
	}
	
	public void selectEndDate() {
		LocalDate localdate=LocalDate.now();
		String curDate=localdate.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
		//LocalDateTime ldt=LocalDateTime.now();
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+curDate+"')", endDate);
	}
	
	public void selectEndTime() throws InterruptedException {
		LocalTime currentTime=LocalTime.now();
		LocalTime newTime=currentTime.plusHours(2);
		DateTimeFormatter formatter= DateTimeFormatter.ofPattern("hh:mm a");
		String formattedTime=newTime.format(formatter);
		WebElement time=driver.findElement(By.id("timepicker2"));
		time.click();
		time.clear();
		Thread.sleep(2000);
		time.sendKeys(formattedTime);
		clickExternal.click();
	}
	
	public void clickSubmitButton() {
		method.click(driver, submitBtn);
	}
	
	public ScheduleTestDetailPage clickMessage() {
		method.click(driver, successMsg);
		return new ScheduleTestDetailPage();
	}
}
