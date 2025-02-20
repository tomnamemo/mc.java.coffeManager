package com.mc.coffeemanager.domain.purchase;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;

public class Purchase {

	private Coffee coffee; // 매입할 커피
	private int purchaseCnt; // 매입 수량
	private int purchasePrice; // 매입 가격

	// 생성자: 커피와 매입 수량을 받아 매입 객체 초기화
	public Purchase(Coffee coffee, int purchaseCnt) {
		super();
		this.coffee = coffee; // 커피 설정
		this.purchaseCnt = purchaseCnt; // 매입 수량 설정
		this.purchasePrice = coffee.getPurchasePrice() * purchaseCnt; // 매입 가격 계산
	}

	// 커피를 반환하는 메서드
	public Coffee getCoffee() {
		return coffee; // 매입할 커피 반환
	}

	// 매입 수량을 반환하는 메서드
	public int getPurchaseCnt() {
		return purchaseCnt; // 매입 수량 반환
	}

	// 매입을 진행하는 메서드
	public void proceed() {
		Account account = Account.getInstance(); // Singleton Account 인스턴스 가져오기
		// 매입 가격을 계좌에 등록하고 성공 여부 확인
		if(account.registExpenses(purchasePrice)) {
			System.out.println("* system: " + coffee.getName() + "[" + purchaseCnt + "잔]을 매입했습니다."); // 매입 성공 메시지
			coffee.addStock(purchaseCnt); // 커피 재고 추가
			return;
		}

		System.out.println("* system: 잔고가 부족해 매입에 실패했습니다."); // 매입 실패 메시지
	}

}
