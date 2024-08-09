package com.skillstorm.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.skillstorm.services.IdentityService;

import sailpoint.rest.plugin.AllowAll;
import sailpoint.rest.plugin.BasePluginResource;
import sailpoint.tools.GeneralException;

@Path("identity")
public class IdentityResource extends BasePluginResource {
	
	public IdentityService service() {
		return new IdentityService(this);
	}

	@Override
	public String getPluginName() {
		return "ExamplePlugin";
	}
	
	@GET
	@Path("getAll")
	@AllowAll
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<String, String>> getAllIdentities() throws GeneralException {
		return service().getAllIdentities();
	}
	
	@GET
	@Path("get/{id}")
	@AllowAll
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> getIdentityById(@PathParam("id") String id) throws GeneralException {
		return service().getIdentityById(id);
	}
	
	@PUT
	@Path("update/{id}")
	@AllowAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> updateIdentityFirstname(@PathParam("id") String id, Map<String, String> body) throws GeneralException {
		return service().udpateIdentityFirstname(id, body.get("firstname"));
	}
	

}











