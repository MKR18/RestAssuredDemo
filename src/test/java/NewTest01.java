import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class NewTest01 {
	
	
  @Test
  public void test_01() {


	  Response response = RestAssured.get("https://reqres.in/api/users?page=2");
	  System.out.println(response.getStatusCode());
//	  System.out.println(response.get );
	  System.out.println(response.getStatusLine());
	  System.out.println(response.getStatusCode());
	  Assert.assertEquals(response.getStatusCode(), 201);

 }
}
