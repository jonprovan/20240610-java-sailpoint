package com.skillstorm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import sailpoint.api.SailPointContext;
import sailpoint.api.SailPointFactory;
import sailpoint.object.Identity;
import sailpoint.plugin.PluginBaseHelper;
import sailpoint.plugin.PluginContext;
import sailpoint.server.Environment;
import sailpoint.tools.GeneralException;
import sailpoint.tools.IOUtil;

public class IdentityService {
	
	private PluginContext pluginContext;
	
	public IdentityService(PluginContext pluginContext) {
		this.pluginContext = pluginContext;
	}
	
	// getting all Identities using the SailPointContext
	public List<Map<String, String>> getAllIdentities() throws GeneralException {
		
		// can get access to other objects in a couple different ways
		// this way, we use the application's overall context to access objects within it
		SailPointContext sailPointContext = SailPointFactory.getCurrentContext();
		
		// storing all identity objects in a list
		List<Identity> identities = sailPointContext.getObjects(Identity.class);
		// a holder list for identities going out
		List<Map<String, String>> outboundIdentities = new LinkedList<>();
		
		// each object going out will be a map
		for(Identity identity : identities) {
			
			String id = identity.getId();
			String name = identity.getName();
			String firstname = identity.getFirstname();
			Date modified = identity.getModified();
			
			Map<String, String> temp = new HashMap<>();
			
			temp.put("id", id);
			temp.put("name", name);
			temp.put("firstname", firstname);
			temp.put("modified", modified.toString());
			
			outboundIdentities.add(temp);
		}
		
		return outboundIdentities;
		
	}
	
	// get an Identity by id going straight to the database
	public Map<String, String> getIdentityById(String id) throws GeneralException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			// this connection method allows us to have access to the SP DB itself, not the plugin DB
			connection = Environment.getEnvironment().getSpringDataSource().getConnection();
			statement = PluginBaseHelper.prepareStatement(connection, "SELECT * FROM spt_identity WHERE id = ?", id);
			
			ResultSet result = statement.executeQuery();
			
			result.next();
			
			Map<String, String> identity = new HashMap<>();
			
			identity.put("id", result.getString("id"));
			identity.put("name", result.getString("name"));
			identity.put("firstname", result.getString("firstname"));
			identity.put("modified", result.getString("modified"));
			
			return identity;
			
		} catch(SQLException e) {
			throw new GeneralException(e);
		} finally {
			IOUtil.closeQuietly(statement);
			IOUtil.closeQuietly(connection);
		}
		
	}
	
	// editing the firstname field in a record, taking id and new firstname
	public Map<String, String> udpateIdentityFirstname(String id, String firstname) throws GeneralException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = Environment.getEnvironment().getSpringDataSource().getConnection();
			statement = PluginBaseHelper.prepareStatement(connection, "UPDATE spt_identity SET firstname = ? WHERE id = ?", firstname, id);
			
			statement.executeUpdate();
			
			return getIdentityById(id);
			
		} catch(SQLException e) {
			throw new GeneralException(e);
		} finally {
			IOUtil.closeQuietly(statement);
			IOUtil.closeQuietly(connection);
		}
		
	}
}









