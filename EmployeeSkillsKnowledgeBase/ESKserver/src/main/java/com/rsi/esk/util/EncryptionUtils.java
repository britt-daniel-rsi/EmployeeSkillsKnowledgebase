package com.rsi.esk.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtils {
	public static byte[] SHA1(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException  { 
	    MessageDigest md = MessageDigest.getInstance("SHA-1");
	    byte[] sha1hash = new byte[40];
	    md.update(text.getBytes());
	    sha1hash = md.digest();
	    return sha1hash;
	} 
	public static String bytesToHex(byte[] b) {
	      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	      StringBuffer buf = new StringBuffer();
	      for (int j=0; j<b.length; j++) {
	         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	         buf.append(hexDigit[b[j] & 0x0f]);
	      }
	      return buf.toString();
	   }
}
