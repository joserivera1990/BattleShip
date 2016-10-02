package com.josecode.battleship.read;

import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class ReadProperties {

	 public String[] getFileWithUtil(String fileName) {
		    String[] parameters = null;
			ClassLoader classLoader = getClass().getClassLoader();
			try {
			    String result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
			    parameters = result.split("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return parameters;
		  }

}
