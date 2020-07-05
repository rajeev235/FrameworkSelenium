package com.edureka.test;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.edureka.pages.HomePage;
import com.edureka.superhelper.EHC;
import com.edureka.superhelper.ResourseBundleUtils;

public class Home extends EHC{

	@Test(testName = "Login User")
	@Parameters({"browser","URL"})
	public void login(String _browser, String _URL) throws IOException, InterruptedException {
		EHC.getDriverInstance(_browser,"login").get(_URL);
		EHC.webdriver.manage().window().maximize();
		HomePage hp = new HomePage(EHC.webdriver);
		String userDetails=ResourseBundleUtils.getUserDetails("User");
		String[] user = userDetails.split("=");
		hp.clickLogin();
		hp.userLogin(user[0], user[1]);
	}
	
	@Test(testName = "Login User using Overloaded method")
	@Parameters({"browser","URL"})
	public void loginOverloadedMethod(String _browser, String _URL) throws IOException, InterruptedException {
		EHC.getDriverInstance(_browser,"loginOverloadedMethod").get(_URL);
		EHC.webdriver.manage().window().maximize();
		HomePage hp = new HomePage(EHC.webdriver);
		String userDetails=ResourseBundleUtils.getUserDetails("User");
		String[] user = userDetails.split("=");
		hp.clickLogin();
		hp.userLogin(user);
	}
}
