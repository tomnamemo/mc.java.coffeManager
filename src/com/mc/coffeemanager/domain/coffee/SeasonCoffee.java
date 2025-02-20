package com.mc.coffeemanager.domain.coffee;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SeasonCoffee extends Coffee {

	private List<Month> seasonMonths; // 시즌에 해당하는 월 목록

	// 생성자: 시즌 커피 객체를 초기화
	public SeasonCoffee(String name, int price, int purchasePrice, int stock, int safetyStock,
			List<Month> seasonMonths) {
		super(name, price, purchasePrice, stock, safetyStock); // 상위 클래스의 생성자 호출
		this.seasonMonths = seasonMonths; // 시즌 월 초기화
	}

	@Override
	public boolean isSeason() { // 현재 월이 시즌에 해당하는지 확인하는 메서드
		Month nowMonth = LocalDate.now().getMonth(); // 현재 월을 가져옴
		if (seasonMonths.contains(nowMonth)) // 현재 월이 시즌 목록에 포함되어 있는지 확인
			return true; // 포함되어 있으면 true 반환
		return false; // 포함되어 있지 않으면 false 반환
	}

}
