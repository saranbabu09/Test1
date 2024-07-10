package com.httpsmethods;

public class PUT extends OmrBranchSampleApi{
	public static void main(String[] args) {
		updateFlightN(29087, "{\r\n"
				+ "    \"flightName\": \"AirIndia\",\r\n"
				+ "    \"Country\": \"India\",\r\n"
				+ "    \"Destinations\": 95,\r\n"
				+ "    \"URL\": \"https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India\"\r\n"
				+ "}");
		
	}

}
