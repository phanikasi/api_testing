package api_testing;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import global.Base;
import global.Util;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01_get extends Base{
	
	@Test(priority=0)
	void getWeatherDetails()
	{
		logger.info("Started testcase....");
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		RequestSpecification httpRequest = RestAssured.given();
		Response response=httpRequest.request(Method.GET,"/Hyderabad");
		String responseBody=response.getBody().asString();
		logger.info(response.getClass().getName());
		logger.info("Response Body is:" +responseBody);
		int statusCode=response.getStatusCode();
		logger.info("Status code is: "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		String statusLine=response.getStatusLine();
		logger.info("Status line is:"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		logger.info("before assert statement");
	}
	@Test(priority=1)
	void getVerizon()
	{
		logger.info("Getting the verizon site Response");
		String response = Util.getResponse("http://restapi.demoqa.com/utilities/weather/city","/Chennai");
		logger.info("the verizon response:" +response.getClass().getName());
	}
}
