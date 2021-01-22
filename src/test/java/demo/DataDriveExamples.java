package demo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDriveExamples extends DataForTests{
	
/*	//@DataProvider(name = "dataToPost")
	public Object[][] dataForPost() {  
		
	//	Object[][] data = new Object[2][3];
		
	//	data[0][0] = "Albert";
	//	data[0][1] = "Einstien";
	//	data[0][2] = 2;

	//	data[1][0] = "Thomas";
	//	data[1][1] = "Edison";
	//	data[1][2] = 1;
	//	return data; 
		
		
		return new Object[][]{
			{"Graham", "Bell", 1},
			{"Henry", "ford", 2},
			
		};
		
	}   
*/
	
	
	
	  // @Test(dataProvider = "dataToPost")
		public void test_post(String fistName, String lastName, int subjectId) {
			
			baseURI = "http://localhost:3000/";
			
			JSONObject request = new JSONObject();
			request.put("firstName", fistName);
			request.put("lastName", lastName);
			request.put("subjectId", subjectId);

			given().
			    contentType(ContentType.JSON)	.accept(ContentType.JSON).
			    header("Content-Type", "application/json").
			    body(request.toJSONString()).
			when().    
				post("/users").
			then().
				statusCode(201).
				log().all();
			
		}
	   
	 //  @DataProvider(name = "dataToDelete")
	 //  public Object[] dataForDelete() {
	 //	   return new Object[] {
     //				   5,6,7
	//	   };
	//   }
		
	   
	   //@Test(dataProvider = "dataToDelete")
		//@Test
		public void test_delete(int userId) {
			baseURI = "http://localhost:3000/";

			when().
			delete("/users/"+userId).
			then().
			//statusCode(204).
			log().all();
		}

		
		//used when less number of data or limited data
		@Parameters({"userId"})
		@Test
		public void test_delete_2(int userId) {
			baseURI = "http://localhost:3000/";
			System.out.println("value of userId is "+userId);
			when().
			delete("/users/"+userId).
			then().
			//statusCode(204).
			log().all();
		}


}
