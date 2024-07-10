package com.omrbranchapi.baseclass;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;
	
	public void addHeaders(Headers header) {
		reqSpec = RestAssured.given().headers(header);
	}

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	
	public void addBasicAuth(String userName,String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
		

	}
	

	public void addReqBody(String payload) {
		reqSpec = reqSpec.body(payload);

	}
	
	public void addReqBody(Object payload) {
		reqSpec = reqSpec.body(payload);

	}
	
	public void addMultiPartFormData(String key,File file) {
		reqSpec = reqSpec.multiPart(key, file);
	}
	
	

	public Response addReqType(String type, String endpoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endpoint);
			break;
		case "POST":
			response = reqSpec.post(endpoint);
			break;
		case "PUT":
			response = reqSpec.put(endpoint);
			break;
		case "PATCH":
			response = reqSpec.patch(endpoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endpoint);
			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		 int statusCode = response.getStatusCode();
		 return statusCode;

	}

	public String getResBodyAsString(Response response) {
		return response.asString();
	}

	public String getResBodyAsPrettyString(Response response) {
		return response.asPrettyString();
	}

}
