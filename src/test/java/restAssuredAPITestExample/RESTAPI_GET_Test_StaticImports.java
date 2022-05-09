package restAssuredAPITestExample;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;



public class RESTAPI_GET_Test_StaticImports {
	
	Response resp;
	
	@Test
	public void test_01_listUser() {
	
		//resp =   get("https://reqres.in/api/users?page=2");
		
		//get("/lotto").then().body("lotto.lottoId", equalTo(5));
		
		baseURI = "https://reqres.in";
		
		given().
			
			get("/api/users?page=2").
		then().
			statusCode(200).
			body("data[1].first_name", equalTo("Lindsay")).
			body("data[1].id", equalTo(8)).
			log().all();
			
		
		
	}
	

}
