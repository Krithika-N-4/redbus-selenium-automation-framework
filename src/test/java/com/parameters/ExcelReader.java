package com.parameters;
 
import java.io.File;

import java.io.IOException;
 
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelReader {
 
	public static Object[][] readExcelData(String filename, String sheetname)
			throws InvalidFormatException, IOException {

		File file = new File(filename);

		XSSFWorkbook wb = new XSSFWorkbook(file); 
		XSSFSheet sheet = wb.getSheet(sheetname); 
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows-1][cols];

		for (int i=1; i<rows; i++) {  
			Row row = sheet.getRow(i); 
			for (int j=0; j<cols; j++) {

				Cell cell = row.getCell(j);

				data[i-1][j] = (cell != null)? cell.toString():"";

			}

		}

		wb.close();

		return data;

	}

}
 