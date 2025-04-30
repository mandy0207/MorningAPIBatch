package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Book;
import utils.UniqueGenerator;

public class LearnSerialization {

	
	@Test
	public void verifyUserAbleToAddBookUsingSerialization() {
		String bookName= UniqueGenerator.getFaker().book().title();
		String isbn = UniqueGenerator.getUniqueString();
		String aisle = Integer.toString(UniqueGenerator.getRandomNumber());
		String author=UniqueGenerator.getFaker().book().author();
		Book book = new Book(bookName, isbn, aisle, author);
		
		//Add Book Call
		RestAssured.baseURI = "http://216.10.245.166";
		String response = given().log().all().header("Content-Type", "application/json")
				.body(book).when().post("/Library/Addbook.php").then().log().all()
				.assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract().response()
				.asString();
		
		System.out.println(response);
	}
}
