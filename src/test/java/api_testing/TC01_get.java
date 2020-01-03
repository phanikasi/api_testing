package api_testing;

import org.testng.annotations.Test;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_get {
	
	@Test
	void getWeatherDetails()
	{
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		String responseBody=response.getBody().asString();
		System.out.println("Response Body is:" +responseBody);
		
		int statusCode=response.getStatusCode();
		System.out.println("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine=response.getStatusLine();
		System.out.println("Status line is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}

}
