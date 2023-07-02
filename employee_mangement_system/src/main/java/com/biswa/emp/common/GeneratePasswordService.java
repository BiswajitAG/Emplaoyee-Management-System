package com.biswa.emp.common;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GeneratePasswordService {
	
	public String generatePassword() {
		int length = 6;
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String symble = "@#$*";
		String numbers = "0123456789";
		String values = Capital_chars +symble+ numbers;
		Random rndm_method = new Random();
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return new String(password);
	}

}
