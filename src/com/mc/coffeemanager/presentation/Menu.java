package com.mc.coffeemanager.presentation;

import java.util.Scanner;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.order.Order;
import com.mc.coffeemanager.domain.sale.Sale;

// 3 tier architecture
// 1. presentation layer    : 표현계층 (프로그램과 사용자간의 요청-응답과 관련된 로직)
// 2. service(domain) layer : 로직계층 (프로그램의 핵심 로직)
// 3. persistence layer   :  영속성계층 db, 지금 할 수가 없음
public class Menu {

	public Sale sale;
	public Coffee[] drinks;
	public Account account;

	Scanner sc = new Scanner(System.in);

	public Menu(Sale sale, Account account, Coffee[] drinks) {
		super();
		this.sale = sale;
		this.account = account;
		this.drinks = drinks;
	}

	public void menu() {

		while (true) {

			System.out.println("\n=========Menu=========");
			System.out.println("판매등록(1)");
			System.out.println("현황(2)");
			System.out.println("종료(3)");
			System.out.print("입력 : ");

			int inputMenu = sc.nextInt();

			switch (inputMenu) {
			case 1:
				coffeeMenu();
				break;
			case 2:
				statistics();
				break;
			case 3:
				System.out.println(" * 종료합니다.");
				return;
			default:
				System.out.println(" * 잘못된 번호를 입력하셨습니다.");
				break;
			}
		}
	}

	private void statistics() {
		System.out.println("\n=========현황========= ");
		for (Coffee drink : drinks) {
			System.out.printf("%-10s 재고(%3d) 판매량(%3d) \n", drink.getName(), drink.getStock(), drink.getSalesCnt());
		}

		System.out.println(
				"\n잔고(" + account.getBalance() + ") 매출(" + account.getSales() + ") 지출(" + account.getExpenses() + ")");
	}

	private void coffeeMenu() {
		// 음료 메뉴판
		System.out.println("\n=========List========= ");
		for (int i = 0; i < drinks.length; i++) {
			System.out.println(drinks[i].getName() + "(" + i + ")");
		}

		System.out.print("\n * 판매한 커피코드 : ");
		int inputCode = sc.nextInt();

		System.out.print(" * 판매량 : ");
		int orderCnt = sc.nextInt();

		if (inputCode < 0 || inputCode >= drinks.length) {
			System.out.println("정확한 상품번호를 선택해 주세요.");
			return;
		}

		registOrder(inputCode, orderCnt);
	}

	// 주문 생성, 판매를 시작
	private void registOrder(int inputCode, int orderCnt) {
		Order order = Order.createOrder(drinks[inputCode], orderCnt);

		if (!order.getStatus().isOk()) {
			System.out.println(order.getStatus().desc());
			return;
		}

		sale.takeOrder(order);
	}

}