package com.shinhan.day06;

public class ShopService {
	
	private static ShopService shop = 
			 new ShopService();
	
	private ShopService(){
		
	}
	public static ShopService getInstance() {
		return shop;
	}
	
}
