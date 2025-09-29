package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileController {
	public static void main(String[] args) {
		String inputFileName = "src/com/shinhan/day13/input.txt";
		String outputFileName = "src/com/shinhan/day13/output.txt";
		
		try {
			new FileController().reverseLine(inputFileName, outputFileName);
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("================END===============");
	}
	
	void reverseLine(String inputFileName, String outputFileName) throws Exception {
		FileReader fr = new FileReader(inputFileName);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(outputFileName);
		BufferedWriter bw = new BufferedWriter(fw);
		List<String> dataList = new ArrayList<>();
		
		String line;
		while((line = br.readLine())!= null) {
			dataList.add(line);
		}
		
		for(int i = dataList.size()-1; i >= 0; i--) {
			bw.write(dataList.get(i));
			bw.newLine();
		}
		
		br.close();
		fr.close();
		bw.close();
		fw.close();
	}

}
