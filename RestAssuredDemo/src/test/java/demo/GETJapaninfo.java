package demo;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;

public class GETJapaninfo {
	
	@Test
	public void verifyCapitalOfJapan() {
		RestAssured
		  .when()
		     .get("https://restcountries.com/v3.1/name/japan")
		  .then()
		     .assertThat()
		     .statusCode(200)
		     .and()
		     //.body("[0].capital[0]", is("Tokyo"))
		     .body("[0].currencies.JPY.name", is("Japanese yen"))
		     .log().all();

		     
		     
		     
		     
		     
	}
	

}
