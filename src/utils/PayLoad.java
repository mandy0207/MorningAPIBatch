package utils;

public class PayLoad {

	public static String getBooksPayload(String isbn, String aisle) {

		return "{\r\n"
				+ "\"name\":\"Rest Assured\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"Nick Ryan\"\r\n"
				+ "}";
	}
	
	

}
