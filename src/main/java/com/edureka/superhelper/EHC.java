package com.edureka.superhelper;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.edureka.generic.AutomationConstants;
import com.edureka.pages.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


/***
 * 
 * @author Rajeev
 *
 */
public class EHC {

	private static final String CHROME=ResourseBundleUtils.getPropertyPath("chromedriver");
	public static WebDriver webdriver;
	public static String testName=null;
	public static ExtentReports report;
	public static ExtentTest logger;

	//public static Logger logger = Logger.getLogger(EHC.class.getName()); 
	
	public static WebDriver getDriverInstance(String browser, String testname) {
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", AutomationConstants.chromedriverPath);
			webdriver = new ChromeDriver();
			testName = testname;
			return webdriver;
		}
		else {
			System.setProperty("wsebdriver.chrome.driver", AutomationConstants.chromedriverPath);
			webdriver = new ChromeDriver();
			testName = testname;
			return webdriver;
		}
	}
	
	public static void waitForSeconds(double waitSecond) {
		waitSecond = waitSecond * 1000;
		Calendar currentTime = Calendar.getInstance();
		long currentTimeMillis = currentTime.getTimeInMillis();
		long secCounter = 0;
		while( secCounter < waitSecond) {
			Calendar newTime = Calendar.getInstance();
			secCounter = (newTime.getTimeInMillis()) - (currentTimeMillis);
		}
	}
	
	public static void pass(String message) {
		logger.log(LogStatus.PASS, "<div class=\"row\" style=\"background-color:#44aa44; color:white; padding: 7px 5px;\">" + message + "</div>");
	}
	
	public static void fail(String message) {
		logger.log(LogStatus.FAIL,"<div class=\"row\" style=\"background-color:#ff0000; color:white; padding: 7px 5px;\">" + message + "</div>");
	}
	
	public static void fail(String message,boolean ContinueExecution, String... severity) {
		if(ContinueExecution) {
			try {
				assertTrue(true);
			} catch(Throwable e) {
				addVerificationFailure(e);
				logger.log(LogStatus.FAIL,"<div class=\"row\" style=\"background-color:#ff0000; color:white; padding: 7px 5px;\""+ (severity.length > 0 ? "(" + severity[0] + ") " : "") + message  + "</div>" );
			}
		}
		else {
			Reporter.log("<div class=\"row\" style=\"background-color:#ff0000; color:white; padding: 7px 5px;\""+ (severity.length > 0 ? "(" + severity[0] + ") " : "") + message + "</div>");
			throw new AssertionError(message);
		}
	}
	
	public void waitUntilElementIsVisible(final WebElement element) {
		ExpectedCondition<Boolean> expectation = _driver -> element.isDisplayed();
		
		Wait<WebDriver> wait = new WebDriverWait(webdriver,60);
		wait.until(webDriver -> expectation);
	}
	
	public void executeUsingJavaScript(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;  
		js.executeScript("arguments[0].click()",element);
	}
	
	public void sendKeyUsingJavaScript(WebElement element, String value) {
		JavascriptExecutor jse = (JavascriptExecutor)webdriver;
		jse.executeScript("arguments[0].value='"+ value +"';", element);
	}
	private static void addVerificationFailure(Throwable e) {
		//Throwable verificationFailure = getVerificationFailures();
		Reporter.getCurrentTestResult();
	}
	
	@BeforeSuite(alwaysRun=true)
	public void runBeforeSuite() {
		report = new ExtentReports("./Reports/" + File.separator +""+ReportUtil.currentDaTe()+ "/edureka-Report.html", true); 
	}
	
	@BeforeMethod()
	public void startReport() {
		//report.loadConfig(new File("//home//.....//extent-config.xml"));
		logger = report.startTest(this.getClass().toString());
	}
	
	@AfterMethod(alwaysRun=true)
	  public void TearDown_AM(ITestResult result) throws IOException
	  {
	    try
	    { 
	        if(result.getStatus()==ITestResult.FAILURE)
	        {
	            String res = ScreenShot.takeScreenshot(webdriver, result.getName());
	            String TestCaseName = this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed";
	            logger.log(LogStatus.FAIL, "<div class=\"row\" style=\"background-color:#ff0000; color:white; padding: 7px 5px;\">" +TestCaseName  + logger.addScreenCapture(res)+ "</div>");
	            //  logger.log(LogStatus.FAIL, image, this.getClass().getSimpleName() + " Test Case Failure and Title/Boolean Value Failed");
	        }
	        else if(result.getStatus()==ITestResult.SUCCESS)
	        {
	        	String res = ScreenShot.takeScreenshot(webdriver, result.getName());
	            logger.log(LogStatus.PASS, "<div class=\"row\" style=\"background-color:#44aa44; color:white; padding: 7px 5px;\">" +this.getClass().getSimpleName() +" Test Case Success and Title Verified"+logger.addScreenCapture(res)+ "</div>"); 
	        }
	        else if(result.getStatus()==ITestResult.SKIP)
	        {
	            logger.log(LogStatus.SKIP, this.getClass().getSimpleName() + " Test Case Skipped");
	        }
	        report.endTest(logger);
	        report.flush();
	        webdriver.quit();
	    }
	    catch(Throwable t)
	    {
	        logger.log(LogStatus.ERROR,t.fillInStackTrace());
	        webdriver.quit();
	    }

	  }
}
