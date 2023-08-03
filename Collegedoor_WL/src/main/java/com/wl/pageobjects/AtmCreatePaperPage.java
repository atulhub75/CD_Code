package com.wl.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wl.actionmethod.Methods;
import com.wl.base.BaseClass;

public class AtmCreatePaperPage extends BaseClass{
	Methods method=new Methods();
	
	@FindBy(xpath="//button[normalize-space()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//input[@id='question_paper_desc']")
	WebElement qpDescription;
	
	@FindBy(xpath="//span[@id='question_paper_desc_err']")
	WebElement qpMessage;
	
	@FindBy(xpath="//select[@id='flag']")
	WebElement restrictQue;
	
	@FindBy(xpath="//span[@id='select2-test_type_id-container']")
	WebElement selectExam;
	
	@FindBy(xpath="(//input[@role='searchbox'])[5]")
	WebElement ExamSearchBox;
	
	@FindBy(xpath="//li[@class='select2-results__option select2-results__option--highlighted']")
	WebElement SearchedValue;
	
	@FindBy(xpath="//select[@id='test_sub_type_id']")
	WebElement subType;
	
	@FindBy(xpath="//span[@id='select2-test_component_id-container']")
	WebElement syllabus;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']//input[@role='searchbox']")
	WebElement syllSearchBox;
	
	@FindBy(xpath="//select[@id='question_pattern_type']")
	WebElement quePatternType;
	
	@FindBy(xpath="//span[@id='select2-question_paper_level-container']")
	WebElement difficultyLevel;
	
	@FindBy(xpath="(//input[@role='searchbox'])[5]")
	WebElement diffSearchBox;
	
	
	@FindBy(xpath="//select[@id='include_used_question']")
	WebElement includeUsedQue;
	
	@FindBy(xpath="//input[@placeholder='Select Editor']")
	WebElement editerAccess;
	
	@FindBy(xpath="//input[@id='test_duration']")
	WebElement testDuration;
	
	@FindBy(xpath="//span[@id='select2-subject_id-container']")
	WebElement subjectDP;
	
	@FindBy(xpath="(//input[@role='searchbox'])[5]")
	WebElement subjectSearchField;
	
	
	@FindBy(xpath="//input[@placeholder='Select Area']")
	WebElement selectArea;
	
	
	@FindBy(xpath="//input[@placeholder='Select Chapters']")
	WebElement selectChapter;
	
	
	@FindBy(xpath="//input[@placeholder='Select Topics']")
	WebElement topic;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	WebElement addBtn;
	
	@FindBy(xpath="//label[normalize-space()='Question Count']")
	WebElement forAjax;
	
	@FindBy(xpath="//button[@class='btn btn-success saveBtn checkStepTwoForm float-lg-right']")
	WebElement genPaperBtn;
	
	@FindBy(xpath="//div//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
	WebElement popUpYesBtn;
	
	@FindBy(xpath="//span[@id='questCountError_0_err']")
	WebElement NoqueErrorMsg;
	
	@FindBy(xpath="//input[@placeholder='Enter No. of Questions']")
	WebElement enterQue;
	
	@FindBy(xpath="//button[normalize-space()='Generate Paper']")
	WebElement saveLaterBtn;
	
	@FindBy(xpath="	//div[@class='alert alert-success']")
	WebElement paperCreated;
	
	public AtmCreatePaperPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void paperDescription(String des) {
		method.sendKeys(qpDescription, des);
	}
	
	public void selectExam(String exam) throws InterruptedException {
		method.click(driver, selectExam);
		Thread.sleep(3000);
		method.sendKeys(ExamSearchBox, exam);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectSyllabus(String syllab) throws InterruptedException {
		method.click(driver, syllabus);
		Thread.sleep(3000);
		method.sendKeys(syllSearchBox, syllab);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}

	public void selectQuesPatternType() {
		method.selectByVisibleText("Standard", quePatternType);
	}
	
	public void selectDifficultyM() throws InterruptedException {
		method.click(driver, difficultyLevel);
		Thread.sleep(3000);
		method.sendKeys(diffSearchBox, "Medium");
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectDifficulty(String Diffi) throws InterruptedException {
		method.click(driver, difficultyLevel);
		Thread.sleep(3000);
		method.sendKeys(diffSearchBox, Diffi);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void clickIncludeUsedQuestion() {
		method.selectByVisibleText("Yes", includeUsedQue);
	}
	
	public void TestDuration() {
		method.sendKeys(testDuration, "90");
	}
	
	public void TestDuration1(String time) {
		method.sendKeys(testDuration, time);
	}
	
	public void selectSubject(String subject) throws InterruptedException {
		method.click(driver, subjectDP);
		Thread.sleep(2000);
		method.sendKeys(subjectSearchField, subject);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectArea(String area) throws InterruptedException {
		method.click(driver, selectArea);
		Thread.sleep(2000);
		method.sendKeys(selectArea, area);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectChapter(String chapter) throws InterruptedException {
		method.click(driver, selectChapter);
		Thread.sleep(2000);
		method.sendKeys(selectChapter, chapter);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void selectTopic(String Topic) throws InterruptedException {
		method.click(driver, topic);
		Thread.sleep(2000);
		method.sendKeys(topic, Topic);
		Thread.sleep(2000);
		method.click(driver, SearchedValue);
	}
	
	public void clickAddBtn() {
		method.click(driver, addBtn);
	}
	
	public boolean validateMessage() throws Throwable {
		 return method.isDisplayed(driver, NoqueErrorMsg);
	}
	
	
	public void enterQuestionInBox1(String num) {
		//method.scrollByVisibilityOfElement(driver, enterQue);
		method.sendKeys(enterQue, num);
		method.click(driver, forAjax);
	}
	
	public void clickGenerateBtn() throws Exception {
		method.scrollByVisibilityOfElement(driver, genPaperBtn);
		//method.fluentWait(driver, genPaperBtn, 10);
		method.click(driver, genPaperBtn);
		//method.JSClick(driver, genPaperBtn);
	}
	
	public ATMHomePage clickPopUpYesBtn() throws Exception {
		//method.fluentWait(driver, popUpYesBtn, 5);
		method.JSClick(driver, popUpYesBtn);
		return new ATMHomePage();
	}
	
	public boolean validatePaperCreatedMessage() throws Throwable {
		 return method.isDisplayed(driver, paperCreated);
	}
	
	public boolean validateQpMessage() throws Throwable {
		method.scrollByVisibilityOfElement(driver, qpMessage);
		 return method.isDisplayed(driver, qpMessage);
	}
}
