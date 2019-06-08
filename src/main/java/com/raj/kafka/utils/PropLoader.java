/**
 * 
 */
package com.raj.kafka.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Rajendar
 *
 */
public class PropLoader {

	/**
	 * 
	 */
	private PropLoader() {
	}

	public static Properties loadProperties(final String propFileName) {
		try(InputStream input =ClassLoader.getSystemClassLoader().getResourceAsStream(propFileName+".properties")){

			Properties properties = new Properties();
			properties.load(input);
			return properties;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
