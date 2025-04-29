package utils;

import io.restassured.path.json.JsonPath;

public class ParseJson {

	public static JsonPath parseJsonString(String jsonResponse) {
		return new JsonPath(jsonResponse);
	
	}
}
