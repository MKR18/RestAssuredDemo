import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class Test_Get {
	
	@Test
	void test_01_get() {
		
		given().
			//header("content_type", "application/json").
			//param(parameterName, parameterValues)
		 	get("https://reqres.in/api/users?page=2").
		then().
			statusCode(200).
			body("data.id[0]",equalTo(7)).
			body("data.first_name", hasItems("Michael", "Lindsay", "Tobias"))
			.log().all();
			
			
	}
}
