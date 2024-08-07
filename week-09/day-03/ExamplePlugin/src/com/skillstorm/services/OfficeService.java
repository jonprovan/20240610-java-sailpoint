package com.skillstorm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skillstorm.models.Office;

import sailpoint.plugin.PluginBaseHelper;
import sailpoint.plugin.PluginContext;
import sailpoint.tools.GeneralException;
import sailpoint.tools.IOUtil;

// a service class in IIQ functions as both a repo AND a service in the Spring sense
// we'll be including any application logic
// AND, we'll be writing out queries and executing them on the database
// this has to be done more manually than with Spring
// so, we'll be grabbing the connection and preparing database "statements"
public class OfficeService {
	
	// a type that gives us access to the overall context of this particular plugin
	private PluginContext pluginContext;
	
	// this constructor is handled by the system and automatically fills in our context
	public OfficeService(PluginContext pluginContext) {
		this.pluginContext = pluginContext;
	}
	
	// GeneralException is SailPoint's top-level Exception that the others inherit from
	public List<Office> getAllOffices() throws GeneralException {
		
		// we have to manually set up our connection and statement
		// these are resources like a InputStream that need to be closed at the end
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			
			// using our context to get a connection specifically to the plugin database
			connection = pluginContext.getConnection();
			
			// this prepares our statement and requires our connection and our custom query text
			statement = PluginBaseHelper.prepareStatement(connection, "SELECT * FROM ep_plugin_office");
			
			// the results of the query get stored in an open-ended ResultSet (all the rows and columns returned)
			ResultSet result = statement.executeQuery();
			
			// a list to hold our Offices
			List<Office> offices = new ArrayList<>();
			
			// going through our ResultSet to grab each Office and format it as an Office
			while(result.next()) {
				offices.add(new Office(result.getInt("id"), 
									   result.getString("department"), 
									   result.getString("address")));
			}
			
			return offices;
			
		} catch(SQLException e) {
			// embedding our specific Exception within a general one
			throw new GeneralException(e);
		} finally {
			// closing our open resources
			IOUtil.closeQuietly(statement);
			IOUtil.closeQuietly(connection);
		}
		
	}
	
	// a post endpoint for creating a new office
	public Office createOffice(String department, String address) throws GeneralException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = pluginContext.getConnection();
			statement = PluginBaseHelper.prepareStatement(connection, "INSERT INTO ep_plugin_office (department, address) "
																	+ "VALUES (?, ?)", department, address);
			
			// the line to execute the statement is different for any non-GET request
			statement.executeUpdate();
			
			return getOfficeByDepartment(department);
			
		} catch(SQLException e) {
			throw new GeneralException(e);
		} finally {
			IOUtil.closeQuietly(statement);
			IOUtil.closeQuietly(connection);
		}
		
	}
	
	// a GET endpoint for retrieving an office via department
	public Office getOfficeByDepartment(String department) throws GeneralException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = pluginContext.getConnection();
			statement = PluginBaseHelper.prepareStatement(connection, "SELECT * FROM ep_plugin_office WHERE department = ?", department);
			
			ResultSet result = statement.executeQuery();
			
			result.next();
			
			return new Office(result.getInt("id"), 
					   		  result.getString("department"), 
					   		  result.getString("address"));
			
		} catch(SQLException e) {
			throw new GeneralException(e);
		} finally {
			IOUtil.closeQuietly(statement);
			IOUtil.closeQuietly(connection);
		}
		
	}

}









