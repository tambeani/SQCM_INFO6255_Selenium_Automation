package utility;

import java.util.Base64;

public class PasswordEncoder {

	public static String encode(String text) {
		byte[] encodedBytes = Base64.getEncoder().encode(text.getBytes());
		String encoded = encodedBytes.toString();
		return encoded;
	}
	
	public static String decode(String text) {
		byte[] decodeBytes = Base64.getDecoder().decode("MTIxMjFAQEFUYy5SdG4u");
		String decoded = new String(decodeBytes);
		return decoded;
	}

}
