package com.training.aopdemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.training.aopdemo.dao.AccountDAO;
import com.training.aopdemo.dao.MembershipDAO;
import com.training.aopdemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {
		return runner-> {
			 //demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficFortuneService);
			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
		// TODO Auto-generated method stub
		
System.out.println("\nMainProgram: demoTheAroundAdviceRethrowException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire=true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
		// TODO Auto-generated method stub
		
		System.out.println("\nMainProgram: demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune()");
		
		boolean tripWire=true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		// TODO Auto-generated method stub
		
		System.out.println("\nMainProgram: demoTheAroundAdvice");
		
		System.out.println("Calling getFortune()");
		String data = theTrafficFortuneService.getFortune();
		System.out.println("\nMy fortune is: " + data);
		System.out.println("Finished");
		
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		
		// call method to find the accounts
		List<Account> theAccounts = null;
		try{
			// add a boolean flag to simulate exceptions
			boolean tripWire = false;
			theAccounts = theAccountDAO.findAccounts(tripWire);
		}catch(Exception exc) {
			System.out.println("\n\nMain Program: ... caught exception: " + exc);
		}
		
		
		// display the accounts
		System.out.println("\n\nMainPraogram: demoTheAfterAdvice");
		System.out.println("---------");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		
		// call method to find the accounts
				List<Account> theAccounts = null;
				try{
					// add a boolean flag to simulate exceptions
					boolean tripWire = true;
					theAccounts = theAccountDAO.findAccounts(tripWire);
				}catch(Exception exc) {
					System.out.println("\n\nMain Program: ... caught exception: " + exc);
				}
				
				
				// display the accounts
				System.out.println("\n\nMainPraogram: demoTheAfterThrowingAdvice");
				System.out.println("---------");
				
				System.out.println(theAccounts);
				System.out.println("\n");
		
	}

	private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {
		// TODO Auto-generated method stub
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\nMainPraogram: demoTheAfterReturningAdvice");
		System.out.println("---------");
		
		System.out.println(theAccounts);
		System.out.println("\n");
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO ) {
		// TODO Auto-generated method stub
		
		// call the business method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String serviceCode = theAccountDAO.getServiceCode();
		
		
		// call the membership business method 
		//theMembershipDAO.addAccount();
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		
		
	}

}
