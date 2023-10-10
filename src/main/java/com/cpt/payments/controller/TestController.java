package com.cpt.payments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.pojo.AddRequest;
import com.cpt.payments.pojo.AddResponse;
import com.cpt.payments.service.TestService;




@RestController
@RequestMapping("/controller")
public class TestController {
	
	 @GetMapping("/hello")
	    public String sayHello() {
	        return "Hello, World!";
	    }
	 
	 
	 @GetMapping("/addGet")
	 public int addGet(@RequestParam(value="num1") int val1,
			 @RequestParam(value="num2") int val2)
	
	 {
		System.out.println("val1:"+val1+ "|val2:"+val2 );
		
		int result=val1+val2;
		
		System.out.println("Add result: "+result);
		return result;
	 }
	 
	 
	 @PostMapping("/processJSON")
	 @ResponseBody
	 public AddResponse addGet(@RequestBody AddRequest request)
	
	 {
		System.out.println("calling ProcessJSon::request" +request);
		
		int result=request.getNum1()+request.getNum2(); 
		
		AddResponse response=new AddResponse();
		response.setResValue(result);
		
		System.out.println("Add response: "+response);
		return response;
	 }

	 
	 @PostMapping("/validateAndProcess")
	 @ResponseBody
	 public AddResponse validateAndProcess(@RequestBody AddRequest request)
	 {
		 System.out.println("Calling validateAndProcess:"+request);
		 
		 TestService service=new TestService();
		 int res=service.validateAndProcess(request);
		 
		 
		return response;
		 
	 }
	
	
	 
	
	 
	 
	 
	 
	 
	 
	 
	
	
	public String initPayment(String paymentMethod,int amount,String Curr)
	{
		return "Payment Processed Succesfully";
	}

}
