package com.mc.coffeemanager.domain.coffee;

import com.mc.coffeemanager.domain.purchase.Purchase;

public class Coffee {

	private String name;           // 커피 이름
	private int price;            // 판매 가격
	private int purchasePrice;    // 구매 가격
	private int stock;            // 재고 수량
	private int safetyStock;      // 안전 재고 수량
	private int salesCnt;         // 누적 판매 수량

	// 생성자: 커피 객체를 초기화
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

	public void provide(int orderCnt) { // 주문 수량만큼 재고를 차감하고 판매량을 증가시키는 메서드
		// 주문 수량만큼 재고를 차감하고
		// 누적 판매량에 주문 수량만큼 더해줌
		deductStock(orderCnt);
		addSalesCnt(orderCnt);
	}

	private void addSalesCnt(int orderCnt) { // 누적 판매 수량을 증가시키는 메서드
		salesCnt += orderCnt;
	}

	private void deductStock(int orderCnt) { // 재고를 차감하는 메서드
		stock -= orderCnt;

		// 안전 재고보다 적어진 경우, 추가 구매를 진행
		if(stock < safetyStock) {
			int purchaseCnt = safetyStock * 2; // 안전 재고의 2배만큼 구매 수량 설정
			Purchase purchase = new Purchase(this, purchaseCnt); // 구매 객체 생성
			purchase.proceed();            // 구매 진행
		}
	}

	public void addStock(int cnt) {    // 재고를 추가하는 메서드
		stock += cnt;
	}

	public boolean isSeason() {         // 시즌 여부를 확인하는 메서드
		return true;
	}
}
