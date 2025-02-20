package com.mc.coffeemanager.domain.account;

import com.mc.coffeemanager.infra.error.NotInitialized;

public class Account {

	private int balance;
	private int sales;
	private int expenses;
	
	public static Account INSTANCE;
	
	public static Account getInstance() {
		if(INSTANCE == null) throw new NotInitialized("Account is not initialized");
		return INSTANCE;
	}
	
	public static Account getInstance(int balance) {
		if(INSTANCE == null) {
			INSTANCE = new Account(balance);
		}
		 
		return INSTANCE;
	}

	private Account(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public int getSales() {
		return sales;
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	public boolean registExpenses(int expenses) {
		if(balance < expenses) return false;
		
		balance -= expenses;
		this.expenses += expenses;
		return true;
	}

	public void registSales(int sales) {
		balance += sales;
		this.sales += sales;
	}
	
	


}