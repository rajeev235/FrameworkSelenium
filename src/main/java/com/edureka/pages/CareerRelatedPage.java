package com.edureka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.edureka.superhelper.EHC;

public class CareerRelatedPage extends EHC{

	WebDriver webdriver;
	public CareerRelatedPage(WebDriver driver) {
		 this.webdriver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".career_related_master_slider.slick-initialized.slick-slider>div>div>div>div>a[href*='/masters-program/cloud-architect-training']") public WebElement tile1;
	@FindBy(css=".career_related_master_slider.slick-initialized.slick-slider>div>div>div>div>a[href*='/masters-program/devops-engineer-training']") public WebElement tile2;
	@FindBy(css=".career_related_master_slider.slick-initialized.slick-slider>div>div>div>div>a[href*='/masters-program/big-data-architect-training']") public WebElement tile3;

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
			tile2.isDisplayed();
			tile2.click();
			pass("Tile2 is getting Displayed");
		} catch(Exception e) {
			fail("Tile2 button not Found");
		}
	}
	
	public void validateTile3() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			tile3.isDisplayed();
			tile3.click();
			pass("Tile3 is getting Displayed");
		} catch(Exception e) {
			fail("Tile3 button not Found");
		}
	}
}
