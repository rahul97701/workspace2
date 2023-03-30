package Demo1;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETRequest {
	
	@Test
	public void verifyStatusCode() {
		RestAssured
		     .when()
		         .get("https://gorest.co.in/public/v2/users/479/")
		     .then()
		         .assertThat()
		             .statusCode(200)
		             .log().all();
		             
	}

}
