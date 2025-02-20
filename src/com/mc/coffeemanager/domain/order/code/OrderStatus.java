package com.mc.coffeemanager.domain.order.code;

//enum : 열거형
//서로 연관된 상수(public static final 변수)들의 집합
//모든 enum은 Enum의 자식 클래스이다. 상수들을 쉽게 다루기 위한 여러 메서드를 상속받아 쓸 수 있다.

//주문 상태를 상수들로 관리하는 클래스
//주문 상태 : ex) 대기 , 취소, 생성완료 , 진행중 , 완료, 결제완료 등 ...

public enum OrderStatus {

	// public static final OrderStatus OK = new OrderStatus(0, "주문 생성 성공")
	OK(0, "주문 생성 성공"),
	FAIL_SOLDOUT(1, "재고 부족으로 인한 주문 실패"),
	FAIL_SEASON(2, "비시즌이라 주문할 수 없습니다.");

	private int code;
	private String desc;

	private OrderStatus(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public boolean isOk() {
		return this.code == 0;
	}

	public String desc() {
		return desc;
	}

}
