package com.mc.coffeemanager.domain.discount;

import com.mc.coffeemanager.domain.order.Order;

public class PercentDiscount {

	// 주문에 대한 할인 금액을 계산하는 메서드
	public static int calDiscount(Order order) {
		int discount = 0; // 초기 할인 금액
		PercentDiscountPolicy[] polices = PercentDiscountPolicy.values(); // 모든 할인 정책을 가져옴

		// 각 할인 정책을 순회
		for (PercentDiscountPolicy e : polices) {
			// 현재 정책이 주문 범위에 해당하는지 확인
			if (e.checkRange(order)) {
				// 해당 정책의 비율에 따라 할인 금액 계산
				discount = (int) (order.getOrderPrice() * e.rate()); // 할인 금액 계산
			}
		}

		return discount; // 계산된 할인 금액 반환
	}

}
