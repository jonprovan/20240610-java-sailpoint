package com.skillstorm.rest;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

// BASE URL FOR ALL PLUGIN ENDPOINTS (if hitting them from outside, Postman, etc.
// http://localhost:8080/identityiq/plugin/rest/
// or substitute your server's IP/URL for the first part

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
	
	// an endpoint for getting all Offices
	@GET									// specifies this method will work for GET requests
	@Path("getall")							// specifies a path to tack on to the overall class path, so "OfficePlugin/getall"
	@AllowAll								// specifies that anyone who's logged into IIQ can access this method
	@Produces(MediaType.APPLICATION_JSON)	// specifies what media type will be returned in the body
	// because our service method throws a GeneralException, we have to handle it here
	public List<Office> getAllOffices() throws GeneralException {
		// getting our service using our method, then calling the getAllOffices() method
		return service().getAllOffices();
	}
	
	// an endpoint for creating a new office
	@POST
	@Path("createOne")
	@AllowAll
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	// taking in a generic map here to get the values from our JSON object
	// not in Spring, so can't use @RequestBody in the usual way
	public Office createOffice(Map<String, String> body) throws GeneralException {
		// extracting the values from the map for our parameters
		String department = body.get("department");
		String address = body.get("address");
		
		return service().createOffice(department, address);
	}
	
	// an endpoint for getting via department, using a PathParam
	@GET
	@Path("getByDepartment/{department}")
	@AllowAll
	@Produces(MediaType.APPLICATION_JSON)
	// name in the PathParam annotation matches with whatever's in the path above
	public Office getOfficeByDepartment(@PathParam("department") String department) throws GeneralException {
		return service().getOfficeByDepartment(department);
	}
	
	// an endpoint for deleting an office by ID
	@DELETE
	@Path("deleteById/{id}")
	@AllowAll
	public void deleteOfficeById(@PathParam("id") int id) throws GeneralException {
		service().deleteOfficeById(id);
	}
	
}










