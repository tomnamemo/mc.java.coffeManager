package com.mc.coffeemanager.domain.payment;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.discount.PercentDiscount;
import com.mc.coffeemanager.domain.order.Order;

public class Payment {

	private Order order;
	private int paymentPrice;

	public Payment(Order order) {
		super();
		this.order = order;
		this.paymentPrice = calPaymentPrice();
	}

	private int calPaymentPrice() {
		int discount = PercentDiscount.calDiscount(order);
		return order.getOrderPrice() - discount;
	}

	public Order getOrder() {
		return order;
	}

	public int getPaymentPrice() {
		return paymentPrice;
	}

	public void proceed() {
		Account account = Account.getInstance();
		account.registSales(paymentPrice);
	}

}