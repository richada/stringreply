package com.beta.replyservice;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Override
	public String parseMessageWithRules(String msg) {
		if(msg.contains("-")) {
			String commands = msg.split("-")[0];
			String message = msg.split("-")[1];
			for(char c : commands.toCharArray()) {
				switch(c) {
				case '1':{
					message = reverseString(message);
				}break;
				case '2':{
					message = encryptMD5(message);
				}break;
				default:
					break;
				}
			}
			return message;
		}else {
			return msg;
		}
	}

	
	private String reverseString(String input) {
		StringBuilder reversed = new StringBuilder(input).reverse();
		return reversed.toString();
	}
	private String encryptMD5(String input) {
		try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            
            // Get the hash's bytes
            byte[] messageDigest = md.digest(input.getBytes());
            
            // Convert byte array to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    sb.append('0');
                }
                sb.append(hex);
            }
            String hashed = sb.toString();
            System.out.println("MD5 Hash: " + hashed);
            return hashed;
        } catch (NoSuchAlgorithmException e) {
            System.out.println("MD5 algorithm not found.");
            return null;
        }
	}
}
