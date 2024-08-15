package com.skillstorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Iterator;
import java.util.Map;

import openconnector.AbstractConnector;
import openconnector.ConnectorException;
import openconnector.Filter;
import openconnector.ObjectNotFoundException;

// our class must extend AbstractConnector from the openconnector library
// you must add the openConnector.jar file to your build path
// this gives us access to various methods required by SailPoint for the connector to function correctly
public class ExampleConnector extends AbstractConnector {
	
	private String host;
	private String username;
	private String password;
	private String authString;
	
	// methods we'll use include testConnection(), iterate(), configure(), provision()
	
	// this method runs once at class initialization
	// can also call to it from other methods if it's not working
	// it's useful for preloading various variables that we might need for multiple other methods
	public void configure() {
		
		// getting values for configuration keys
		host = config.getConfig().get("host").toString();
		username = config.getConfig().get("exampleHostUsername").toString();
		password = config.getConfig().get("exampleHostPassword").toString();
		authString = "Basic " +  Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
	}
	
	// this method is what runs when we click the "Test Connection" button on the app's configuration screen
	// it will register as a successful connection UNLESS we throw a ConnectorException inside of it
	// how we confirm that the connection was successful is up to us
	@Override
	public void testConnection() throws ConnectorException {
		
		try {
			configure(); // calling this to refresh the property values
			URL url = new URL(host + "/user/test"); // creating a URL object with our full path
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // creating a connection from our URL
			connection.setRequestMethod("GET"); // setting the HTTP method type
			connection.setRequestProperty("Authorization", authString); // setting our auth header
			int responseCode = connection.getResponseCode(); // getting the code from the response
			if(responseCode != 200)
				throw new IOException("Response code was not 200!"); // throwing the proper exception if it didn't work
			else {
				// creating a reader so we can go through the content of the response
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				// creating a StringBuffer onto which to tack each additional line from the reader
				StringBuffer sb = new StringBuffer();
				sb.append("Response Code: " + responseCode + ", Content: ");
				
				// a holder String for the current line as it's first being read
				String currentLine;
				
				// going through the reader, getting each line, and tacking it on to our String buffer
				while ((currentLine = reader.readLine()) != null) {
					sb.append(currentLine);
				}
				
				// printing the GET request's contents to our Tomcat console
				System.out.println(sb.toString());
				
				// closing the open reader stream
				reader.close();
				
			}
			
		} catch(IOException e) {
			throw new ConnectorException(e.getMessage()); // wrapping the exception in a ConnectorException to fail the test in SP
		}
		
	}
	
	// this method will eventually return all of our users/accounts from the connected system
	// this is what runs when you aggregate your account
	@Override
	public Iterator<Map<String, Object>> iterate(Filter arg0) throws ConnectorException, UnsupportedOperationException {
		
		return null;
	}

	// this method gets a specific user/account from the connected system
	@Override
	public Map<String, Object> read(String arg0)
			throws ConnectorException, ObjectNotFoundException, UnsupportedOperationException {
		
		return null;
	}

}
