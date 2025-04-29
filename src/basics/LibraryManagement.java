package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.PayLoad;
import utils.UniqueGenerator;

public class LibraryManagement {

	@Test
	public void verifyBooksActions() {
		
		String isbn =UniqueGenerator.getUniqueString();
		String aisle=Integer.toString(UniqueGenerator.getRandomNumber());
	
		RestAssured.baseURI= "http://216.10.245.166";
		String response=given().log().all().headers("Content-Type", "application/json").body(PayLoad.getBooksPayload(isbn, aisle)).when().post("/Library/Addbook.php").
		then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response().asString();
		
		System.out.println(response);
		JsonPath js= new JsonPath(response);
		String actualMsg=js.get("Msg");
		
		
		Assert.assertEquals(actualMsg, "successfully added");
		


		
		

		
	}
}
