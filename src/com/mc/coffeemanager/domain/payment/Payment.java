package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.discount.PercentDiscount;
import com.mc.coffeemanager.domain.order.Order;

public class Payment {

	private Order order; // 결제할 주문
	private int paymentPrice; // 결제 금액

	// 생성자: 주문을 받아 결제 객체를 초기화
	public Payment(Order order) {
		super();
		this.order = order; // 주문 설정
		this.paymentPrice = calPaymentPrice(); // 결제 금액 계산
	}

	// 결제 금액을 계산하는 메서드
	private int calPaymentPrice() {
		int discount = PercentDiscount.calDiscount(order); // 할인 금액 계산
		return order.getOrderPrice() - discount; // 주문 가격에서 할인 금액 차감
	}

	// 주문을 반환하는 메서드
	public Order getOrder() {
		return order; // 결제할 주문 반환
	}

	// 결제 금액을 반환하는 메서드
	public int getPaymentPrice() {
		return paymentPrice; // 결제 금액 반환
	}

	// 결제를 진행하는 메서드
	public void proceed() {
		Account account = Account.getInstance(); // Singleton Account 인스턴스 가져오기
		account.registSales(paymentPrice); // 결제 금액을 계좌에 등록
	}

}
