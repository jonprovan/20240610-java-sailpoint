package com.skillstorm.policies;

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.services.OfficeService;

import sailpoint.api.SailPointContext;
import sailpoint.object.Identity;
import sailpoint.object.Policy;
import sailpoint.object.PolicyViolation;
import sailpoint.policy.BasePluginPolicyExecutor;
import sailpoint.tools.GeneralException;

// PolicyExecutors must extend this class to function properly
public class MaximumOfficePolicyExecutor extends BasePluginPolicyExecutor {

	@Override
	public String getPluginName() {
		return "ExamplePlugin";
	}
	
	// this method is what gets executed when the system checks against this policy
	// it must return a List of PolicyViolation objects
	@Override
	public List<PolicyViolation> evaluate(SailPointContext context, Policy policy, Identity identity) throws GeneralException {
		
		// a holder for all violations we're going to return
		List<PolicyViolation> violations = new LinkedList<>();
		
		// getting our service to use to find the number of current offices
		OfficeService service = new OfficeService(this);
		int current = service.countOffices();
		
		// getting the max value that was set when editing the policy itself
		int max = policy.getInt("maxOffices");
		
		if (current <= max) {
			return violations;
		} else {
			// add any violations to the violations list, then return
			violations.add(createViolation(context, policy, identity, current));
			
			return violations;
		}
	}
	
	// this method is here to create a PolicyViolation object that will go into the system
	public PolicyViolation createViolation(SailPointContext context, Policy policy, Identity identity, int current) throws GeneralException {
		// creating an empty PolicyViolation
		PolicyViolation violation = new PolicyViolation();
		
		// adding various properties to it before returning
		violation.setStatus(PolicyViolation.Status.Open);
		violation.setIdentity(identity);
		violation.setPolicy(policy);
		violation.setAlertable(true);
		violation.setOwner(context.getObjectByName(Identity.class, "spadmin"));
		violation.setConstraintName("More than the maximum number of Offices are in the system.");
		violation.setArgument("Current Offices", current);
		
		// packaging in our violation with some context
		// identity and policy are already set above
		return formatViolation(context, identity, policy, null, violation);
	}

}
