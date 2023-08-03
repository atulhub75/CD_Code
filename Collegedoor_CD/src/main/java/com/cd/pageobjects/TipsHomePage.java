package com.cd.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.actionmethod.Methods;
import com.cd.base.BaseClass;

public class TipsHomePage extends BaseClass {
	Methods method=new Methods();
	
	@FindBy(xpath="//input[@id='question_paper_code']")
	WebElement qpCode;
	
	@FindBy(xpath="//input[@id='question_paper_desc']")
	WebElement qpDesc;
	
	@FindBy(xpath="//span[@id='select2-test_type_id-container']")
	WebElement examdropdn;
	String xpath="//span[@id='select2-test_type_id-container']";
	
	@FindBy(xpath="//ul//li[@aria-selected='false' and @aria-selected]")
	WebElement exams;
	
	String xpath1="//ul//li[@aria-selected='false' and @aria-selected]";
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[1]")
	WebElement subjectCheckbox;
	
	String subCheckboxPath="(//ul[@class='select2-selection__rendered'])[1]";
	
	//@FindBy(xpath="//ul//li[contains(@class,'select2-results__option')]")
	//WebElement selectSubject;
	
	String subjectPath="//ul//li[contains(@class,'select2-results__option')]";
	
	@FindBy(xpath="//input[@value='difficulty_easy']")
	WebElement easyDifficulty;
	
	@FindBy(xpath="//span[@id='select2-question_obj_pattern_id-container']")
	WebElement questionPatterndpdn;
	String quePatternDpdn="//span[@id='select2-question_obj_pattern_id-container']";
	
	@FindBy(xpath="//ul//li[contains(@role,'treeitem')]")
	WebElement queType;
	String quePatType="//ul//li[contains(@role,'treeitem')]";
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement useQuestionYes;
	
	@FindBy(xpath="//span[@id='select2-test_type_id-container']")
	WebElement selectExam;
	
	@FindBy(xpath="(//input[@role='textbox'])[6]")
	WebElement examSearchBox;
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[1]")
	WebElement selectSubject;
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[5]")
	WebElement selectDifficulty;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement SearchedValue;
	
	@FindBy(xpath="//input[@value='10']")
	WebElement noOfQue10;
	
	@FindBy(xpath="//button[@id='button-search']")
	WebElement searchBtn;
	
	public TipsHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTipsTitle() {
		//String myTitel=driver.getTitle();
		String myTitel=method.getTitle(driver);
		return myTitel;
	}
	
	public TipsHomePage addQuestionCode() {
		method.fluentWait(driver, qpCode, 5);
		method.sendKeys(qpCode, method.randomestring());
		method.sendKeys(qpDesc, method.randomestring());
		return new TipsHomePage();
	}
	
	public TipsHomePage SelectExam() {
		
		method.fluentWait(driver, examdropdn, 10);
		method.fluentWait(driver, exams, 15);
		method.selectValueFromDropdown(xpath, xpath1, "NEET");
		
		//method.newmethod(driver, 15, xpath, xpath1, "JEE Main");
		return new TipsHomePage();
		
	}
	
	
	public void selectExam1(String exam) throws InterruptedException {
		method.click(driver, selectExam);
		Thread.sleep(3000);
		method.sendKeys(examSearchBox, exam);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectSubject(String sub) throws InterruptedException {
		method.click(driver, selectSubject);
		Thread.sleep(2000);
		method.sendKeys(selectSubject, sub);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectchap(String su) throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'"+su+"')]")).click();
		
	}
	
	public void selectSubje() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Chemistry')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Mathematics')]")).click();
		
	}
	
	public void selectDifficulty1() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		List<WebElement>option=driver.findElements(By.xpath("//li[@class='select2-results__option']"));
		System.out.println(option.size());
		
		for(int i=0; i<option.size(); i++) {
			option.get(i).getText();
		  if(option.get(i).getText().equals("Chemistry") || option.get(i).getText().equals("Mathematics")) {
			  option.get(i).click();
			  break;
		  }
			
		}
	}
	
	public void selectDifficulty(String diffi) throws InterruptedException {
		method.click(driver, selectDifficulty);
		Thread.sleep(2000);
		method.sendKeys(selectDifficulty, diffi);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public TipsSelectQuestionPage SelectRequiredField2() {
		method.fluentWait(driver, subjectCheckbox, 10);
		method.scrollByVisibilityOfElement(driver, subjectCheckbox);
		method.fluentWait(driver, selectSubject, 10);
		method.selectValueFromDropdown(subCheckboxPath, subjectPath, "Physics");
		method.click(driver, easyDifficulty);
		method.fluentWait(driver, questionPatterndpdn, 5);
		method.scrollByVisibilityOfElement(driver, questionPatterndpdn);
		method.fluentWait(driver, queType, 5);
		method.selectValueFromDropdown(quePatternDpdn, quePatType, "MCSC00_SC00 - Multiple choice question, Single correct out of 4 options");
		method.click(driver, useQuestionYes);
		method.click(driver, noOfQue10);
        method.scrollByVisibilityOfElement(driver, searchBtn);
        method.fluentWait(driver, searchBtn, 5);
        method.JSClick(driver, searchBtn);
        return new TipsSelectQuestionPage();
	}
		
	

}
