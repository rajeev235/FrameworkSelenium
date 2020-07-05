package com.edureka.generic;

/***
 * 
 * @author Rajeev
 *
 */
public interface AutomationConstants {

	//File Path
	String projectPath=System.getProperty("user.dir");
	public static final String chromedriverPath=projectPath+"/src/driver/chromedriver1.exe";
	public static final String messagefilePath= projectPath+"/src/main/java/com/edureka/data/CourseDetails.xlsx";
	
	
	//Config Variable
	public static final String Browser="Chrome";
}
