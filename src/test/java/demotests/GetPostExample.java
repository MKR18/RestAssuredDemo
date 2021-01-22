package demotests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetPostExample {

	
	//@Test
	public void getRequest() {
		baseURI = "https://reqres.in/";
		
		given().
			get("api/users?page=2").
		then().
			statusCode(200).log().all();
		
	}

	@Test
	public void postRequest() {
		JSONObject request=new JSONObject();
		request.put("name", "monisha");
	    request.put("job", "TestEngineer");
	
	   System.out.println(request);
	   System.out.println(request.toJSONString());
	
		baseURI = "https://reqres.in/";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("api/users").
		then().
			statusCode(201).log().all();
		
	}
}
