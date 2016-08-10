package com.lem.util;

/**
 * 
 * @author ukathinokkula
 *
 */
public class StringUtils {
		
	public static boolean isEmptyOrNull(String str) {
		return str == null || str.trim().length() == 0;
	}

}
