package com.shinhan.day09;

public class FileWriterExample {
	public static void main(String[] args) {
		
	// try~catch~resource
		try (MyFileWriter fw = new MyFileWriter("file.txt")) {
			fw.write("Java");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}

	}
}
