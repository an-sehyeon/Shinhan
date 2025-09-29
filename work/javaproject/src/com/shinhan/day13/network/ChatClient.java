package com.shinhan.day13.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.0.200", 5001);
		System.out.println("서버에 연결됨.");

		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		// 메시지 수신 쓰레드
		new Thread(() -> {
			try {
				String message;
				while ((message = in.readLine()) != null) {
					System.out.println("받음: " + message);
				}
			} catch (IOException e) {
				System.out.println("서버 연결 종료.");
			}
		}).start();

		// 메시지 전송 루프
		String input;
		while ((input = userInput.readLine()) != null) {
			out.println(input);
			if("/bye".equalsIgnoreCase(input)){
				System.out.println("채팅종료합니다.");
				break;
			}
		}

		socket.close();
	}
}
