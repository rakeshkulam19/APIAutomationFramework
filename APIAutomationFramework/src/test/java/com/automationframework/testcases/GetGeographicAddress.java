package com.automationframework.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automationframework.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GetGeographicAddress extends BaseTest {
	
	@BeforeClass
	void getAllAddress() throws InterruptedException
	{
		logger.info("*********Started 1st TestCase**********");
		
		RestAssured.baseURI="http://172.19.107.20:19180";
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET, "/hargray_esb_api/geographicAddress");
		
		Thread.sleep(3000);
	}
	
	
	@Test
	void checkResponseBody(){
		
		logger.info("*********Checking response body**********");
		
		String responseBody=response.getBody().asString();
		logger.info("Response Body is " +responseBody );
		Assert.assertTrue(responseBody!=null);
		
	}
	
	
	@Test
	void checkStatusCode(){
		
		logger.info("*********Checking status code**********");
		
		int statusCode=response.getStatusCode();
		logger.info("Status code is "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}

	
	
	
}
