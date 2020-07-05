package com.edureka.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.superhelper.EHC;

public class CoursePage extends EHC{

	WebDriver webdriver;
	public CoursePage(WebDriver driver) {
		 this.webdriver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".navbar.navbar-fixed-top>ul>li:nth-child(2)>a") public WebElement course;
	@FindBy(css="div[id='add-master-courses']>a[href*='https://www.edureka.co/']") public List<WebElement> courseList;	
	
	public void navigateToCoursePage() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			waitUntilElementIsVisible(course);
			course.click();
			pass("Course Button Clicked");
		} catch(Exception e) {
			fail("Course Link Found");
		}
	}
	
	public void validateCourseLinks() {
		int i=0;
		try {
		int length = courseList.size();
		for(i=0;i<2;i++) {
			courseList.get(i).click();
			webdriver.navigate().back();
		}
		pass("All " +length+ "Curse Links are validated and Working");
		} catch(Exception e) {
			fail("Links Validation Failed For:- "+courseList.get(i).getText());
		}
	}
}
