package com.mc.coffeemanager.domain.discount;

import com.mc.coffeemanager.domain.order.Order;

// 5000이상 10000원 미만 10% 할인
// 10000이상 20000원 미만 20% 할인
public enum PercentDiscountPolicy {

	LEVEL1(5000, 10000, 0.1), LEVEL2(10000, 20000, 0.2), LEVEL3(20000, 1000000, 0.9);

	private int min;
	private int max;
	private double rate;

	private PercentDiscountPolicy(int min, int max, double rate) {
		this.min = min;
		this.max = max;
		this.rate = rate;
	}

	public boolean checkRange(Order order) {
		return order.getOrderPrice() >= min && order.getOrderPrice() < max;
	}

	public double rate() {
		return rate;
	}

}