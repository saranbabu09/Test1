package com.serialization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.omrbranchapi.baseclass.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class Sample extends BaseClass {

	String logtoken;

	String id;
	String id2;
	String stateName;
	String stateId;

	@Test(priority = 4)
	public void addAddress() {
		// 1.Headers

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.payload

		AddUserAddress_Input_Pojo addUserAddress_Input_Pojo = new AddUserAddress_Input_Pojo("Saran", "Babu",
				"9345022745", "TajHotel", 22, 23, 24, "600028", "Mumbai", "Business");

		addReqBody(addUserAddress_Input_Pojo);

		// 3.Req type

		Response response = addReqType("POST", "https://omrbranch.com/api/addUserAddress");

		// verify status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		// verify response body
		AddUserAddress_Output_Pojo addUserAddress_Output_Pojo = response.as(AddUserAddress_Output_Pojo.class);
		String message = addUserAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message, "Address added successfully", "Verify Address added successfully");

		int address_id = addUserAddress_Output_Pojo.getAddress_id();

		id = Integer.toString(address_id);

	}

	@Test(priority = 5)
	public void updateAddress() {

		// 1.Headers

		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);

		// 2.Payload

		UpdateAddressInput_Pojo updateAddressInput_Pojo = new UpdateAddressInput_Pojo(id, "Saran", "Babu", "9345022745",
				"Holiday inn", 22, 23, 24, "600028", "Delhi", "Business");

		addReqBody(updateAddressInput_Pojo);

		// Req Type
		Response response = addReqType("PUT", "https://omrbranch.com/api/updateUserAddress");

		// Status Code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		// Verify Response Body
		UpdateAddressOutput_Pojo updateAddressOutput_Pojo = response.as(UpdateAddressOutput_Pojo.class);
		String message = updateAddressOutput_Pojo.getMessage();
		Assert.assertEquals(message, "Address updated successfully", "Verify Address updated successfully");

	}

	@Test(priority = 6)
	public void getUserAddress() {
		//1.Header
		addHeader("Authorization", "Bearer " + logtoken);
		
		//2.ReqType
		Response response = addReqType("GET","https://omrbranch.com/api/getUserAddress");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		
		GetAddressOutput_Pojo getAddressOutput_Pojo = response.as(GetAddressOutput_Pojo.class);
		Datum datum = getAddressOutput_Pojo.getData().get(0);
		int id = datum.getId();
		id2 = Integer.toString(id);
		

	}
	
	

	@Test(priority=7)
	public void deleteAddress() {
		
		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);

		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
		DeleteAddressInput_Pojo deleteAddressInput_Pojo = new DeleteAddressInput_Pojo(id2);
		addReqBody(deleteAddressInput_Pojo);
		
		Response response = addReqType("DELETE","https://omrbranch.com/api/deleteAddress");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		String message = deleteAddress_Output_Pojo.getMessage();
		Assert.assertEquals(message,"Address deleted successfully","Verify Address deleted successfully");
		

	}
	
	
	@Test(priority=0)
	public void searchProduct() {
		
		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
		SearchProduct_Input_Pojo searchProduct_Input_Pojo = new SearchProduct_Input_Pojo("nuts");
		addReqBody(searchProduct_Input_Pojo);
		
		Response response = addReqType("POST", "https://omrbranch.com/api/searchProduct");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		
		SearchProduct_Output_Pojo searchProduct_Output_Pojo = response.as(SearchProduct_Output_Pojo.class);
		ProductDetails productDetails = searchProduct_Output_Pojo.getData().get(0);
		String text = productDetails.getText();
		System.out.println(text);
		
		Assert.assertTrue(text.contains("100% Natural Premium California"), "Verify Product Details");
		
		
		
	}
	
	@Test(priority=1)
	public void stateList() {
		
		addHeader("accept", "application/json");
		
		Response response = addReqType("GET","https://omrbranch.com/api/stateList");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		
		StateList_Output_Pojo stateList_Output_Pojo = response.as(StateList_Output_Pojo.class);
		StateNameId stateNameId = stateList_Output_Pojo.getData().get(34);
		
		
		stateName = stateNameId.getName();
		System.out.println(stateName);
		
		int id3 = stateNameId.getId();
		stateId = Integer.toString(id3);
		
		
		Assert.assertEquals(stateList_Output_Pojo.getMessage(),"OK","Verify Ok message");
		

	}
	
	@Test(priority=2)
	public void cityList() {
		
		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Content-Type", "application/json");
		listHeader.add(h1);
		listHeader.add(h2);
		
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
		CityList_Input_Pojo cityList_Input_Pojo = new CityList_Input_Pojo(stateId);
		addReqBody(cityList_Input_Pojo);
		
		Response response = addReqType("POST","https://omrbranch.com/api/cityList");
		
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		
		CityList_Output_Pojo cityList_Output_Pojo = response.as(CityList_Output_Pojo.class);
		
		Assert.assertEquals(cityList_Output_Pojo.getMessage(), "OK","Verify OK message");
		
		AllCityNames allCityNames = cityList_Output_Pojo.getData().get(414);
		String name = allCityNames.getName();
		System.out.println(name);
		
		
//		ArrayList<AllCityNames> data = cityList_Output_Pojo.getData();
//		
//		for (AllCityNames allCityNames2 : data) {
//			
//			String name2 = allCityNames2.getName();
//			
//			System.out.println(name2);
//			
//		}
		
		

	}
	
	@Test(priority=3)
	public void addProfilePic() {
		
		List<Header> listHeader = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");
		listHeader.add(h1);
		listHeader.add(h2);
		listHeader.add(h3);
		
		Headers headers = new Headers(listHeader);
		addHeaders(headers);
		
        addMultiPartFormData("profile_picture", new File(System.getProperty("user.dir")+"\\src\\test\\resources\\download (1).jpeg"));
        
        Response response = addReqType("POST", "https://omrbranch.com/api/changeProfilePic");
        
        int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");
		
		ProfilePic_Output_Pojo profilePic_Output_Pojo = response.as(ProfilePic_Output_Pojo.class);
		String message = profilePic_Output_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Profile updated Successfully","Verify Profile updated Successfully");
		
	}
	
	

	@Test(priority = -1)
	public void login() {
		// 1.Header
		addHeader("accept", "application/json");

		// 2.Basic Auth
		addBasicAuth("babusaran785@gmail.com", "Saranbabusk@45");

		// 3.Req Type
		Response response = addReqType("POST", "https://omrbranch.com/api/postmanBasicAuthLogin");

		// Status code
		int statusCode = getStatusCode(response);
		System.out.println(statusCode);
		Assert.assertEquals(statusCode, 200, "Verify Status Code");

		// Verify Request Body

		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		String first_name = login_Output_Pojo.getData().getFirst_name();
		Assert.assertEquals(first_name, "Saran", "Verify First Name");

		logtoken = login_Output_Pojo.getData().getLogtoken();

	}

}
