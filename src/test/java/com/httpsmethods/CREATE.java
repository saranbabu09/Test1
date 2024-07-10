package com.httpsmethods;

public class CREATE extends OmrBranchSampleApi {
	public static void main(String[] args) {
		createFlight("https://omrbranch.com/api/flights", "{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": \"87\",\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
	}
	

}
