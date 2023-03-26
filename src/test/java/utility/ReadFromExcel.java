package utility;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

public class ReadFromExcel {

	String[][] arrayExcelData = null;

	Workbook wb = null;

	public String[][] getExcelData(String fileName, String sheetName) throws IOException {

		File file = new File(fileName);
		FileInputStream fs = new FileInputStream(file);

		wb = new HSSFWorkbook(fs);

		Sheet sh = wb.getSheet(sheetName);
		int totalNoOfRows = sh.getPhysicalNumberOfRows();
		int totalNoOfCols = sh.getRow(0).getPhysicalNumberOfCells();

		arrayExcelData = new String[totalNoOfRows - 1][totalNoOfCols];

		for (int i = 1; i <= totalNoOfRows - 1; i++) {
			for (int j = 0; j <= totalNoOfCols - 1; j++) {
				sh.getRow(i).getCell(j).setCellType(CellType.STRING);
				arrayExcelData[i - 1][j] = sh.getRow(i).getCell(j).getStringCellValue().toString();
			}
		}

		// Close inputstream
		fs.close();

		return arrayExcelData;
	}

}
