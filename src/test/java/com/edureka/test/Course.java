package com.edureka.test;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.edureka.pages.CoursePage;
import com.edureka.pages.HomePage;
import com.edureka.superhelper.EHC;

public class Course extends EHC{

	@Test(testName = "Navigate to Course Page")
	@Parameters({"browser","URL"})
	public void coursePage(String _browser, String _URL) throws IOException, InterruptedException {
		EHC.getDriverInstance(_browser,"coursePage").get(_URL);
		EHC.webdriver.manage().window().maximize();
		CoursePage cp = new CoursePage(EHC.webdriver);
		cp.navigateToCoursePage();
		cp.validateCourseLinks();
	}
}
