package com.aeroraven.ifrit.misc;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IfritEncodingConverter {
	protected static String encodeReg = "^(?:[\\x00-\\x7f]|[\\xe0-\\xef][\\x80-\\xbf]{2})+$";
	public static Boolean isUTF8(String string) {
		Pattern encode_pattern = Pattern.compile(encodeReg);
		String unescaped_string = unescape(string);
		Matcher encode_matcher = encode_pattern.matcher(unescaped_string);
		if (encode_matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}
 
	public static boolean isGBK(String string) throws UnsupportedEncodingException {
		if (string.equals(new String(string.getBytes("GBK"))))
			return true;
		else
			return false;
	}
 
	public static String unescape(String src) {
		StringBuffer tmp = new StringBuffer();
		tmp.ensureCapacity(src.length());
		int lastPos = 0, pos = 0;
		char ch;
		while (lastPos < src.length()) {
			pos = src.indexOf("%", lastPos);
			if (pos == lastPos) {
				if (src.charAt(pos + 1) == 'u') {
					ch = (char) Integer.parseInt(src.substring(pos + 2, pos + 6), 16);
					tmp.append(ch);
					lastPos = pos + 6;
				} else {
					ch = (char) Integer.parseInt(src.substring(pos + 1, pos + 3), 16);
					tmp.append(ch);
					lastPos = pos + 3;
				}
			} else {
				if (pos == -1) {
					tmp.append(src.substring(lastPos));
					lastPos = src.length();
				} else {
					tmp.append(src.substring(lastPos, pos));
					lastPos = pos;
				}
			}
		}
		return tmp.toString();
	}
	
	
}
