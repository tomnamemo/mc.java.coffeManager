package com.mc.coffeemanager.presentation;

import java.util.Scanner;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.sale.Sale;

// 3 tier architecture
// 1. presentation layer    : 표현계층 (프로그램과 사용자 간의 요청-응답과 관련된 로직)
// 2. service(domain) layer : 로직계층 (프로그램의 핵심 로직)
// 3. persistence layer     : 영속성계층 (DB, 현재는 사용하지 않음)
public class Menu {

	public Sale sale; // 판매 관련 객체
	public Coffee[] drinks; // 커피 배열
	public Account account; // 계좌 객체

	Scanner sc = new Scanner(System.in); // 사용자 입력을 위한 스캐너

	// 생성자: 판매, 계좌, 음료 목록 초기화
	public Menu(Sale sale, Account account, Coffee[] drinks) {
		super();
		this.sale = sale; // 판매 객체 설정
		this.account = account; // 계좌 객체 설정
		this.drinks = drinks; // 커피 목록 설정
	}

	// 메뉴를 표시하고 사용자 입력을 처리하는 메서드
	public void menu() {

		while (true) {

			System.out.println("\n=========Menu=========");
			System.out.println("판매등록(1)"); // 판매 등록 메뉴
			System.out.println("현황(2)"); // 현황 메뉴
			System.out.println("종료(3)"); // 종료 메뉴
			System.out.print("입력 : ");

			int inputMenu = sc.nextInt(); // 사용자 입력

			switch (inputMenu) {
			case 1:
				coffeeMenu(); // 커피 메뉴로 이동
				break;
			case 2:
				statistics(); // 현황 보기
				break;
			case 3:
				System.out.println(" * 종료합니다."); // 종료 메시지
				return; // 메서드 종료
			default:
				System.out.println(" * 잘못된 번호를 입력하셨습니다."); // 잘못된 입력 처리
				break;
			}
		}
	}

	// 현황을 출력하는 메서드
	private void statistics() {
		System.out.println("\n=========현황========= ");
		for (Coffee drink : drinks) {
			System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", drink.getName(), drink.getStock(), drink.getSalesCnt()); // 커피 정보 출력
		}

		// 계좌 정보 출력
		System.out.println(
				"\n잔고(" + account.getBalance() + ") 매출(" + account.getSales() + ") 지출(" + account.getExpenses() + ")");
	}

	// 커피 메뉴를 표시하는 메서드
	private void coffeeMenu() {
		// 음료 메뉴판
		System.out.println("\n=========List========= ");
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i].getName() + "(" + i + ")"); // 각 음료 이름과 인덱스 출력
		}

		System.out.print("\n * 판매한 커피코드 : "); // 판매할 커피 코드 입력 요청
		int inputCode = sc.nextInt(); // 사용자 입력

		System.out.print(" * 판매량 : "); // 판매량 입력 요청
		int orderCnt = sc.nextInt(); // 사용자 입력

		// 유효한 커피 코드인지 확인
		if (inputCode < 0 || inputCode >= drinks.length) {
			System.out.println("정확한 상품번호를 선택해 주세요."); // 잘못된 코드 처리
			return;
		}

		registOrder(inputCode, orderCnt); // 주문 등록 메서드 호출
	}

	// 주문 생성, 판매를 시작하는 메서드
	private void registOrder(int inputCode, int orderCnt) {
		Order order = Order.createOrder(drinks[inputCode], orderCnt); // 주문 생성

		// 주문 상태 확인
		if (!order.getStatus().isOk()) {
			System.out.println(order.getStatus().desc()); // 실패 메시지 출력
			return;
		}

		sale.takeOrder(order); // 판매 진행
	}

}
