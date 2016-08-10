package com.lem.util;

import java.io.File;

/**
 * 
 * @author ukathinokkula
 * 
 */
public class FileUtils {

	public static void createDir(String directoryName) {
		File webApps= new File(System.getenv("CATALINA_HOME"),"webapps");

		// if the directory does not exist, create it
		if( webApps.exists()) {
			File tempDir = new File(webApps, directoryName);
			if(!tempDir.exists()) {
				tempDir.mkdir();
			}			
		}
	}
	
}