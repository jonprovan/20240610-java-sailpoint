package com.skillstorm.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.skillstorm.models.Office;
import com.skillstorm.services.OfficeService;

import sailpoint.rest.plugin.AllowAll;
import sailpoint.rest.plugin.BasePluginResource;
import sailpoint.tools.GeneralException;

// this class is essentially a controller
// it sets up endpoints we can hit internally and/or externally to have access to plugin functionality
// some different annotations than we've seen before, but similar concepts

@Path("OfficePlugin")
public class OfficeResource extends BasePluginResource {

	// this is a required override for the BasePluginResource interface
	@Override
	public String getPluginName() {
		return "OfficePlugin";
	}
	
	// injecting our OfficeService for local use
	private OfficeService service() {
		// putting in this instance as context for the service
		return new OfficeService(this);
	}
	
	// a method for getting all Offices
	@GET									// specifies this method will work for GET requests
	@Path("getall")							// specifies a path to tack on to the overall class path, so "OfficePlugin/getall"
	@AllowAll								// specifies that anyone who's logged into IIQ can access this method
	@Produces(MediaType.APPLICATION_JSON)	// specifies what media type will be returned in the body
	// because our service method throws a GeneralException, we have to handle it here
	public List<Office> getAllOffices() throws GeneralException {
		// getting our service using our method, then calling the getAllOffices() method
		return service().getAllOffices();
	}
	
}










