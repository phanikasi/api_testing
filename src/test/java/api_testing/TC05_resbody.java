package api_testing;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC05_resbody {
	
	@Test
	void getWeatherDetails()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		JsonPath jsonpath = response.jsonPath();
		System.out.println(jsonpath.get("City"));
		Assert.assertEquals(jsonpath.get("City"), "Hyderabad");
	}
}
				