package com.omrbranchapi.baseclass;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Swagger extends BaseClass {

	@Test
	private void login() {

		// 1.Header
		addHeader("accept", "application/json");

		// 2.Basic Auth
		addBasicAuth("babusaran785@gmail.com", "Saranbabusk@45");

		// 3.Req Type
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		// Status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		
		//resp body
		
		String resBodyAsPrettyString = getResBodyAsPrettyString(response);
		System.out.println(resBodyAsPrettyString);

	}

}
