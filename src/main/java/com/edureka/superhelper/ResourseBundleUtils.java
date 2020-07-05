package com.edureka.superhelper;

import java.util.ResourceBundle;

/***
 * 
 * @author Rajeev
 *
 */
public class ResourseBundleUtils {

	private static ResourceBundle path =  ResourceBundle.getBundle("com.edureka.data.path");
	private static ResourceBundle user =  ResourceBundle.getBundle("com.edureka.data.user");
	
	public static String getUserDetails(String property) {
		return user.getString(property);
	}
	
	public static String getPropertyPath(String property) {
		return path.getString(property);
	}
}
