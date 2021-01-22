package demotests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

import io.restassured.http.ContentType;

public class XMLSchemaValidation {
	
	@Test
	public void schemaValidation() throws IOException {
		
		File file  = new File("./SoapRequest/Add.xml");
		
		if(file.exists())
			System.out.println("FILE exists");
		
		FileInputStream fis = new FileInputStream(file);
		String requestBody =  IOUtils.toString(fis, "UTF-8");
		
		baseURI = "http://www.dneonline.com/";
		//use freeformatter to validate the xml result 
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).
			log().all().
		and().
			body("//*:AddResult.text()", equalTo("7")).
		and().
			assertThat().body(matchesXsdInClasspath("calculator.xsd"));
		
			
	}

}
