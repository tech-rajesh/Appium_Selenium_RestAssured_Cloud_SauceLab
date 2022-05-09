package restAssuredAPITestExample;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class RESTAPI_GET_Test {
	
	Response resp;
	
	@Test
	public void test_01_listUser() {
	
		resp =   RestAssured.get("https://reqres.in/api/users?page=2");
		
		//Status Code
		System.out.println("Status Code: " + resp.getStatusCode());
		//ResponseTime
		System.out.println("Response Time: " + resp.getTime());
		
		//Header
		System.out.println("Header - Content Type: " + resp.getHeader("Content-Type"));
		System.out.println("Header- Transfer-Encoding: " + resp.getHeader("Transfer-Encoding"));
		
		//Status-line
		System.out.println("Response statusLine: " + resp.getStatusLine());
		
		//Body
		System.out.println("Response body: " + resp.getBody().asPrettyString());
		
	}
	
	@Test(priority = 1)
	public void verifyStatusCode() {
		
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 2)
	public void verifyStatusLine() {
		
		Assert.assertEquals(resp.getStatusLine(), "HTTP/1.1 200 OK");
		
	}
	
	
	@Test(priority = 3)
	public void verifyHeaderContentType() {
		
		Assert.assertTrue(resp.header("Content-Type").contains("json"));
		Assert.assertEquals(resp.header("Content-Type"), "application/json; charset=utf-8");
	}
	

}
