package demo;

	import java.util.HashMap;

	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import io.restassured.RestAssured;

public class POSTDemo1 {
	
	


		
		HashMap<String, String> map = new HashMap<String, String>();
		
		@BeforeMethod
		public void createPayload() {
			map.put("title", "test product");
			map.put("prcie", "13.5");
			map.put("description", "lorem ipsum set");
			map.put("image", "https://i.pravatar.cc");
			map.put("category", "electronic");
			RestAssured.baseURI = "https://fakestoreapi.com/products";
			//RestAssured.basePath = "/products/1";
			
		}
		
		@Test
		public void createResource() {
			RestAssured
			    .given()
			        .contentType("application/json")
			        .body(map)
			        .when()
			        .post()
			        .then()
			        .statusCode(201)
			        .log().all();
		}

	}



