package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileCalculator {

	public static void main(String[] args) throws IOException {
//		String path = FileController.class.getResource("input2.txt").getFile();	
		String path = "src/com/shinhan/day13/input2.txt";
		new FileCalculator().addCalculateResult(path);
		
	}

	void addCalculateResult(String inputFileName) throws IOException {
		FileReader fr = new FileReader(inputFileName);
		BufferedReader br = new BufferedReader(fr);
		
		String line;
		int sum= 0;
		List<String> dataList = new ArrayList<>();
		while((line = br.readLine())!= null) {
			sum += Integer.parseInt(line);
			dataList.add(line);
			System.out.println(dataList);
		}
		dataList.add(sum+"");
		br.close();
		fr.close();
		
		System.out.println(dataList);
		
		FileWriter fw = new FileWriter(inputFileName);
		BufferedWriter bw = new BufferedWriter(fw);
		
		dataList.stream().forEach(data->{
			try {
				bw.write(data);
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
		bw.close();
		fw.close();
	}
}
