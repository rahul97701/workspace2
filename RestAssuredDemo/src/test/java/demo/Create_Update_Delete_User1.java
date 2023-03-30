package demo;


import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Create_Update_Delete_User1 {
	
	

	

		HashMap<String, String> map = new HashMap<String, String>();
		
		UUID uuid = UUID.randomUUID();
		String id;
		Logger logger;
		
		@BeforeSuite
		public void createPayLoad() {
			logger = Logger.getLogger("LogDemo");
			PropertyConfigurator.configure("log4j.properties");
			logger.setLevel(Level.DEBUG);
			map.put("name", "Buzz Aldrin");
			map.put("email", uuid + "@gmail.com");
			map.put("gender", "female");
			map.put("status", "active");
			RestAssured.baseURI = "https://gorest.co.in/";
			RestAssured.basePath = "/public/v2/users";
			
		}
		
		@Test(priority=0)
		public void createResource() {
			Response response = RestAssured
					.given()
					 .contentType("application/json")
					 .body(map)
				      .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
				      .when()
				       .post()
				       .then()
				         .log().all()
				         .extract().response();
			logger.debug("User created");
			JsonPath jsonPath = response.jsonPath();
			id = jsonPath.get("id").toString();
			System.out.println(id);
		}
		
		@Test(priority=1)
		public void verifyResourceHasBeenCreated() {
			RestAssured
			  .given()
			     .contentType("application/json")
			      .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
	           .when()
	           .get("https://gorest.co.in/public/v2/users/"+id)
	           .then()
	           .assertThat()
	             .statusCode(200)
	             .and()
	               .body("name", is("Buzz Aldrin"));
			logger.debug("User Verified");   
		}
		
		@Test(priority=2)
		public void updateResource() {
			map.put("name", "Buzz Aldrin");
			map.put("email", uuid + "@gmail.com");
			map.put("gender", "female");
			map.put("status", "inactive");
			RestAssured.baseURI = "https://gorest.co.in/";
			RestAssured.basePath = "/public/v2/users/"+id;
			
			RestAssured
			  .given()
			    .contentType("application/json")
			    .body(map)
			      .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
	.when()
	           .put()
	           .then()
	             .statusCode(200)
	               .log().all()
	                 .and()
	                   .body("status", is("inactive"));
			logger.debug("User Updated");   
		}
		
		@Test(priority=3)
		public void deleteResource() {
			
			RestAssured.baseURI = "https://gorest.co.in/";
			RestAssured.basePath = "/public/v2/users/"+id;
			
			RestAssured
			        .given()
			         .contentType("application/json")
				     .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
	                .when()
	                  .delete()
	                 .then()
	                      .statusCode(204);
			logger.debug("User Deleted");   
	                  
				      
		}
		
		
		}



