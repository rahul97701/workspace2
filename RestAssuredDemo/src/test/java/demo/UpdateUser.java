package demo;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;

public class UpdateUser {
	
	HashMap<String, String>map = new HashMap<String, String>();
	
	@BeforeMethod
	public void createPayLoad() {
		map.put("name","Batmannn");
		map.put("email", "batman12545@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "public/v2/users/57851";
	}
	
	@Test
	public void updateResource() {
		RestAssured
		 .given()
		   .contentType("application/json")
		     .body(map)
		     .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
		  .when()
		    .put()
		   .then()
		      .statusCode(200)
		      .and()
		        .body("name", is("Batmannn"))
		      .log().all();
		     
		     
		
		
		
		
		
	}

}
