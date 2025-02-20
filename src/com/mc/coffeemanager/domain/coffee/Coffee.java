package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.purchase.Purchase;

public class Coffee {

	private String name;
	private int price;
	private int purchasePrice;
	private int stock;
	private int safetyStock;
	private int salesCnt;

	public Coffee(String name, int price, int purchasePrice, int stock, int safetyStock) {
		super();
		this.name = name;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.stock = stock;
		this.safetyStock = safetyStock;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getStock() {
		return stock;
	}

	public int getSafetyStock() {
		return safetyStock;
	}

	public int getSalesCnt() {
		return salesCnt;
	}

	public void provide(int orderCnt) {
		// 주문수량만큼 재고를 차감하고
		// 누적판매량에 주문수량만큼 더해주는 것
		deductStock(orderCnt);
		addSalesCnt(orderCnt);
	}

	private void addSalesCnt(int orderCnt) {
		salesCnt += orderCnt;
	}

	private void deductStock(int orderCnt) {
		stock -= orderCnt;
		
		if(stock < safetyStock) {
			int purchaseCnt = safetyStock * 2;
			Purchase purchase = new Purchase(this, purchaseCnt);
			purchase.proceed();
		}
	}

	public void addStock(int cnt) {
		stock += cnt;
	}
	
	public boolean isSeason() {
		return true;
	}

}