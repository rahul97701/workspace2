package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemo {
	
	@Test
	public void verifyStatusCode() {
		RestAssured
		     .when()
		         .get("https://restcountries.com/v3.1/all")
		     .then()
		         .assertThat()
		             .statusCode(200)
		             .log().all();
		             
	}

}
