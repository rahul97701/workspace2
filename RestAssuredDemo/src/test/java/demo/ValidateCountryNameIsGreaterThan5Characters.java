package demo;

import org.junit.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ValidateCountryNameIsGreaterThan5Characters {

	@Test
	public void validateNumberOfCharacters() {
		
		Response response = RestAssured
		      .when()
		        .get("https://restcountries.com/v3.1/name/japan")
		      .then()

               .contentType(ContentType.JSON)
               .extract().response();
		
		JsonPath jsonPath = response.jsonPath();
		Assert.assertTrue(jsonPath.get("[0].name.common").toString().length()>1);
	//Syste.out.println(jsonPath.get("[0].name.common").toString().length());

		response.body().prettyPrint();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
