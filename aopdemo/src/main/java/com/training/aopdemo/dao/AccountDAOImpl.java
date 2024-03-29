package com.training.aopdemo.dao;

import org.springframework.stereotype.Repository;

import com.training.aopdemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount(Account theAccount, boolean vipFlag) {
		// TODO Auto-generated method stub
		System.out.println(getClass() + " : DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}

	@Override
	public boolean doWork() {
		// TODO Auto-generated method stub
		
		System.out.println(getClass() + " : doWork()");
		return false;
	}

}
