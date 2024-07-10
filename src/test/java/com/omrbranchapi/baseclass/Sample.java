package com.omrbranchapi.baseclass;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Sample extends BaseClass {
	
	String fNo="";
	
	@Test(priority=1,enabled = true)
	public void createFlight() {
		
		
		
		// 1.Header
		addHeader("Content-Type", "application/json");

		// 2.PayLoad
		addReqBody("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		// 3.req type and endpoint
		Response response = addReqType("POST", "https://omrbranch.com/api/flights");

		// 4.Status Code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		
		
		
		

		// 5.response Body
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);
		
		
		JsonPath path = response.jsonPath();
		Object object = path.get("data.id");
		System.out.println(object);
		Integer id = (Integer) object;
		String dest= Integer.toString(id);
		fNo=dest;

	}
    
	
	@Test(priority = 2 , enabled = true)
	public void updateFlightN() {

		addHeader("Content-Type", "application/json");

		addReqBody("{\r\n" + "    \"flightName\": \"AirIndia\",\r\n" + "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 95,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n" + "}");

		Response response = addReqType("PUT", "https://omrbranch.com/api/flight/"+fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
    
    
	@Test(priority = 3 , enabled = true)
	public void updateFlight() {
		addHeader("Content-Type", "application/json");

		addReqBody("{\r\n" + "    \"Destinations\": 81\r\n" + "}");

		Response response = addReqType("PATCH", "https://omrbranch.com/api/flight/"+fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	
  
	@Test(priority = 4 ,enabled=true)
	public void getSingleFlight() {
		addHeader("Content-Type", "application/json");

		Response response = addReqType("GET", "https://omrbranch.com/api/flight/"+fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	
	@Test(priority = 5 , enabled = true)
	public void getListFlights() {
		addHeader("Content-Type", "application/json");

		Response response = addReqType("GET", "https://omrbranch.com/api/flights?page=1");

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	
	@Test(priority = 6 , enabled = true)
	public void deleteFlight() {
		addHeader("Content-Type", "application/json");

		Response response = addReqType("DELETE", "https://omrbranch.com/api/flight/"+fNo);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}
	
	
	
	

}
