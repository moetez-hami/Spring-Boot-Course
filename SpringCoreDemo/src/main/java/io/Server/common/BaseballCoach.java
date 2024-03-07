package io.Server.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{

	public BaseballCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "spend 30 minutes in batting practice";
	}

}
