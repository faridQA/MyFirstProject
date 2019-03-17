package data;

import java.util.HashMap;

import utils.ExcelUtils;

public class TestDataPool {
	//Static instance of HashMap
	public static HashMap<String, String> tcData = new HashMap<>();

	TestDataPool() throws Exception{
		tcData = ExcelUtils.getTestDataXls(Constants.DATAPOOL_PATH, "DemoAut", 0, 1);

	}
	
	//Parameterized Constructor to call from test case
	public TestDataPool(int tcRowNum){
		try {
			tcData = ExcelUtils.getTestDataXls(Constants.DATAPOOL_PATH, "DemoAut", 0, tcRowNum);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
