package com.training.aopdemo.dao;

import java.util.List;

import com.training.aopdemo.Account;

public interface AccountDAO {
	
	// add a new method: findAccount()
	List<Account> findAccounts();
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();

	public String getName();

	public void setName(String name);
	
	public String getServiceCode();

	public void setServiceCode(String serviceCode);

	List<Account> findAccounts(boolean tripWire);
	
	
}
