package demo;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CREATEResource {

	HashMap<String, String>map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPOSTData() {
		map.put("name", "Batman");
		map.put("email", "batman12545@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";
		
	}
	
	@Test
	public void createResource() {
		RestAssured
		    .given()
		      .contentType("application/json")
		      .body(map)
		      .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
		
		      .when()
		        .post()
		        .then()
		        .statusCode(201)
		        .log().all();
		
	}
}
