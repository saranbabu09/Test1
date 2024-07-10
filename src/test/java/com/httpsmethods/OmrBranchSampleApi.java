package com.httpsmethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OmrBranchSampleApi {
	
	public static void createFlight(String endpoint,String reqBody) {
		RequestSpecification reqSpec;
		
		reqSpec = RestAssured.given();
		
		reqSpec = reqSpec.header("Content-Type","application/json");
		
		reqSpec = reqSpec.body(reqBody);
		
		
		Response response = reqSpec.post(endpoint);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
//		System.out.println(response.asString());
		System.out.println(response.asPrettyString());
		
	}
	public static void updateFlightN(int path,String reqBody) {
		RequestSpecification reqSpec;
		
		reqSpec = RestAssured.given();
		
		reqSpec = reqSpec.header("Content-Type","application/json");
		
		reqSpec = reqSpec.body(reqBody);
		
		
		Response response = reqSpec.put("https://omrbranch.com/api/flight/"+path);
		
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
//		System.out.println(response.asString());
		System.out.println(response.asPrettyString());
		
	}
		
		public static void getSingleFlight(String endpoint) {
			RequestSpecification reqSpec;
			
			reqSpec = RestAssured.given();
			
			reqSpec = reqSpec.header("Content-Type","application/json");
			
			Response response = reqSpec.get(endpoint);
			
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
//			System.out.println(response.asString());
			System.out.println(response.asPrettyString());
			
		}
		
		public static void getListFlights(String endpoint) {
			RequestSpecification reqSpec;
			
			reqSpec = RestAssured.given();
			
			reqSpec = reqSpec.header("Content-Type","application/json");
			
			Response response = reqSpec.get(endpoint);
			
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
//			System.out.println(response.asString());
			System.out.println(response.asPrettyString());
			
		}
		
		

}
