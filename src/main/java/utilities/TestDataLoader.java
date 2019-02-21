package utilities;

import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * @author jotba
 * Contains JSON Object parsing methods and retrieving the required parameter details
 */
public class TestDataLoader {
	
	JsonObject testData = null;
	private String jsonFileName = "applicationUIData.json";
	
	public JsonObject getTestData(String searchCriteria) {
		JsonObject fullDataSheet = null;
		JsonParser parser = new JsonParser();
		String fileName = System.getProperty("user.dir") + "/src/test/java/testData/" + jsonFileName;
		try {
			fullDataSheet = (JsonObject) parser.parse(new FileReader(fileName));
			testData = (JsonObject)fullDataSheet.getAsJsonObject(searchCriteria);//.get(searchCriteria);
		} catch(Exception e) {
			throw new RuntimeException("Failed to read test data from " + fileName, e);
		}
		return fullDataSheet;
	}
	
	public JsonObject getScenarioData(String scenario) {
		
		JsonObject scenarioData = null;
		try {
			JsonObject fullSheet;
			
			fullSheet = getTestData(scenario);
			
			scenarioData = (JsonObject) fullSheet.get(scenario);					
		} catch (Exception ex) {
			throw new RuntimeException("Failed to read the scenario " + scenario, ex);
		}
		return scenarioData;
	}
	
	public String searchParameter(String searchModule, String searchValues) {
		
		JsonObject getData = getScenarioData(searchModule);
		String tmpSearchValue = getData.get(searchValues).toString();
		String searchVal = tmpSearchValue.substring(1, tmpSearchValue.length()-1);
		return searchVal;
	}

}
