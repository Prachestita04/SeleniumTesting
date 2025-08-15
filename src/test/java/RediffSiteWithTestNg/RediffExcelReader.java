package RediffSiteWithTestNg;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class RediffExcelReader {
    Workbook workbook;  //read and write of data in a excel file (both .xls and .xlsx)

    public RediffExcelReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath); //get our data from file

        if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(fis); // for .xlsx files
        } else if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(fis); // for .xls files
        } else {
            throw new IllegalArgumentException("The file format is not supported.");
        }
    }


    // Get total row count from a given sheet name
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the workbook.");
        }

        return sheet.getPhysicalNumberOfRows(); // counts only rows with data
    }


    // Get cell data by sheet name, column name, and row number
    public String getCellData(String sheetName, String colName, int rowNum) {
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) return "";

        // Get header row (assume first row is header)
        Row headerRow = sheet.getRow(0);
        if (headerRow == null) return "";

        // Find column index for the given column name
        int colIndex = -1;
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell cell = headerRow.getCell(i);
            if (cell != null && cell.getStringCellValue().trim().equalsIgnoreCase(colName.trim())) { //here trim() removes leading and trailing space of a string
                colIndex = i;
                break;
            }
        }

        if (colIndex == -1) {
            throw new IllegalArgumentException("Column '" + colName + "' not found in sheet '" + sheetName + "'");
        }

        // Get the requested row
        Row row = sheet.getRow(rowNum);
        if (row == null) return "";

        // Get cell at the found column index
        Cell cell = row.getCell(colIndex);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }


    public void close() throws IOException {
        workbook.close();
    }

    // Test the methods
    public static void main(String[] args) throws IOException {
        RediffExcelReader reader = new RediffExcelReader("C:\\Users\\user\\Desktop\\RediffMailData.xlsx");

        String sheet = "Sheet1";
        int rowCount = reader.getRowCount(sheet);
        System.out.println("Row Count: " + rowCount);

        for (int rowNum = 1; rowNum < reader.getRowCount(sheet); rowNum++) {
            String cellData = reader.getCellData(sheet, "FullName", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "Email", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "Password", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "RetypePassword", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "Year", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "Gender", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "Country", rowNum);
            System.out.print(cellData + "\t");

            cellData = reader.getCellData(sheet, "City", rowNum);
            System.out.print(cellData);
            System.out.println();
        }

        reader.close();
    }
}
