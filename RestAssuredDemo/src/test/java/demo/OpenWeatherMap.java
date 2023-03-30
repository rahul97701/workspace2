package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class OpenWeatherMap {
	
	@Test
	public void getWeatherInfo() {
		RestAssured
		    .given()
		         .param("q", "london")
		         .param("appid", "fc6710e4e544cdc2d7960fe4ea787652")
		     .when()
		          .get("https://api.openweathermap.org/data/2.5/weather")
		     .then()
		           .statusCode(200)
		           .log().all();
		           
	}  

}
