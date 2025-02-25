package com.techmahindra.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Vishwanath
 */

public class ExcelUtility {
	/**
	 * This below method is to read values from the excel sheet and return string data.
	 * @param sheetname
	 * @param rowindex
	 * @param colIndex
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getStringDagtaFromExcel(String sheetname, int rowindex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".src/test/resources/test-data/TestData.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getStringCellValue();
		
	}
	
	public Boolean getBoolenValuesFromExcel(String sheetname, int rowindex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".src/test/resources/test-data/TestData.xlsx");
		Workbook workbook1 = WorkbookFactory.create(fis);
		return workbook1.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getBooleanCellValue();
	}
	
	public double getNumberDataFromExcel(String sheetname, int rowindex, int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".src/test/resources/test-data/TestData.xlsx");
		Workbook workbook2 = WorkbookFactory.create(fis);
		return workbook2.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getNumericCellValue();	
		}
	
	public LocalDateTime getDataAndTimeFromExcel(String sheetname, int rowindex, int colIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(".src/test/resources/test-data/TestData.xlsx");
		Workbook workbook3 = WorkbookFactory.create(fis);
		return workbook3.getSheet(sheetname).getRow(rowindex).getCell(colIndex).getLocalDateTimeCellValue();
	}
}