package com.edureka.superhelper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/***
 * 
 * @author Rajeev
 *
 */
public class ScreenShot {

	public static String takeScreenshot(WebDriver driver,String testName) {
	File srcFile= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String path= "./Reports/"+ReportUtil.currentDaTe()+"/"+testName+"-" +System.currentTimeMillis()+".png";
	File desFile= new File(path);
	try {
		FileUtils.copyFile(srcFile,desFile);
	} catch (IOException e) {
		System.out.println("Capture Failed "+e.getMessage());
	}
	return path;
	}
}
