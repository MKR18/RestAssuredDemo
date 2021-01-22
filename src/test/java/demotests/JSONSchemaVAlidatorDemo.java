package demotests;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JSONSchemaVAlidatorDemo {
	
	@Test
	public void schemaValidate() {
		
		 baseURI = "https://reqres.in/";
			given().
				get("api/users?page=2").
			then().
				assertThat().
				body(matchesJsonSchemaInClasspath("schema.json"));
	}

}
