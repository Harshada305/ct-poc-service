package com.cpt.payments.service;

import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.util.HmacSha256Generator;
import com.google.gson.Gson;

public class TestService {

	//Scret Key
	private String secretKey="ecom-ct-secret123";
	
	public int validateAndProcess(AddRequest req)
	{
	
		//Request
		Gson gson=new Gson();
		
		String jsonRequest=gson.toJson(req);
		System.out.println("jsonRequest input String: "+jsonRequest);
		
		String generatedSig=HmacSha256Generator.generateSignature(secretKey, jsonRequest);
		
		System.out.println("generatedSig:"+generatedSig);
		return -1;
		
	}
}
