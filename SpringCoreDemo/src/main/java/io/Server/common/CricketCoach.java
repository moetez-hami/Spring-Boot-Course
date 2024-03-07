package io.Server.common;


//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	//define our init method
	/*@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): "+ getClass().getSimpleName());
	}	
	
	//define our destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In doMyCleanupStuff():"+getClass().getSimpleName());
	}*/
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Pratice fast bowling for 15 minutes ";
	}

}
