package com.shinhan.day09;

import java.io.IOException;

// implements AutoCloseable : 추상메서드를 구현할 의무가 있따.
// AutoCloseable 인터페이스는 자바가 제공, 자동으로 자원반납이 가능

public class MyFileWriter implements AutoCloseable{
	public MyFileWriter(String filePath) throws IOException {
		System.out.println(filePath + " 파일을 엽니다.");
	}

	public void write(String data) throws IOException {
		System.out.println(data + "를 파일에 저장합니다.");
	}

	@Override
	public void close() throws Exception {
		System.out.println("파일을 닫습니다.");
	}

}