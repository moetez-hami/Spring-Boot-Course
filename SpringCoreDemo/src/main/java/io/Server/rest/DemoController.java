package io.Server.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.Server.common.Coach;

@RestController
public class DemoController {
	
	//Define a private field for the dependency
	private Coach myCoach;
	
	//private Coach anotherCoach;
	
	
	//Define a constuctor for dependency injection
	
	/*@Autowired
	public DemoController(Coach theCoach) {
		myCoach = theCoach;
	}*/
	
	
	/*@Autowired
	public DemoController(
			@Qualifier("cricketCoach") Coach theCoach,
			@Qualifier("cricketCoach") Coach theAnotherCoach) {
		System.out.println("In constructor: " + getClass().getSimpleName());
		myCoach =theCoach;
		anotherCoach=theAnotherCoach;
	}*/
	
	@Autowired
	public DemoController(
			@Qualifier("aquatic") Coach theCoach){
		System.out.println("In constructor: " + getClass().getSimpleName());
		myCoach =theCoach;
	}
	
	/*@Autowired
	public void setCoach(Coach theCoach) {
		myCoach =theCoach;
	}*/
	
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
	
	/*@GetMapping("/check")
	public String check() {
		return "Comparing beans: myCoach == anotherCoach, "+(myCoach == anotherCoach);
	}*/
	

}
