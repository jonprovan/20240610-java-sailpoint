package com.skillstorm.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoContributor implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		// you would grab specific info for your app
		// (ie. a database call or two, read system env properties)
		
		Map<String, Object> details = new HashMap<>();
		int[] nums = {1, 2, 3};
		details.put("hello", "world");
		details.put("bob", nums);
		builder.withDetails(details);
	}

}
