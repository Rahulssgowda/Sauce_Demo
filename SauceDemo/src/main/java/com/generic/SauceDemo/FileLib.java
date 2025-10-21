package com.generic.SauceDemo;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib { 

	public String getExcelData(String sheetName,int row,int cell) throws EncryptedDocumentException, IOException
	{

		FileInputStream file = new FileInputStream("./src/test/resources/TestData/SauceTestData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Cell cel= wb.getSheet(sheetName).getRow(row).getCell(cell);
		DataFormatter df = new DataFormatter();
		String value = df.formatCellValue(cel);
		return value;
	}
}