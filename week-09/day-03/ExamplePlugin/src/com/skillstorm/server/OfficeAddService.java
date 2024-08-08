package com.skillstorm.server;

import com.skillstorm.services.OfficeService;

import sailpoint.api.SailPointContext;
import sailpoint.server.BasePluginService;
import sailpoint.tools.GeneralException;

// this class will be a Service Executor
// it describes functionality that will run every time our plugin service cycles
// must extend BasePluginService for this type of class
public class OfficeAddService extends BasePluginService {
	
	// In Honor Of Nate Koroman, 8/8/24 (not dead)
	public static int iterNater = 1;
	
	private boolean autoAdd;
	private int numberToAdd;
	private OfficeService service;
	private String departmentPrefix;
	
	public OfficeAddService() {
		service = new OfficeService(this);
	}
	
	// this override happens each time the service kicks in
	// here we get access to the values from our settings
	@Override
	public void configure(SailPointContext context) {
		// these methods are from the PluginContext
		autoAdd = getSettingBool("autoAdd");
		numberToAdd = getSettingInt("numberToAdd");
		departmentPrefix = getSettingString("departmentPrefix");
	}

	@Override
	public String getPluginName() {
		return "ExamplePlugin";
	}
	
	// this method must be overridden in order to use this type of service functionality
	// this is the method that will run whenever our service cycles
	@Override
	public void execute(SailPointContext context) throws GeneralException {
		addOffices();
	}
	
	// we call this method from execute() to add our Offices (or not!)
	public void addOffices() throws GeneralException {
		if (autoAdd && numberToAdd > 0) {
			if (departmentPrefix == "")
				departmentPrefix = "Department";
			
			for(int i = 0; i < numberToAdd; i++) {
				service.createOffice(departmentPrefix + " " + iterNater + i, "Address " + iterNater + i);
			}
			iterNater++;
		}
	}
	
	

}
