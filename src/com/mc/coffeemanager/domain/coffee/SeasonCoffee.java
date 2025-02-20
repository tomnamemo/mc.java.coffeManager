package com.mc.coffeemanager.domain.coffee;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SeasonCoffee extends Coffee {

	private List<Month> seasonMonths;

	public SeasonCoffee(String name, int price, int purchasePrice, int stock, int safetyStock,
			List<Month> seasonMonths) {
		super(name, price, purchasePrice, stock, safetyStock);
		this.seasonMonths = seasonMonths;
	}

	@Override
	public boolean isSeason() {
		Month nowMonth = LocalDate.now().getMonth();
		if (seasonMonths.contains(nowMonth))
			return true;
		return false;
	}

}