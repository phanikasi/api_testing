//package api_testing;
//
//import org.testng.annotations.Test;
//import org.testng.Assert;
//import io.restassured.RestAssured;
//import io.restassured.authentication.PreemptiveBasicAuthScheme;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//public class TC06_auth {
//	
//	@Test
//	void getWeatherDetails()
//	{
//		RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
//		PreemptiveBasicAuthScheme authScheme = PreemptiveBasicAuthScheme();
//		authScheme.setUserName(arg0);
//		authScheme.setPassword(arg0);
//		RestAssured.authentication = authScheme;
//		
//		RequestSpecification httpRequest = RestAssured.given();
//		
//		Response response=httpRequest.request(Method.GET,"/");
//		
//		String responseBody=response.getBody().asString();
//		System.out.println("Response Body is:" +responseBody);
//		
//		int statusCode=response.getStatusCode();
//		System.out.println("Status code is: "+statusCode);
//		Assert.assertEquals(statusCode, 200);
//	}