import java.io.IOException;
import java.util.ArrayList;

public class TestUtil {
    static ExcelReader reader;

    public static ArrayList<Object[]> getData() {
        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new ExcelReader("C:\\Users\\user\\Desktop\\FacebookDataSelenium.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int rowNum = 1; rowNum < reader.getRowCount("Sheet1"); rowNum++) {
            String firstName = reader.getCellData("Sheet1", "Firstname", rowNum);
            String lastName = reader.getCellData("Sheet1", "Lastname", rowNum);
            String date = reader.getCellData("Sheet1", "date", rowNum);

            Object ob[] = {firstName, lastName, date};
            myData.add(ob);
        }
        return myData;
    }
}
