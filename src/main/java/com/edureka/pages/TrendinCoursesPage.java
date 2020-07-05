package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.superhelper.EHC;
import com.edureka.superhelper.ReadFromExcel;

/***
 * 
 * @author Rajeev
 *
 */
public class TrendinCoursesPage extends EHC{

	WebDriver webdriver;
	public TrendinCoursesPage(WebDriver driver) {
		 this.webdriver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a[href='/post-graduate/nitw-ai-ml-pgp/']") public WebElement tile1;
	@FindBy(css="a[href='https://www.edureka.co/devops-certification-training']") public WebElement tile2;
	@FindBy(css="a[href='https://www.edureka.co/data-science-python-certification-course']") public WebElement tile3;
	@FindBy(css="a[href='https://www.edureka.co/data-science-python-certification-course']") public WebElement pythonCertification;
	@FindBy(css="https://www.edureka.co/microsoft-certified-azure-solution-architect-certification-training") public WebElement tile4;
	
	public void validateTile1() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			tile1.isDisplayed();
			tile1.click();
			pass("Tile1 is getting Displayed");
		} catch(Exception e) {
			fail("Tile1 button not Found");
		}
	}
	
	public void validateTile2() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			ReadFromExcel read = new ReadFromExcel();
			String course=read.getCourseName("Courses", "Career Related Program");
			tile2.isDisplayed();
			tile2.click();
			pass("Tile2 is getting Displayed");
			if(tile2.getText().contains(course)){
				pass("Tile2 course description passed for course:- "+ course);
			}
			else {
				fail("Tile2 course description Failed for course:- "+ course);
			}
		} catch(Exception e) {
			fail("Tile2 button not Found");
		}
	}
	
	public void validateTile3() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			ReadFromExcel read = new ReadFromExcel();
			String course=read.getCourseName("Courses", "Trending Courses");
			tile3.isDisplayed();
			tile3.click();
			pass("Tile3 is getting Displayed");
			if(tile3.getText().contains(course)){
				pass("Tile3 course description passed for course:- "+ course);
			}
			else {
				fail("Tile3 course description Failed for course:- "+ course);
			}
		} catch(Exception e) {
			fail("Tile3 button not Found");
		}
	}
	
	public void validateTile4() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			tile4.isDisplayed();
			tile4.click();
			pass("Tile4 is getting Displayed");
		} catch(Exception e) {
			fail("Tile4 button not Found");
		}
	}
}
