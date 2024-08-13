package com.skillstorm.policies;

import sailpoint.policy.BasePluginPolicyExecutor;

// PolicyExecutors must extend this class to function properly
public class MaximumOfficePolicyExecutor extends BasePluginPolicyExecutor {

	@Override
	public String getPluginName() {
		return "ExamplePlugin";
	}
	
	// this method is what gets executed when the system checks against this policy
	@Override
	public something evaluate() {
		
	}
	
	// this method is here to create a PolicyViolation object that will go into the system
	public something createViolation() {
		
	}

}
