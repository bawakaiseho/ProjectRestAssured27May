package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {

    public static FileInputStream fileinputstream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    
   

    public static String getCellValue(String filename, int sheetNo, int rowNo, int colNo) {
    	
        try {
            fileinputstream = new FileInputStream(filename);
            workbook = new XSSFWorkbook(fileinputstream);
            sheet = workbook.getSheetAt(sheetNo);
            row = sheet.getRow(rowNo);
            cell = row.getCell(colNo);
            String value = cell.getStringCellValue();
            workbook.close();
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static int getRowCount(String filename, int sheetNo) throws IOException {
    	

    	  try {
        fileinputstream = new FileInputStream(filename);
        
        System.out.println("Excel file path is  = "+filename);
        workbook = new XSSFWorkbook(fileinputstream);
        
        sheet = workbook.getSheetAt(sheetNo);
        
        System.out.println("sheet no is = "+sheetNo);
        
        int rowCount = sheet.getLastRowNum() + 1;
        workbook.close();
        return rowCount;
    	  }
    	  catch (Exception e) {
    	        System.err.println("❌ Exception occurred while opening workbook:");
    	        e.printStackTrace();
    	        throw e;
    	    }
    }

    public static int getColumnCount(String filename, int sheetNo) throws IOException {
        fileinputstream = new FileInputStream(filename);
        workbook = new XSSFWorkbook(fileinputstream);
        sheet = workbook.getSheetAt(sheetNo);
        row = sheet.getRow(0);
        int colCount = row.getLastCellNum();
        workbook.close();
        return colCount;
    }
}
