package restAssuredAPITestExample;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamplesFile {

	// @Test
	public void testGet() {

		baseURI = "https://reqres.in/api";

		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel"));

	}

	@Test
	public void testPost() throws IOException {

		// method1
		JSONObject request = new JSONObject();

		request.put("name", "Ramesh");
		request.put("job", "leader");

		System.out.println(request.toJSONString());

		baseURI = "https://reqres.in";

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON)
			.body(request.toJSONString()).
		when().
			post("/api/users").
		then().
			statusCode(201).
			body("name", equalTo("Ramesh")).
			body("job", equalTo("leader")).
			log().all();

	}
	
	@Test
	public void testPost2() throws IOException {

		// method1
//		JSONObject request = new JSONObject();
//
//		request.put("name", "Ramesh");
//		request.put("job", "sr.leader");
//
//		System.out.println(request.toJSONString());

		// method2

		File file = new File("./sampleFile/createUserRequestBody.json");

		if (file.exists())
			System.out.println("  >>  File Exists");

		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

		baseURI = "https://reqres.in";

		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON)
			.body(requestBody).
		when().
			post("/api/users").
		then().
			statusCode(201).
			body("name", equalTo("AmitKumar")).
			body("job", equalTo("leader")).
			log().all();

	}

}
