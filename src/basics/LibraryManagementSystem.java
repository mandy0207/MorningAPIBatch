package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import utils.ParseJson;
import utils.PayLoad;
import utils.TestProperties;
import utils.UniqueGenerator;

public class LibraryManagementSystem {

	@Test
	public void verifyLibraryE2ETests() throws IOException {

		String isbn = UniqueGenerator.getUniqueString();
		String aisle = UniqueGenerator.getFaker().code().gtin13();

		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(PayLoad.getBooksPayload(isbn, aisle)).when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response()
				.asString();
		System.out.println(response);
		
		JsonPath js = ParseJson.parseJsonString(response);
		String actualMsg=js.get("Msg");
		String expectedMsg=TestProperties.getProperties().getProperty("addBookMsg");
		//TestNG Assertion
		Assert.assertEquals(actualMsg, expectedMsg, "Adding Book Failed");

	}
}
