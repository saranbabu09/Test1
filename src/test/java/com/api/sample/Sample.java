package com.api.sample;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Sample {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fileReader = new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\APINEW\\src\\test\\resources\\test.json");
		
		JSONParser jsonParser = new JSONParser();
		
		Object parse = jsonParser.parse(fileReader);
		
		JSONObject jsonObject = (JSONObject) parse;
		Object object = jsonObject.get("data");
		Object object8 = jsonObject.get("support");
		
		JSONObject jsonObject1 = (JSONObject) object;
		Object object1 = jsonObject1.get("id");
		JSONObject jsonObject2 = (JSONObject) object;
		Object object2 = jsonObject2.get("flightName");
		JSONObject jsonObject3 = (JSONObject) object;
		Object object3 = jsonObject3.get("Country");
		JSONObject jsonObject4 = (JSONObject) object;
		Object object4 = jsonObject4.get("Destinations");
		JSONObject jsonObject5 = (JSONObject) object;
		Object object5 = jsonObject5.get("URL");
		JSONObject jsonObject6 = (JSONObject) object;
		Object object6 = jsonObject6.get("Created_Date");
		JSONObject jsonObject7 = (JSONObject) object;
		Object object7 = jsonObject7.get("Updated_Date");
		
		JSONObject jsonObject9 = (JSONObject) object8;
		Object object9 = jsonObject9.get("url");
		JSONObject jsonObject10 = (JSONObject) object8;
		Object object10 = jsonObject10.get("text");
		
		
		
		
		
		
		System.out.println(object1);
		System.out.println(object2);
		System.out.println(object3);
		System.out.println(object4);
		System.out.println(object5);
		System.out.println(object6);
		System.out.println(object7);
		
		System.out.println(object9);
		System.out.println(object10);
		
		
		
		
		
	}

}
