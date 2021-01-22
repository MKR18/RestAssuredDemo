import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class JsonServerExample {
	
	//@Test
	public void test_get() {
		
		baseURI = "http://localhost:3000/";
		given().
			param("subjectName", "Automation").//similar to http://localhost:3000?name=Automation
			get("/subjects").
		then().
			statusCode(200).
			log().all();
		
	}
	
	//@Test
	public void test_post() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("firstName", "jhon");
		request.put("lastName", "patterd");
		request.put("subjectId", 1);

		given().
		    contentType(ContentType.JSON)	.accept(ContentType.JSON).
		    header("Content-Type", "application/json").
		    body(request.toJSONString()).
		post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
	//@Test
	public void test_patch() {
		
		baseURI = "http://localhost:3000/";
		
		JSONObject request = new JSONObject();
		request.put("lastName", "kennedy");

		given().
		    contentType(ContentType.JSON)	.accept(ContentType.JSON).
		    header("Content-Type", "application/json").
		    body(request.toJSONString()).
		patch("/users/5").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	   //@Test
		public void test_put() {
			
			baseURI = "http://localhost:3000/";
			
			JSONObject request = new JSONObject();
			request.put("firstName", "Marry");
			request.put("lastName", "Jane");
			request.put("subjectId", 1);
			
			given().
			    contentType(ContentType.JSON).accept(ContentType.JSON).
			    header("Content-Type", "application/json").
			    body(request.toJSONString()).
			put("/users/5").
			then().
				statusCode(200).
				log().all();
			
		}
	
	@Test
	public void test_delete() {
		baseURI = "http://localhost:3000/";

		when().
		delete("/users/5").
		then().
		statusCode(200).
		log().all();
	}
		
}
