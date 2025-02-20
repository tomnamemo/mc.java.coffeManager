package com.mc.coffeemanager.domain.order;

import java.time.LocalDateTime;

import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.order.code.OrderStatus;

public class Order {

	private String name; // 주문 이름
	private Coffee coffee; // 주문한 커피
	private int orderCnt; // 주문 수량
	private int orderPrice; // 주문 가격
	private LocalDateTime orderTime; // 주문 시간
	private OrderStatus status; // 주문 상태

	// factory method: 주문을 생성하는 메서드
	public static Order createOrder(Coffee coffee, int orderCnt) {

		Order order = new Order(coffee, orderCnt); // 새로운 주문 객체 생성

		// 재고가 부족한 경우
		if(coffee.getStock() < orderCnt) {
			order.status = OrderStatus.FAIL_SOLDOUT; // 주문 실패 상태 설정
			return order; // 주문 반환
		}

		// 비시즌인 경우
		if(!coffee.isSeason()) {
			order.status = OrderStatus.FAIL_SEASON; // 주문 실패 상태 설정
			return order; // 주문 반환
		}

		order.status = OrderStatus.OK; // 주문 성공 상태 설정
		return order; // 주문 반환
	}

	// 생성자: 주문 객체를 초기화
	private Order(Coffee coffee, int orderCnt) {
		super();
		this.coffee = coffee; // 커피 설정
		this.name = coffee.getName() + "[" + orderCnt + "]"; // 주문 이름 설정
		this.orderCnt = orderCnt; // 주문 수량 설정
		this.orderPrice = coffee.getPrice() * orderCnt; // 주문 가격 계산
		this.orderTime = LocalDateTime.now(); // 현재 시간 설정
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

	public void proceed() { // 주문을 진행하는 메서드
		coffee.provide(orderCnt); // 커피 재고 차감
	}

}
