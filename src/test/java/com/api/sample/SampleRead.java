package com.api.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.*;

public class SampleRead {
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		File file = new File("C:\\Users\\Lenovo\\eclipse-workspace\\APINEW\\src\\test\\resources\\test1.json");
		
		ObjectMapper mapper = new ObjectMapper();
		
		Root value = mapper.readValue(file, Root.class);
		
		int page = value.getPage();
		int per_page = value.getPer_page();
		int total = value.getTotal();
		int total_pages = value.getTotal_pages();
		
		System.out.println(page);
		System.out.println(per_page);
		System.out.println(total);
		System.out.println(total_pages);
		
		ArrayList<Datas> arrayList = value.getData();
		
		for (Datas datas : arrayList) {
			System.out.println(datas.getId());
			System.out.println(datas.getFlightName());
			System.out.println(datas.getCountry());
			System.out.println(datas.getDestinations());
			System.out.println(datas.getURL());
			
		}
		
		Support support = value.getSupport();
		System.out.println(support.getUrl());
		System.out.println(support.getText());
			
		
	}

}
