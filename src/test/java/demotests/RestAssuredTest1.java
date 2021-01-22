package demotests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
public class RestAssuredTest1 {
	
	@Test
	public void test_1() {
		 baseURI = "https://reqres.in/";
		Response response = get("api/users?page=2");
		// log.debug("opening webiste");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getContentType());
		System.out.println(response.getSessionId());
		System.out.println(response.getBody().asString());
		System.out.println(response.time());

		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test
	public void test_2() {
		 baseURI = "https://reqres.in/";
		 
		 when().
		 	get("api/users?page=2").
		 then().
		 	statusCode(200);
		 	
		
	}
	
	@Test
	public void test_3() {
		 baseURI = "https://reqres.in/";
		 
		 when().
		 	get("api/users?page=2").
		 then().
		 	statusCode(200).
		 	body("data[1].id", equalTo(8))
		 	.body("data.id", hasItems(10, 11))
		 	.log().all();
		 	
		
	}
	

}
