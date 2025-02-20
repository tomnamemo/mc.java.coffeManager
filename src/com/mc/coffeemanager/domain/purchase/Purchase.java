package com.mc.coffeemanager.domain.purchase;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;

public class Purchase {

	private Coffee coffee;
	private int purchaseCnt;
	private int purchasePrice;

	public Purchase(Coffee coffee, int purchaseCnt) {
		super();
		this.coffee = coffee;
		this.purchaseCnt = purchaseCnt;
		this.purchasePrice = coffee.getPurchasePrice() * purchaseCnt;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public int getPurchaseCnt() {
		return purchaseCnt;
	}

	public void proceed() {
		Account account = Account.getInstance();
		if(account.registExpenses(purchasePrice)) {
			System.out.println("* system: " + coffee.getName() + "[" +purchaseCnt + "잔]을 매입했습니다.");
			coffee.addStock(purchaseCnt);
			return;
		}
		
		System.out.println("* system : 잔고가 부족해 매입에 실패했습니다.");
	}

}