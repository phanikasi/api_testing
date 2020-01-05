package api_testing;
import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import global.Base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Crud_operations extends Base {
	
	final static String ROOT_URI = "https://reqres.in";
	final static String ROOT_URI1 = "http://dummy.restapiexample.com";
	final static String REST_URI ="http://restapi.demoqa.com/customer";

	@Test
	public void get_weather() {
		Response response = given()
		.param("page",1)
		.when()
		.get(ROOT_URI +"/api/user");
		logger.info("REsponse_body:"+ response.body().prettyPrint());
	}
	@Test
	public void post_data() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		JSONObject json1 = new JSONObject(); 
	    json1.put("name","kasirao");
	    json1.put("salary",21000); 
	    json1.put("age",55);  
		Response res = given()
		.body(json1.toString())
		.when()
		.post("/create")
		.then().statusCode(200)
		.extract().response();
		logger.info("Response_body is:"+ res.asString());	
		logger.info("user created successfully"+json1.toJSONString());
	}
	
	@Test
	public void delete_data() {
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		Response res = given()
		.when()
		.delete("/delete/59586")
		.then().statusCode(200)
		.extract().response();
		logger.info("Delete_Response_body:"+ res.asString());
	}
	
	@Test
	public void put_data() {
	RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	JSONObject json1 = new JSONObject(); 
    json1.put("name","kprphani");
    json1.put("salary",38000); 
    json1.put("age",30);  
		Response res = given()
		.when()
		.body(json1)
		.put("/update/59721")
		.then().statusCode(200)
		.extract().response();
		logger.info("update_Response_body:"+ res.asString());
	}

}
