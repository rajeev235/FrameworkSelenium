package com.edureka.test;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.edureka.pages.HomePage;
import com.edureka.pages.TrendinCoursesPage;
import com.edureka.superhelper.EHC;
import com.edureka.superhelper.ReadFromExcel;
import com.edureka.superhelper.ResourseBundleUtils;

/***
 * 
 * @author Rajeev
 *
 */
public class TrendingCourses extends EHC{
	
	@Test(testName = "Validate Tiles Trending Courses")
	@Parameters({"browser","URL"})
	public void validateTile(String _browser, String _URL) throws IOException, InterruptedException {
		EHC.getDriverInstance(_browser,"validateTile").get(_URL);
		EHC.webdriver.manage().window().maximize();
		TrendinCoursesPage tcp = new TrendinCoursesPage(EHC.webdriver);
		tcp.validateTile1();
		tcp.validateTile2();
		tcp.validateTile3();
		tcp.validateTile4();
	}
	
}
