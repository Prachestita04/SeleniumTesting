package RediffSiteWithTestNg;

import java.io.IOException;
import java.util.ArrayList;

public class RediffTestUtil {
    static RediffExcelReader reader;

    public static ArrayList<Object[]> getData() {
        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new RediffExcelReader("C:\\Users\\user\\Desktop\\RediffMailData.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int rowNum = 1; rowNum < reader.getRowCount("Sheet1"); rowNum++) {
            String fullName = reader.getCellData("Sheet1", "FullName", rowNum);
            String email = reader.getCellData("Sheet1", "Email", rowNum);
            String password = reader.getCellData("Sheet1", "Password", rowNum);
            String rePass = reader.getCellData("Sheet1", "RetypePassword", rowNum);
            String year = reader.getCellData("Sheet1", "Year", rowNum);
            String gender = reader.getCellData("Sheet1", "Gender", rowNum);
            String country = reader.getCellData("Sheet1", "Country", rowNum);
            String city = reader.getCellData("Sheet1", "City", rowNum);

            Object ob[] = {fullName, email, password, rePass, year, gender, country, city};
            myData.add(ob);
        }
        return myData;
    }
}
