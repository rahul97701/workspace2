package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteUser {
	
	@Test
	public void deleteResource() {
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "/public/v2/users/57851";
		
		RestAssured
		  .given()
		     .contentType("application/json")
		      .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
	      .when()		
		      .delete()
		    .then()
		       .statusCode(204)
		     .log().all();    
		       
		
		
	}

}
