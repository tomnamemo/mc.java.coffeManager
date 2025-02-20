package com.mc.coffeemanager.domain.sale;

import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.payment.Payment;

public class Sale {

	// 주문을 받아 결제를 진행하고 Payment 객체를 반환하는 메서드
	public Payment takeOrder(Order order) {
		order.proceed(); // 주문 진행
		Payment payment = new Payment(order); // 결제 객체 생성
		payment.proceed(); // 결제 진행
		return payment; // 결제 객체 반환
	}

}
