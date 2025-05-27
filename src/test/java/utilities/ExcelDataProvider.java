package utilities;

import org.testng.annotations.DataProvider;

public class ExcelDataProvider {
	
	
	 static String fileName=TestConstants.EXCEL_FILE_PATH;

    @DataProvider(name = "AllExcelDataProvider")
    public Object[][] getTitleData() {
        return new Object[][] {
            {"Title One"},
            {"Title Two"},
            {"Title Three"},
            {"Title Four"},
            {"Title Five"}
        };
    }
    
    
    
    
    // return data of a specific column using 2d object array 
    @DataProvider(name = "AllColumnDataProviderObject[]")
    public static Object[][] allColumnDataProvider() throws Exception {
        int sheetNo = 1;
        int colNo = 1;
        int totalRow = ReadExcelFile.getRowCount(fileName, sheetNo);
      
        Object[][] colData = new Object[totalRow][1];  // each row has 1 column of data
        
      

        for (int rowNo = 0; rowNo < totalRow; rowNo++) {
            colData[rowNo][0] = ReadExcelFile.getCellValue(fileName, sheetNo, rowNo, colNo);
        }
        System.out.println(" return data of a specific column using 2d object array ");

        return colData;
    }

    
    
    // return data of a specific column using 1d String array 
    @DataProvider(name = "AllColumnDataProviderString[]")
    public static String[] allColumnDataProviderbyStringarray() throws Exception {
    	System.out.println("entered into data provider String[]");
    	
    	  int sheetNo = 1;
          int colNo = 1;
    	
        int totalRow = ReadExcelFile.getRowCount(fileName, sheetNo);
        String[] colData = new String[totalRow];

        for (int rowNo = 0; rowNo < totalRow; rowNo++) {
            colData[rowNo] = ReadExcelFile.getCellValue(fileName, sheetNo, rowNo, colNo);
        }

        System.out.println("returned data of a specific column using 1d String array ");
        return colData;
    }
    
    
    
    //Read data from a specific Row using 2d object Array--ye aisa return karega {x,y,z,a}-- to single parametrr wali method jisme kewal title bhej rahe hain ye accept nahi karega kyuki 
    //kuiko isme ham ek saath 4 parametr bhej rahe hain 
    @DataProvider(name = "AllRowDataProviderObject[][]")
    public static Object[][] allRowDataProvider() throws Exception {
    	System.out.println("entered into AllRowDataProviderObject[][]");
        
        int sheetNo = 1;  	
        int rowNo = 1;

        int totalCol = ReadExcelFile.getColumnCount(fileName, sheetNo);
        
        // Declare and initialize the 2D Object array with 1 row and 'totalCol' columns
        Object[][] rowData = new Object[1][totalCol];

        for (int colNo = 0; colNo < totalCol; colNo++) {
            rowData[0][colNo] = ReadExcelFile.getCellValue(fileName, sheetNo, rowNo, colNo);
        }
        System.out.println("exit from AllRowDataProviderObject[][]");
        return rowData;
    }


    
    
    
    
  //Read data from a specific Row using 1d String Array
    @DataProvider(name = "AllRowDataProviderString[]")
    public static String[] allRowDataProvider1() throws Exception {
    	System.out.println("entered into AllRowDataProviderString[][]");
    	
    	int sheetNo=1;  	
    	int rowNo=1;
    	
        int totalCol = ReadExcelFile.getColumnCount(fileName, sheetNo);
        String[] rowData = new String[totalCol];

        for (int colNo = 0; colNo < totalCol; colNo++) {
            rowData[colNo] = ReadExcelFile.getCellValue(fileName, sheetNo, rowNo, colNo);
        }
        System.out.println("exit from AllRowDataProviderString[][]");
        return rowData;
    }

    
    

    //Read data from complete excel 
    @DataProvider(name = "AllExcelDataProvider")
    public static String[][] allExcelDataProvider(String fileName, int sheetNo) throws Exception {
        int totalRow = ReadExcelFile.getRowCount(fileName, sheetNo);
        int totalCol = ReadExcelFile.getColumnCount(fileName, sheetNo);

        String[][] allExcelData = new String[totalRow - 1][totalCol];

        for (int rowNo = 1; rowNo < totalRow; rowNo++) {
            for (int colNo = 0; colNo < totalCol; colNo++) {
                allExcelData[rowNo - 1][colNo] = ReadExcelFile.getCellValue(fileName, sheetNo, rowNo, colNo);
            }
        }

        return allExcelData;
    }
    
   
    
}
