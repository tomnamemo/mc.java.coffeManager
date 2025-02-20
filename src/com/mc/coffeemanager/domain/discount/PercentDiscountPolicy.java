package com.mc.coffeemanager.domain.discount;

import com.mc.coffeemanager.domain.order.Order;

// 5000 이상 10000원 미만 10% 할인
// 10000 이상 20000원 미만 20% 할인
public enum PercentDiscountPolicy {

	LEVEL1(5000, 10000, 0.1), // 할인 레벨 1: 5000 이상 10000 미만, 10% 할인
	LEVEL2(10000, 20000, 0.2), // 할인 레벨 2: 10000 이상 20000 미만, 20% 할인
	LEVEL3(20000, 1000000, 0.9); // 할인 레벨 3: 20000 이상, 90% 할인

	private int min; // 최소 주문 금액
	private int max; // 최대 주문 금액
	private double rate; // 할인 비율

	// 생성자: 할인 정책을 초기화
	private PercentDiscountPolicy(int min, int max, double rate) {
		this.min = min; // 최소 금액 설정
		this.max = max; // 최대 금액 설정
		this.rate = rate; // 할인 비율 설정
	}

	// 주문 가격이 정책의 범위에 포함되는지 확인하는 메서드
	public boolean checkRange(Order order) {
		return order.getOrderPrice() >= min && order.getOrderPrice() < max; // 범위 확인
	}

	// 할인 비율을 반환하는 메서드
	public double rate() {
		return rate; // 할인 비율 반환
	}

}
