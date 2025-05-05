package basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.testng.annotations.Test;

import enums.ApiResources;
import io.restassured.http.ContentType;
import pojo.Book;
import specBuilders.CreateSpecs;
import utils.UniqueGenerator;

public class LearnSpecBuilder {

	@Test
	public void verifyLibraryE2ETests() throws IOException {

		String bookName= UniqueGenerator.getFaker().book().title();
		String isbn = UniqueGenerator.getUniqueString();
		String aisle = Integer.toString(UniqueGenerator.getRandomNumber());
		String author=UniqueGenerator.getFaker().book().author();
		Book book = new Book(bookName, isbn, aisle, author);
		

		given().log().all().spec(CreateSpecs.makeRequestSpec(ApiResources.LibraryManagementBaseUrl.getResource(), ContentType.JSON))
				.body(book).when().post(ApiResources.postBook.getResource()).then().log().all().spec(CreateSpecs.makeResponseSpec(HttpURLConnection.HTTP_OK))
				.assertThat().body("Msg", equalTo("successfully added"));
				
		
		
		
		

	}
}
