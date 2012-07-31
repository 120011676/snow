package org.qq120011676.snow.springmvc.util;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class MD5Util {

	public static String encoder(String paramString1, String paramString2) {
		Md5PasswordEncoder localMd5PasswordEncoder = new Md5PasswordEncoder();
		return localMd5PasswordEncoder.encodePassword(paramString1,
				paramString2);
	}

	public static String encoder(String paramString) {
		MessageDigestPasswordEncoder localMessageDigestPasswordEncoder = new MessageDigestPasswordEncoder(
				"md5");
		localMessageDigestPasswordEncoder.setEncodeHashAsBase64(false);
		return localMessageDigestPasswordEncoder.encodePassword(paramString,
				null);
	}
}
