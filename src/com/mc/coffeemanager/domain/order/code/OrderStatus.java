package com.mc.coffeemanager.domain.order.code;

// enum : 열거형
// 서로 연관된 상수(public static final 변수)들의 집합
// 모든 enum은 Enum의 자식 클래스이다. 상수들을 쉽게 다루기 위한 여러 메서드를 상속받아 쓸 수 있다.

// 주문 상태를 상수들로 관리하는 클래스
// 주문 상태 : ex) 대기 , 취소, 생성완료 , 진행중 , 완료, 결제완료 등 ...

public enum OrderStatus {

	OK(0, "주문 생성 성공"), // 주문 생성 성공 상태
	FAIL_SOLDOUT(1, "재고 부족으로 인한 주문 실패"), // 재고 부족으로 인한 주문 실패 상태
	FAIL_SEASON(2, "비시즌이라 주문할 수 없습니다."); // 비시즌으로 인한 주문 실패 상태

	private int code; // 상태 코드
	private String desc; // 상태 설명

	// 생성자: 주문 상태를 초기화
	private OrderStatus(int code, String desc) {
		this.code = code; // 상태 코드 설정
		this.desc = desc; // 상태 설명 설정
	}

	// 현재 상태가 성공 상태인지 확인하는 메서드
	public boolean isOk() {
		return this.code == 0; // 코드가 0이면 성공 상태
	}

	// 상태 설명을 반환하는 메서드
	public String desc() {
		return desc; // 상태 설명 반환
	}

}
