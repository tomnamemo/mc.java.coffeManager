package com.mc.coffeemanager;

import java.time.Month;
import java.util.List;

import com.mc.coffeemanager.domain.account.Account;
import com.mc.coffeemanager.domain.coffee.Coffee;
import com.mc.coffeemanager.domain.coffee.SeasonCoffee;
import com.mc.coffeemanager.domain.sale.Sale;
import com.mc.coffeemanager.presentation.Menu;

public class Run {

	public static void main(String[] args) {
		Coffee americano = new Coffee("americano", 1000, 500, 10, 3);
		Coffee mocha = new Coffee("mocha", 2000, 800, 10, 3);
		Coffee latte = new Coffee("latte", 3000, 1000, 10, 3);
		SeasonCoffee frapuchino = new SeasonCoffee("frapuchino", 4000, 3000, 10, 3,
				List.of(Month.JULY, Month.JUNE, Month.AUGUST));

		Coffee[] coffees = { americano, mocha, latte, frapuchino };
		new Menu(new Sale(), Account.getInstance(100000), coffees).menu();
	}
}