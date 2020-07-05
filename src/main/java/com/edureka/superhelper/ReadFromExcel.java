package com.edureka.superhelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.edureka.generic.AutomationConstants;

/***
 * 
 * @author Rajeev
 *
 */
public class ReadFromExcel {

	public String getCourseName(String sheetName,String heading) throws IOException {
		File file = new File(AutomationConstants.messagefilePath);
		FileInputStream inputStream= new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet(sheetName);
		XSSFRow row = null;
		String course=null;
		for (int i=1; i<sheet.getLastRowNum(); i++) {
			row= sheet.getRow(i);
			if((row.getCell(0) != null)&& (row.getCell(0).toString().equals(heading))){
				course= row.getCell(1).toString();
				break;
			}
		}
		return course;
	}
}
