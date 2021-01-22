import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;


public class Test_post {
	
	//@Test
	void test_01_post() {
		
//		Map<String,Object> map = new HashMap<>();
//		map.put("name", "monisha");
//		map.put("job", "teacher");
		
//		System.out.println(map);

//		JSONObject request = new JSONObject(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "monisha");
		request.put("job", "teacher");
		
		System.out.println(request.toJSONString());
		
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
		 statusCode(201).log().all();
		
		
}

	//@Test
	void test_01_put() {
		
		JSONObject request = new JSONObject();
		request.put("name", "monisha");
		request.put("job", "teacher");
		
		System.out.println(request.toJSONString());
		
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
		 statusCode(200).log().all();
		
		
}
	
	//@Test
	void test_patch() {
		
		JSONObject request = new JSONObject();
		request.put("name", "monisha");
		request.put("job", "teacher");
		
		System.out.println(request.toJSONString());
		
		given().
			header("content-Type", "application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("https://reqres.in/api/users/2").
		then().
		 statusCode(200).log().all();
	}
	
	@Test
	public void test_delete() {
		given().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).log().all();
	}
		
		
}


