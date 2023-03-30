package Demo1;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POSTRequest {
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPayload() {
		map.put("name", "Sikha Singh");
		map.put("email", "singh.sikhasingh@gmail.com");
		map.put("gender", "female");
		map.put("status", "inactive");
		RestAssured.baseURI = "https://gorest.co.in/";
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

