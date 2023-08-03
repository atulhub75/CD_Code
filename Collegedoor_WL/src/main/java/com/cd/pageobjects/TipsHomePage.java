package com.cd.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class TipsHomePage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//a[normalize-space()='Create Question Paper']")
	WebElement createQpBtn;
	
	@FindBy(xpath="//a[@class='w-nav-brand wl-logo']")
	WebElement logo;
	
	@FindBy(xpath="//img[@class='custom_image']")
	WebElement imageHome;
	
	@FindBy(xpath="//span[@id='select2-test_type_id-container']")
	WebElement selectExam;
	
	@FindBy(xpath="//button[@id='refresh']")
	WebElement refreshBtn;
	
	@FindBy(xpath="(//input[@role='textbox'])[7]")
	WebElement examSearchBox;
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[1]")
	WebElement selectSubject;
	
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[2]")
	WebElement selectSection;
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[3]")
	WebElement selectChapter;
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[4]")
	WebElement selectTopic;
	
	@FindBy(xpath="(//ul[@class='select2-selection__rendered'])[5]")
	WebElement selectDifficulty;
	
	@FindBy(xpath="(//span[@id='select2-question_obj_pattern_id-container'])[1]")
	WebElement quesPattern;
	
	@FindBy(xpath="(//input[@role='textbox'])[6]")
	WebElement quesPatternBox;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement SearchedValue;
	
	@FindBy(xpath="//input[@value='Yes']")
	WebElement usedQuestion;
	
	
	@FindBy(xpath="//input[@id='max_limit']")
	WebElement maxQuestion;
	
	@FindBy(xpath="//span[@class='max_limit_errors']")
	WebElement questionAlert;
	
	@FindBy(xpath="//span[@class='max_limit_error']")
	WebElement questionAlert2;
	
	@FindBy(xpath="//div[normalize-space()='1']")
	WebElement firstQuestion;
	
	@FindBy(xpath="//button[@id='button-search']")
	WebElement searchBtn;
	
	@FindBy(xpath="//input[@id='check_all']")
	WebElement selectAllCheckBox;
	
	@FindBy(xpath="//button[@id='openNav']")
	WebElement summaryQuestion;
	
	@FindBy(xpath="//input[@id='question_paper_desc']")
	WebElement QPDescription;
	
	@FindBy(xpath="//input[@id='duration_test']")
	WebElement examDuration;
	
	@FindBy(xpath="(//button[normalize-space()='Proceed to Review Questions'])[1]")
	WebElement reviewQuestion;
	
	@FindBy(xpath="//button[contains(@class,'btn btn-success btn-space waves-effect waves-light schedule-exam')]")
	WebElement proceedScheduleBtn;
	
	@FindBy(xpath="//button[normalize-space()='Ok']")
	WebElement finalizeBtn;
	
	@FindBy(xpath="//div[@id='modal_popup']//div[@class='modal-content']//div[1]")
	WebElement maxQuestionAlert;
	
	public TipsHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCurrURLforTips() {
		String tipspageURL=method.getCurrentURL(driver);
		return tipspageURL;
	}
	
	public void RefreshAlert() {
		boolean result=method.isDisplayed(driver, refreshBtn);
		if(result) {
			method.click(driver, refreshBtn);
			method.Alert(driver);
		}
	}
	
	public void selectExam(String exam) throws InterruptedException {
		method.click(driver, selectExam);
		Thread.sleep(3000);
		method.sendKeys(examSearchBox, exam);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectSubject(String sub) throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'"+sub+"')]")).click();
	}
	
	public void selectMultipleSubject() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Chemistry')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Mathematics')]")).click();
		
	}
	
	public void selectSection(String sec) throws InterruptedException {
		method.click(driver, selectSection);
		Thread.sleep(2000);
		method.sendKeys(selectSection, sec);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectChapter(String cha) throws InterruptedException {
		method.click(driver, selectChapter);
		Thread.sleep(2000);
		method.sendKeys(selectChapter, cha);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectTopic(String topic) throws InterruptedException {
		method.click(driver, selectTopic);
		Thread.sleep(2000);
		method.sendKeys(selectTopic, topic);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectDifficulty(String diffi) throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'"+diffi+"')]")).click();
	}
	
	public void selectEasyMedium() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Easy')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Medium')]")).click();
	}
	
	public void SelectEasyDifficulty() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Easy')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Difficult')]")).click();
	}
	
	public void SelectDifficultMedium() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Medium')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Difficult')]")).click();
	}
	
	public void SelectAllDifficulty() throws InterruptedException {
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Easy')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Medium')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//ul[@class='select2-selection__rendered'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[contains(.,'Difficult')]")).click();
	}
	
	public void selectQuestionPattern(String pat) throws InterruptedException {
		method.scrollByVisibilityOfElement(driver, quesPattern);
		method.click(driver, quesPattern);
		Thread.sleep(2000);
		method.sendKeys(quesPatternBox, pat);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void includeUsedQuestionYes() {
		method.scrollByVisibilityOfElement(driver, usedQuestion);
		method.click(driver, usedQuestion);
	}
	
	
	public void SelectQuestion(String que) {
		method.scrollByVisibilityOfElement(driver, maxQuestion);
		method.sendKeys(maxQuestion, que);
	}
	public void clickHomeIamage() {
		method.click(driver,imageHome );
	}
	
	public void clickSearchButton() {
		method.scrollByVisibilityOfElement(driver, searchBtn);
		method.click(driver, searchBtn);
	}
	
	public void selectAllQuestion() {
		method.click(driver, selectAllCheckBox);
	}
	
	public void clickSummaryOfQuestion() {
		method.click(driver, summaryQuestion);
	}
	
	public void enterQPDescriptionTime() {
		method.sendKeys(QPDescription, method.randomestring());
		method.sendKeys(examDuration, "60");
		method.click(driver, reviewQuestion);
	}
	
	public void QPDescription(String des) {
		method.sendKeys(QPDescription, des);
	}
	
	public void examDuration(String time) {
		method.sendKeys(examDuration, time);
	}
	
	public void clickReviewBtn() {
		method.click(driver, reviewQuestion);
	}
	
	public void clickProceedAndSchedule() {
		method.click(driver, proceedScheduleBtn);
	}
	
	public TipsQpListPage clickFinalize() {
		method.click(driver, finalizeBtn);
		return new TipsQpListPage();
	}
	
	
	public boolean isPresent() {
		method.fluentWait(driver, firstQuestion, 5);
		return method.isDisplayed(driver, firstQuestion);
	}
	
	public boolean popUpPresent() {
		method.fluentWait(driver, maxQuestionAlert, 5);
		return method.isDisplayed(driver, maxQuestionAlert);
	}
	
	public boolean isDisplayImage() {
		return method.isDisplayed(driver, imageHome);
	}
	
	public boolean isDisplayQuetionError() {
		return method.isDisplayed(driver, questionAlert);
	}
	
	
	public boolean isDisplayQuetionError2() {
		return method.isDisplayed(driver, questionAlert2);
	}
}
