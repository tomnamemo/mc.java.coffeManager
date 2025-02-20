package com.mc.coffeemanager.domain.order;

import java.time.LocalDateTime;

import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.order.code.OrderStatus;

public class Order {

	private String name;
	private Coffee coffee;
	private int orderCnt;
	private int orderPrice;
	private LocalDateTime orderTime;
	private OrderStatus status;
	
	// factory method
	public static Order createOrder(Coffee coffee, int orderCnt) {
		
		Order order = new Order(coffee, orderCnt);
		
		if(coffee.getStock() < orderCnt) {
			order.status = OrderStatus.FAIL_SOLDOUT;
			return order;
		}
		
		if(!coffee.isSeason()) {
			order.status = OrderStatus.FAIL_SEASON;
			return order;
		}
		
		order.status = OrderStatus.OK;
		return order;
	}

	private Order(Coffee coffee, int orderCnt) {
		super();
		this.coffee = coffee;
		this.name = coffee.getName() + "[" + orderCnt + "]";
		this.orderCnt = orderCnt;
		this.orderPrice = coffee.getPrice() * orderCnt;
		this.orderTime = LocalDateTime.now();
	}
	
	public OrderStatus getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public Coffee getCoffee() {
		return coffee;
	}

	public int getOrderCnt() {
		return orderCnt;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void proceed() {
		coffee.provide(orderCnt);
	}

}