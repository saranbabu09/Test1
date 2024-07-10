package com.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Put {
	public static void main(String[] args) {
      RequestSpecification reqSpec;
		
		reqSpec = RestAssured.given();
		
		reqSpec = reqSpec.header("Content-Type","application/json");
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 95,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		
		
		Response response = reqSpec.put("https://omrbranch.com/api/flight/29211");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
//		System.out.println(response.asString());
		System.out.println(response.asPrettyString());
	}

}
