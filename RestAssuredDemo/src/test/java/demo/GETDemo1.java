package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemo1 {
	
	@Test
	public void verifyStatusCode() {
		RestAssured
		     .when()
		         .get("https://fakestoreapi.com/products?limit=5")
		     .then()
		         .assertThat()
		             .statusCode(200)
		             .log().all();
		             

}
}
