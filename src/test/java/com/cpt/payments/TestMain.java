package com.cpt.payments;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class TestMain {
	  public static void main(String[] args) {
	        String secretKey = "ecom-ct-secret123";
	        String jsonInput = "{\"key1\":\"value1\",\"key2\":\"value2\"}";

	        try {
	            String hmacSignature = generateHmacSignature(secretKey, jsonInput);
	            System.out.println("HMAC Signature: " + hmacSignature);
	        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
	            e.printStackTrace();
	        }
	    }

	    public static String generateHmacSignature(String secretKey, String data)
	            throws NoSuchAlgorithmException, InvalidKeyException {
	        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
	        Mac mac = Mac.getInstance("HmacSHA256");
	        mac.init(secretKeySpec);

	        byte[] hmacBytes = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
	        return Base64.getEncoder().encodeToString(hmacBytes);
	    }

}
