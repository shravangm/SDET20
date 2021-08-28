package com.vtiger.comcast.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * used to handle Microsoft excel sheet
 * @author pc
 *
 */
public class ExcelUtility {
	
	/**
	 * this method is used to extract data from the excel based on below arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName , int rowNum, int celNum) throws Throwable {
	FileInputStream fis  = new FileInputStream("./data/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	String data = row.getCell(celNum).getStringCellValue();
	wb.close();
	return data;
	}
	
	/**
	 * method used to get the last used row number on a specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
	FileInputStream fis  = new FileInputStream("./TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	wb.close();
	return sh.getLastRowNum();
	}
	
	/**
	 * method is used to set data in a specified sheet
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	public void setDataExcel(String sheetName , int rowNum, int celNum ,String data) throws Throwable {
	FileInputStream fis  = new FileInputStream("./data/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cel = row.createCell(celNum);
	cel.setCellValue(data);
	FileOutputStream fos = new FileOutputStream("./data/TestData.xlsx");
	wb.write(fos);
	wb.close();
		
	}

	
}
