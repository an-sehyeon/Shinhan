package com.shinhan.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

// 모든종목의 체결가, 종목이름 trade_price를 출력하기

public class AipExample {
	
	public static void getMarketAll() throws IOException {
		List<String> maketList = new ArrayList<>();
		String strUrl = "https://api.bithumb.com/v1/market/all";
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");	// 대소문자구분
		conn.setRequestProperty("Accept", "application/json");
		
		BufferedReader br =  new BufferedReader( new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuffer sb = new StringBuffer();
		
		  while((line = br.readLine())!=null) {
			System.out.println(line);
			sb.append(line);
		}
		
		JSONArray jsonArr = new JSONArray(sb.toString());
		for(int i=0;i<jsonArr.length();i++) {
			JSONObject obj = jsonArr.getJSONObject(i);
			String market = obj.getString("market");
			maketList.add(market);
		}
		System.out.println(maketList);
		getTradePrice(maketList);
		
	}
	
	public static void getTradePrice(List<String> maketList) throws IOException {
		for(String market:maketList) {
			int price = f_1(market);
			System.out.println(market + "체결가는 : " + price);
		}
	}

	private static int f_1(String market) throws IOException {
		String strUrl = "https://api.bithumb.com/v1/trades/ticks?market=krw-btc";
//		String strUrl = "https://api.bithumb.com/v1/market/all";
		URL url = new URL(strUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");	// 대소문자구분
		conn.setRequestProperty("Accept", "application/json");
		
		BufferedReader br =  new BufferedReader( new InputStreamReader(conn.getInputStream()));
		String line;
		StringBuffer sb = new StringBuffer();
		
		while((line = br.readLine())!= null) {
			System.out.println(line);
			sb.append(line);
		}
		
		JSONArray jsonArr = new JSONArray(sb.toString());
		int price = 0;
		for(int i=0;i<jsonArr.length();i++) {
			JSONObject obj = jsonArr.getJSONObject(i);
			price = obj.getInt("trade_price");
		}
		
		return price;
	}

	public static void main(String[] args) {
		try {
			getMarketAll();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}


// {"market":"KRW-BTC"}  => JSONObject
// [{}, {}]  => JSONArray


