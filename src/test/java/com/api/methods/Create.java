package com.api.methods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Create {
	public static void main(String[] args) {
        RequestSpecification reqSpec;
		
		reqSpec = RestAssured.given();
		
		reqSpec = reqSpec.header("Content-Type","application/json");
		
		reqSpec = reqSpec.body("{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		
		
		Response response = reqSpec.post("https://omrbranch.com/api/flights");
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
//		System.out.println(response.asString());
		System.out.println(response.asPrettyString());
		
	}

}
