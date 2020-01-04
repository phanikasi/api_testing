package global;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Util extends Base{
	
	public static String getResponse(String uri,String param)
	{
		RestAssured.baseURI = uri;
		httprequest = RestAssured.given();
		response=httprequest.request(Method.GET,param);
		return response.getBody().asString();
	} 

}
