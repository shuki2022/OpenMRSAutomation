package com.openmrs.utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelUtil {

    private static Workbook book;
    private static Sheet sheet;

    private static String TEST_DATA_SHEET_PATH = "./src/main/java/com/openmrs/testdata/OpenMRSData.xlsx";

    public static Object[][] getTestData(String sheetName) {
        Object data[][] = null;
        try {
            FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
            book = WorkbookFactory.create(fis);
            sheet = book.getSheet(sheetName);
            data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                    data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
        return data;
    }
}

