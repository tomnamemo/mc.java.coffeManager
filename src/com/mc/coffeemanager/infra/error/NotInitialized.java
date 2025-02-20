package com.mc.coffeemanager.infra.error;

@SuppressWarnings("serial") // 직렬화 경고 무시
public class NotInitialized extends RuntimeException {

	// 생성자: 초기화되지 않은 상태를 나타내는 예외 메시지를 설정
	public NotInitialized(String message) {
		super(message); // 부모 클래스에 메시지 전달
	}

}
