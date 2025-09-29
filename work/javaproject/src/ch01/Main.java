package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	// static filed
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException{
		// init
		String value = "";
		
		String st = br.readLine().trim();
		int score = Integer.parseInt(st);
		if(score >= 90) {value="A";}
		else if(score >= 80) {value="B";}
		else if(score >= 70) {value="C";}
		else if(score >= 60) {value="D";}
		else {value="F";};
		
		
		
		// output
		System.out.println(value);
		br.close();
	
	}
}

