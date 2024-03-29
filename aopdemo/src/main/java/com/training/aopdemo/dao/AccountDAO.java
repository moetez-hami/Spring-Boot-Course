package com.training.aopdemo.dao;

import com.training.aopdemo.Account;

public interface AccountDAO {
	
	void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();

}
