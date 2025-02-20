package com.mc.coffeemanager.domain.discount;

import com.mc.coffeemanager.domain.order.Order;

public class PercentDiscount {

	public static int calDiscount(Order order) {

		int discount = 0;
		PercentDiscountPolicy[] polices = PercentDiscountPolicy.values();
		for (PercentDiscountPolicy e : polices) {
			if (e.checkRange(order)) {
				discount = (int) (order.getOrderPrice() * e.rate());
			}
		}

		return discount;
	}

}