package com.training.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{

	/*@Override
	public void addAccount() {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
		
	}*/

	@Override
	public boolean addSillyMember() {
		// TODO Auto-generated method stub
		
		System.out.println(getClass() + " : DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
		return true;
	}

	@Override
	public void goToSleep() {
		// TODO Auto-generated method stub
		
		System.out.println(getClass() + " : I'm going to sleep now...");
		
	}

}
