package com.jbk;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
		public static long PageLoadTime = 20;
		public static long ImpliciteTime = 10;

		public static Workbook book;
		public static Sheet sheet;

		public static FileInputStream fis;

		public static Object[][] getExcelData(String sheetName)  {

			
			Object data[][]=null;
			try {
				fis = new FileInputStream(
						"D:\\Workspace\\JavaByKiran\\DataProviderAutomate\\src\\com\\jbk\\AdminLTETestData.xlsx");
				book = WorkbookFactory.create(fis);
				sheet = book.getSheet(sheetName);
				int row = sheet.getLastRowNum();
				int col = sheet.getRow(0).getLastCellNum();
				
				data = new Object[row][col];
				for (int i = 0; i < row; i++) {
					for (int j = 0; j < col; j++) {
						
						data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
						
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return data;
		}
	}

			


