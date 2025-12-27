package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelFile(String key, int rownum, int callNm)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\nallathambi p\\eclipse-workspace\\nallathambi\\ComcastCRMGUIFramework\\testData\\Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(key).getRow(rownum).getCell(callNm).toString();

		wb.close();

		return data;
	}

	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\nallathambi p\\eclipse-workspace\\nallathambi\\ComcastCRMGUIFramework\\testData\\Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();

		wb.close();
		return rowcount;

	}

	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\nallathambi p\\eclipse-workspace\\nallathambi\\ComcastCRMGUIFramework\\testData\\Vtiger.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		FileOutputStream file = new FileOutputStream("C:\\Users\\nallathambi p\\eclipse-workspace\\nallathambi\\ComcastCRMGUIFramework\\testData\\Vtiger.xlsx");
		wb.write(file);
		wb.close();
	}
}
