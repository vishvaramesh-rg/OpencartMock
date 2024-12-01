package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//dateprovider 1
	
	@DataProvider(name="data")
	public String[][] datas() throws IOException {
		
		String path=System.getProperty("user.dir")+"\\testData\\OpenCart_loginDDT.xlsx";
		ExcelUtility exu = new ExcelUtility(path);
		
		int rowCount = exu.getRowCount("users");
		int cellCount = exu.getCellCount("users", 1);
		
		String [][] logindata = new String[rowCount][cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				
				 logindata[i-1][j] = exu.getCellData("users", i, j);
			}
		}
		
		return logindata;
	}
	
	//dateprovider 2
	
	//dateprovider 3
	
	//dateprovider 4

}
