package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import pojo.Book;

public class LearnDeserialization {

	
	@Test
	public void myFirstDeserializeTest() throws JsonMappingException, JsonProcessingException {
		RestAssured.baseURI = "http://216.10.245.166";
		String bookResponse = given().log().all().queryParam("ID", "SHABANA123123").when().get("/Library/GetBook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
		 
		ObjectMapper mapper = new ObjectMapper();
		Book[] bookArray = mapper.readValue(bookResponse, Book[].class);
		
	
		for(Book book : bookArray) {
			
			System.out.println(book.getIsbn());
			System.out.println(book.getAuthor());
		}
		
		
		
	
		 
	}
}
