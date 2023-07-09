package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import myinterfaces.Constants;

public class LoadMessages {
	
	private Properties prop=null;
	private static LoadMessages loadMessages=null;
	
	public static LoadMessages getInstance() {
		if (loadMessages==null) loadMessages=new LoadMessages();
		return loadMessages;
	}
	
	private LoadMessages() {
		load(Constants.fileProperties);
	}

	public String getProp(String string) {
		return prop.getProperty(string);
	}

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
