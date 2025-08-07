import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {

    Workbook workbook;

    public ExcelReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(filePath));

        if (filePath.endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(fis); // for .xlsx files
        } else if (filePath.endsWith(".xls")) {
            workbook = new HSSFWorkbook(fis); // for .xls files
        } else {
            throw new IllegalArgumentException("The file format is not supported.");
        }
    }

    // Get total row count from a sheet
    public int getRowCount(String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        return sheet.getPhysicalNumberOfRows();  // counts only non-empty rows
    }

    // Get cell data by row and column index
    public String getCellData(String sheetName, int rowNum, int colNum) {
        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);

        if (row == null) return "";

        Cell cell = row.getCell(colNum);
        if (cell == null) return "";

        DataFormatter formatter = new DataFormatter(); // handles different cell types
        return formatter.formatCellValue(cell);
    }

    public void close() throws IOException {
        workbook.close();
    }

    // Test the methods
    public static void main(String[] args) throws IOException {
        ExcelReader reader = new ExcelReader("testdata.xlsx");

        String sheet = "Sheet1";
        int rowCount = reader.getRowCount(sheet);
        System.out.println("Row Count: " + rowCount);

        for (int i = 0; i < rowCount; i++) {
            String cellData = reader.getCellData(sheet, i, 0);
            System.out.println("Row " + i + ", Col 0: " + cellData);
        }

        reader.close();
    }
}
