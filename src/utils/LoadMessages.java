package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import myinterfaces.Constant;

/**
 * Loading messages from a file Implemented as a singleton design pattern
 */
public class LoadMessages {

	private Properties prop = null;
	private static LoadMessages loadMessages = null;

	/**
	 * Implemented as a singleton design pattern
	 */
	public static LoadMessages getInstance() {
		if (loadMessages == null) {
			loadMessages = new LoadMessages();
		}
		return loadMessages;
	}

	private LoadMessages() {
		load(Constant.FILE_PROPERTIES);
	}

	/**
	 * Getting a string from priperties
	 */
	public String getProp(String string) {
		return prop.getProperty(string);
	}

	/**
	 * loading properties from file
	 */
	@SuppressWarnings("CallToPrintStackTrace")
	public void load(String filename) {
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(filename)) {
			prop = new Properties();
			if (input == null) {
				System.err.println("Unable to find " + filename);
				return;
			}
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
