package com.intheeast.aspectj.declaringadvice.service;

import java.util.Arrays;
import java.util.List;
import static java.lang.System.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intheeast.aspectj.declaringadvice.annotation.Auditable;
import com.intheeast.aspectj.declaringadvice.dao.AccountDao;
import com.intheeast.aspectj.declaringadvice.model.Account;

@Auditable("accountServiceClass")
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;

	@Override
	public void createAccount(String accountId) {
		out.println("Account Created: " + accountId);
	}

	@Override
	public void deleteAccount(String accountId) {
		out.println("Account Deleted: " + accountId);
	}

	@Override
	public Account getAccount(String id) {

		if (id == null) {
			throw new IllegalArgumentException("Account ID cannot to be null");
		}
		return accountDao.findAccountById(id);
	}

	@Auditable("accountUpdate")
	@Override
	public void updateAccount(Account account) {

		if (account.getBalance() < 0) {
			throw new IllegalArgumentException("Account balance cannot be negative");
		}
		accountDao.updateAccount(account);
	}

	@Override
	public List<Account> findAccounts(String accountHolderNamePattern) {
		out.println("Finding accounts with pattern: " + accountHolderNamePattern);
		return Arrays.asList(new Account("Sungwon Seo"), new Account("Sunghun Seo"));
	}

}
