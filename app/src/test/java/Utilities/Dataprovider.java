package Utilities;

import java.io.File;
import org.testng.ITestContext;

import org.testng.annotations.DataProvider;

public class Dataprovider {

    @DataProvider(name ="testData")
    public static Object[][] getTestData(){
        String filepath = System.getProperty("user.dir") + "/" + "src/test/resources/Dataprovider";

        File folder = new File(filepath);

        File[] listOfFiles  = folder.listFiles((dir,name) -> name.endsWith(".ini"));

        Object[][] data = new Object[listOfFiles.length][1];
        for(int i = 0; i < listOfFiles.length; i++){
            data[i][0] = listOfFiles[i].getAbsolutePath();
        }

        System.out.println("Files found: " + (listOfFiles == null ? "null" : listOfFiles.length));
        return data;
    }
    
}
