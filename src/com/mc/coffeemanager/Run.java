package com.mc.coffeemanager;

import java.time.Month;
import java.util.List;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.coffee.SeasonCoffee;
import com.mc.coffeemanager.domain.sale.Sale;
import com.mc.coffeemanager.presentation.Menu;

public class Run {

	// 프로그램의 시작점
	public static void main(String[] args) {
		// 커피 객체 생성
		Coffee americano = new Coffee("americano", 1000, 500, 10, 3); // 아메리카노
		Coffee mocha = new Coffee("mocha", 2000, 800, 10, 3); // 모카
		Coffee latte = new Coffee("latte", 3000, 1000, 10, 3); // 라떼
		SeasonCoffee frapuchino = new SeasonCoffee("frapuchino", 4000, 3000, 10, 3, // 프라푸치노 (시즌 커피)
				List.of(Month.JULY, Month.JUNE, Month.AUGUST)); // 판매 가능한 월 설정

		Coffee[] coffees = { americano, mocha, latte, frapuchino }; // 커피 배열 생성
		new Menu(new Sale(), Account.getInstance(100000), coffees).menu(); // 메뉴 실행
	}
}