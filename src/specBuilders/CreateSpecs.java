package specBuilders;
import io.restassured.builder.*;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreateSpecs {

	public static RequestSpecification makeRequestSpec(String baseUrl, ContentType content) {
		
	RequestSpecification req = new RequestSpecBuilder().setBaseUri(baseUrl).setContentType(content).build();
	return req;
	}
	
	public static  ResponseSpecification makeResponseSpec(int statusCode) {
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON)
				.expectBody(null, null)
				.build();
		return res;
	}
}
