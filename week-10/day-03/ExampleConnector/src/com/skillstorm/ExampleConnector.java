package com.skillstorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import openconnector.AbstractConnector;
import openconnector.ConnectorException;
import openconnector.Filter;
import openconnector.Item;
import openconnector.ObjectNotFoundException;
import openconnector.Result;

// our class must extend AbstractConnector from the openconnector library
// you must add the openConnector.jar file to your build path
// this gives us access to various methods required by SailPoint for the connector to function correctly
public class ExampleConnector extends AbstractConnector {
	
	private String host;
	private String username;
	private String password;
	private String authString;
	
	// methods we'll use include testConnection(), iterate(), configure(), create()
	
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
	// each Map<String, Object> is one account
	@Override
	public Iterator<Map<String, Object>> iterate(Filter filter) throws ConnectorException, UnsupportedOperationException {
		
		try {
			configure();
			URL url = new URL(host + "/user");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", authString);
			
			if(connection.getResponseCode() != 200)
				throw new IOException("Response code was not 200!");
			else {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String currentLine;
				while ((currentLine = reader.readLine()) != null) {
					sb.append(currentLine);
				}
				
				String response = sb.toString();
				
				System.out.println(response);
				
				// using ObjectMapper to extract the JSON objects from the above string
				ObjectMapper mapper = new ObjectMapper();
				
				// mapping our string JSON results to the type we want for our eventual iterator
				List<Map<String, Object>> mappedObjects = mapper.readValue(response, new TypeReference<List<Map<String, Object>>>(){});
				
				// we have to turn the list of Permission objects into a list of Strings with their names only
				for (Map<String, Object> user : mappedObjects) {
					
					List<String> stringPermissions = new LinkedList<>();
					
					for (Map<String, Object> permission : ((List<Map<String, Object>>)user.get("permission"))) {
						stringPermissions.add(permission.get("name").toString());
					}
					
					user.put("permission", stringPermissions);
					
				}
				
				// turning our mapped objects into an iterator we can return
				Iterator<Map<String, Object>> iterator = mappedObjects.iterator();
				
				reader.close();
				
				return iterator;
			}
			
		} catch(IOException e) {
			throw new ConnectorException(e.getMessage()); // wrapping the exception in a ConnectorException to fail the test in SP
		}
	}
	
	// this method will run whenever we create a new Account in the connected system
	// this happens when we POST an Account to the SCIM API, aiming at this specific application
	@Override
	public Result create(String nativeIdentifier, List<Item> items) {
		
		System.out.println("***************** WHAT'S COMING IN?? *******************");
		System.out.println("nativeIdentifier = " + nativeIdentifier);
		for (Item item : items) {
			System.out.println(item.getName() + ": " + item.getValue());
		}
		
		// a holder Map for the information in our Items
		Map<String, Object> payload = new HashMap<>();
		
		// could use the separate nativeIdentifier to get the username
		// payload.put("username", nativeIdentifier);
		
		// may want to include some overall null checks or replacement values for fields left off, etc.
		
		if (items != null && items.size() != 0)
			for (Item item : items) {
				payload.put(item.getName(), item.getValue());
			}
		
		// we'll need an output byte stream to send the data, so we can create one with ObjectMapper
//		byte[] bytes;
//		try {
//			bytes = new ObjectMapper().writeValueAsString(payload).getBytes();
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
		
		Map<String, Object> responseObject = new HashMap<>();
		
		// making the POST request
		try {
			configure();
			
			// we'll need an output byte stream to send the data, so we can create one with ObjectMapper
			byte[] bytes = new ObjectMapper().writeValueAsString(payload).getBytes();
			
			URL url = new URL(host + "/user");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Authorization", authString);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Length", String.valueOf(bytes.length)); // indicating length of output stream
			connection.setDoOutput(true); // indicating that we will actually be streaming out
			connection.getOutputStream().write(bytes); // writing the output stream itself
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
//			for (String line; (line = reader.readLine()) != null;) {
//				System.out.print(line);
//			}
			
			String response = "";
			String line = "";
			while ((line = reader.readLine()) != null) {
				response += line;
			}
			ObjectMapper mapper = new ObjectMapper();
			responseObject = mapper.readValue(response, new TypeReference<Map<String, Object>>(){});
			
		} catch(IOException e) {
			throw new ConnectorException(e.getMessage());
		}
		
		Result result = new Result();
		result.setObject(responseObject);
		
		return result;
	}
	
	// this method will run whenever we send a PUT request to the SCIM API
	// it will update the portions of our user that have changed
	// we'll have to be careful on the backend side because of what we're getting
	public Result update(String nativeIdentifier, List<Item> items) {
		
		configure();
		
		// creating an object to hold our payload
		Map<String, Object> payload = new HashMap<>();
		
		// this will ONLY include things that have changed from the current values in SailPoint
		for (Item item : items) {
			payload.put(item.getName(), item.getValue());
		}
		
		// manually adding nativeIdentifier, so we have something with which to find the record in the connected app
		payload.put("username", nativeIdentifier);
		
		Map<String, Object> responseObject = new HashMap<>();
		
		try {
			
			byte[] bytes = new ObjectMapper().writeValueAsString(payload).getBytes();
			
			URL url = new URL(host + "/user");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Authorization", authString);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Length", String.valueOf(bytes.length));
			connection.setDoOutput(true);
			connection.getOutputStream().write(bytes);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String response = "";
			String line = "";
			while ((line = reader.readLine()) != null) {
				response += line;
			}
			ObjectMapper mapper = new ObjectMapper();
			responseObject = mapper.readValue(response, new TypeReference<Map<String, Object>>(){});
			
			List<String> newPermissions = new LinkedList<>();
			
			for (Map<String, Object> permission : ((List<Map<String, Object>>)responseObject.get("permission"))) {
				newPermissions.add(permission.get("name").toString());
			}
			
			responseObject.put("permission", newPermissions);
			
		} catch(IOException e) {
			throw new ConnectorException(e.getMessage());
		}
		
		Result result = new Result();
		result.setObject(responseObject);
		return result;
	}
	

	// this method gets a specific user/account from the connected system
	@Override
	public Map<String, Object> read(String arg0)
			throws ConnectorException, ObjectNotFoundException, UnsupportedOperationException {
		
		return null;
	}

}
