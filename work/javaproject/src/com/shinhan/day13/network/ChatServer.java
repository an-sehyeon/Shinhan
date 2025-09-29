package com.shinhan.day13.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
	static Set<ClientHandler> clientHandlers = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) {
        System.out.println("서버 시작됨...");

        try (ServerSocket serverSocket = new ServerSocket(5001)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("클라이언트 연결됨: " + socket.getInetAddress());

                ClientHandler handler = new ClientHandler(socket, clientHandlers);
                clientHandlers.add(handler);

                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
