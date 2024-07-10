package com.api.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SampleWrite {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\APINEW\\src\\test\\resources\\new.json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Datas> data = new ArrayList<>();
		Datas d1= new Datas(3,"AirIndia","India","28","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		Datas d2= new Datas(33,"AirIndia","India","20","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		Datas d3= new Datas(36,"Srilankan AriLines","SriLanka","56","https:\\/\\/en.wikipedia.org\\/wiki\\/Sri_Lanka");
		Datas d4= new Datas(42,"AirIndia.Raj","India","98","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		Datas d5= new Datas(49,"AirIndia","India","88","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		Datas d6= new Datas(59,"AirIndia","India","87","https:\\/\\/en.wikipedia.org\\/wiki\\/Air_India");
		
		data.add(d1);
		data.add(d2);
		data.add(d3);
		data.add(d4);
		data.add(d5);
		data.add(d6);
		
		
		Support support = new Support("https:\\/\\/omrbranch.com", "For Joining Automation Course, Please Contact-Velmurugan 9944152058");
		
		
		Root listFlight = new Root(1,6,7544,1258,data,support);
		
		mapper.writeValue(file, listFlight);

}
	
}
