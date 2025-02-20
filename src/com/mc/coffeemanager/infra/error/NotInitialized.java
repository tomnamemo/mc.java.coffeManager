package com.mc.coffeemanager.infra.error;

@SuppressWarnings("serial")
public class NotInitialized extends RuntimeException{

	public NotInitialized(String message) {
		super(message);
	}

}
