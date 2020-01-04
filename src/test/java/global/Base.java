package global;

//import java.util.logging.Level;

import org.testng.annotations.BeforeClass;
//import org.testng.log4testng.Logger;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
//import org.apache.logging.log4j.LogManager
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

public class Base {
	
	public static RequestSpecification httprequest;
	public static Response response;
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{
		logger = Logger.getLogger(Logger.class.getName());
		PropertyConfigurator.configure("log4.properties");
		logger.setLevel(Level.DEBUG);
	}
//	public String getRequest(String uri,String param)
//	{
//		
//		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
//		
//		RequestSpecification httpRequest = RestAssured.given();
//		
//		Response response=httpRequest.request(Method.GET,"/Hyderabad");
//		return response.getBody().asString();
//	}

}
