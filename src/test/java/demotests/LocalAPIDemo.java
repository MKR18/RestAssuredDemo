package demotests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class LocalAPIDemo {
	
	//@Test
	public void get() {
		//to start json server in terminal "json-server --watch db.json"
		baseURI = "http://localhost:3000";
		
		given().
			get("/users")
		.then()
			.statusCode(200)
			.log().all();	
	}
	
	
	//@Test
	public void post() {
		JSONObject request  = new JSONObject();
		request.put("firstName", "Geetha");
		request.put("lastName", "Kumar");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
			
	}
	
	//@Test
	public void put() {
		JSONObject request  = new JSONObject();
		request.put("firstName", "Geetha");
		request.put("lastName", "Hegade");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/16")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	//@Test
	public void patch() {
		JSONObject request  = new JSONObject();
		request.put("firstName", "KUmari");
		request.put("lastName", "Hegade");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/16")
		.then()
			.statusCode(200)
			.log().all();
			
	}

	
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/16")
		.then()
			.statusCode(200)
			.log().all();
			
	}
}
