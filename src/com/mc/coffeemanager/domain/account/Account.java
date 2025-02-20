package com.mc.coffeemanager.domain.account;

import com.mc.coffeemanager.infra.error.NotInitialized;

public class Account {

	private int balance; // 계좌의 잔고
	private int sales;   // 판매 총액
	private int expenses; // 지출 총액

	public static Account INSTANCE; // Singleton 인스턴스

	public static Account getInstance() { // Singleton 인스턴스를 반환하는 메서드
		if(INSTANCE == null) throw new NotInitialized("Account is not initialized"); // 초기화되지 않은 경우 예외 발생
		return INSTANCE; // 인스턴스 반환
	}

	public static Account getInstance(int balance) { // 잔고를 초기화하며 인스턴스를 반환하는 메서드
		if(INSTANCE == null) { // 인스턴스가 초기화되지 않은 경우
			INSTANCE = new Account(balance); // 새 인스턴스 생성
		}
		return INSTANCE; // 인스턴스 반환
	}

	private Account(int balance) { // 생성자: 잔고를 설정
		super();
		this.balance = balance; // 잔고 초기화
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

	public boolean registExpenses(int expenses) { // 지출을 등록하는 메서드
		if(balance < expenses) return false; // 잔고가 지출보다 적으면 false 반환

		balance -= expenses; // 잔고에서 지출 차감
		this.expenses += expenses; // 지출 총액에 추가
		return true; // 성공적으로 등록
	}

	public void registSales(int sales) { // 판매를 등록하는 메서드
		balance += sales; // 잔고에 판매 추가
		this.sales += sales; // 판매 총액에 추가
	}
}
