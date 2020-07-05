package com.edureka.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.edureka.superhelper.EHC;

/***
 * 
 * @author Rajeev
 *
 */
public class HomePage extends EHC{
	WebDriver webdriver;
	public HomePage(WebDriver driver) {
		 this.webdriver=driver;
		 PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".navbar.navbar-fixed-top>ul>li:nth-child(4)>a") public WebElement login;
	@FindBy(css=".modal-body>div:nth-child(3)>form>div>input:nth-child(2)") public WebElement email;
	@FindBy(css=".inputfld>input[placeholder='Enter your Password']") public WebElement password;
	@FindBy(css=".login_video_frm.login-vd-box.sigin-new-division>form>button") public WebElement loginButton;
	
	public void clickLogin() throws InterruptedException {
		try {
			EHC.waitForSeconds(2);
			login.isDisplayed();
			login.click();
			pass("Login Button f Clicked");
		} catch(Exception e) {
			fail("Login button not Found");
		}
	}
	
	public void enterEmail(String emailId) throws InterruptedException {
		try {
			EHC.waitForSeconds(1);
			waitUntilElementIsVisible(email);
			sendKeyUsingJavaScript(email, emailId);
			pass("Email Id Entered");
		} catch(Exception e) {
			fail("Email Field not Found");
		}
	}
	
	public void enterPassword(String pass) throws InterruptedException {
		try {
			waitUntilElementIsVisible(password);
			sendKeyUsingJavaScript(password, pass);
			pass("Password Entered");
		} catch(Exception e) {
			fail("Password Field not Found");
		}
	}
	
	public void clickLoginButton() throws InterruptedException {
		EHC.waitForSeconds(2);
		try {
			loginButton.isDisplayed();
			loginButton.click();
			pass("Login Button Inside Pop-up Clicked");
		} catch(Exception e) {
			fail("Login button Inside Pop-up not Found");
		}
	}
	
	public void userLogin(String emailId, String pass) throws InterruptedException {
		//webdriver.switchTo().window(loginTab.get(0));
		EHC.waitForSeconds(2);
		enterEmail(emailId);
		enterPassword(pass);
		clickLoginButton();
	}
	
	public void userLogin(String[] details) throws InterruptedException {
		EHC.waitForSeconds(2);
		enterEmail(details[0]);
		enterPassword(details[1]);
		clickLoginButton();
	}
}
