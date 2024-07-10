package com.api.sample;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SampleArray {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fileReader = new FileReader("C:\\Users\\Lenovo\\eclipse-workspace\\APINEW\\src\\test\\resources\\test1.json");
		
		JSONParser jsonParser = new JSONParser();
		
		Object parse = jsonParser.parse(fileReader);
		
		JSONObject jsonObject = (JSONObject) parse;
		
		
		Object obj1 = jsonObject.get("page");
		System.out.println(obj1);
		Object obj2 = jsonObject.get("per_page");
		System.out.println(obj2);
		Object obj3 = jsonObject.get("total");
		System.out.println(obj3);
		Object obj4 = jsonObject.get("total_pages");
		System.out.println(obj4);
		
		
	
		
		Object object = jsonObject.get("data");
		
		JSONArray array = (JSONArray) object;
		
		for(int i=0;i<array.size();i++) {
			Object object2 = array.get(i);
			JSONObject jsonObject1 = (JSONObject) object2;
			Object object3 = jsonObject1.get("id");
			System.out.println(object3);
			JSONObject jsonObject2 = (JSONObject) object2;
			Object object4 = jsonObject2.get("flightName");
			System.out.println(object4);
			JSONObject jsonObject3 = (JSONObject) object2;
			Object object5 = jsonObject3.get("Country");
			System.out.println(object5);
			JSONObject jsonObject4 = (JSONObject) object2;
			Object object6 = jsonObject4.get("Destinations");
			System.out.println(object6);
			JSONObject jsonObject5 = (JSONObject) object2;
			Object object7 = jsonObject5.get("URL");
			System.out.println(object7);
			
			
		}
		
		

		
	}
	
}
