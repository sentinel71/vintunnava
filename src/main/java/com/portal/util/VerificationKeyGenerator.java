package com.portal.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
//import org.apache.commons.codec.binary.Base64;

public class VerificationKeyGenerator {

	public static String generateKey(String data){
		MessageDigest mda=null;
		try {
			mda = MessageDigest.getInstance("SHA-512");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
		byte [] digesta = mda.digest(data.getBytes());
		return new String(Hex.encodeHex(digesta));
		
	}
}
