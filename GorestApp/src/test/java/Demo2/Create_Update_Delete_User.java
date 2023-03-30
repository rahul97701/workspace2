package Demo2;

import java.util.HashMap;
import java.util.UUID;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;





public class Create_Update_Delete_User {
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	UUID uuid = UUID.randomUUID();
	String id;
	Logger logger;
	
	
	@BeforeSuite
	public void CreatePayLoad() {
		logger = logger.getLogger("LogDemo");
		PropertyConfigurator.configure("log4j.propterties");
		logger.setLevel(Level.DEBUG);
		map.put("name", "Mark Zuckerberg");
		map.put("email", uuid + "@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "public/v2/users";
		
		
	}
	
	@Test
	public void createResource() {
		Response response =  RestAssured
				.given()
				  .contentType("application/json")
		        .body(map)
		        .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
		        .when()
		        .post()
		        .then()
		        .log().all()
		        .extract().response();
		        logger.debug("User Created");
		        JsonPath jsonPath = response.jsonPath();
		        id = jsonPath.getString("id").toString();
		        System.out.println(id);
		
	}
	
	public void verifyResource() {
		RestAssured
		.given()
		   .contentType("application/json")
	        .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
           .when()
           .get("https://gorest.co.in/public/v2/users"+id)
           .then()
           .assertThat()
           .statusCode(200)
           .and()
           .body("name", is("Mark Zuckerberg"));
		   logger.debug("User Verified");
		  
	
	}
	
	public void updateResource() {
		map.put("name", "Messi");
		map.put("email", uuid + "@gmail.com");
		map.put("gender", "female");
		map.put("status", "inactive");
		RestAssured.baseURI = "https://gorest.co.in/";
		RestAssured.basePath = "/public/v2/users/"+id;
		
		RestAssured
		  .given()
		  .contentType("application/json")
	        .header("Authorization", "Bearer 2fcc251c50a9d9838ece6c90ae76f55e8af0746b7d3aa0f1c3f50229cbe41211")
	        .when()
	        .put()
	        .then()
	        .statusCode(200)
	        .log().all()
		   .and()
		   .body("name", Is("Messi"));
		   .logger.debug("User Updated");
		
		
	}
	

}
