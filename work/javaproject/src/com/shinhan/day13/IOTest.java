package com.shinhan.day13;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@RequiredArgsConstructor
class Score implements Serializable{
	private static final long serialVersionUID = 1L;
	final String name;
	final int java;
	final int db;
	final int web;
	
	static String major = "컴공";		// 직렬화에서 제외됨
	String gender;
	transient String hobby;			// 직렬화에서 제외됨
}

// Modifier(활용방법, 접근권한)
// 접근권한 : public > protected > 생략 > private
// 활용방법 : static, final, synchronized, abstract, transient


public class IOTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
//		f11();
//		f12();
	}
	
	
	
	private static void f12() {
//		File f1 = new File("src/com/shinhan/day13/Example.java");
		File f1 = new File("src\\com\\shinhanday13/Example.java");
		File f2 = new File("src\\com/shinhanday13");
		System.out.println(f1.exists()?"파일존재" : "파일없음");
		System.out.println(f2.exists()?"폴더존재" : "폴더없음");
		System.out.println(f2.isDirectory()?"폴더맞음" : "아님");
		
		File[] arr = f2.listFiles();
		Arrays.stream(arr).forEach(f->{
//			System.out.println(f.getAbsolutePath()
		});
		
		
		
	}
	
	private static void f11() throws IOException {
		// Score Class가 여러개 있다.(List), 저장하고 다시 읽어서 출력
		List<Score> scoreList = List.of(
				Score.builder()
				.name("홍길동")
				.java(100)
				.db(90)
				.web(80)
				.gender("남자")
				.hobby("운동")
				.build(),
				Score.builder()
				.name("방길동")
				.java(84)
				.db(99)
				.web(96)
				.gender("여자")
				.hobby("독서")
				.build()
				);
		
		FileOutputStream fw = new FileOutputStream("score2.data");
		ObjectOutputStream oos = new ObjectOutputStream(fw); 
		
		scoreList.stream().forEach(sc->{
			try {
				oos.writeObject(sc);
			}catch(IOException e) {
				e.printStackTrace();
			}
		});

		oos.close();
		fw.close();
		
		FileInputStream fiw = new FileInputStream("score2.data");
		ObjectInputStream ois = new ObjectInputStream(fiw);
		
			try {
				while(true){
					Object obj = ois.readObject();
					if(obj == null) break;
					Score score = (Score)obj;
					System.out.println(score);
				}
			} catch(EOFException e) {
				System.out.println(e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		ois.close();
		fiw.close();
	}
	
	private static void f10() throws IOException, ClassNotFoundException {
		// 객체 스트림, 직렬화
		FileOutputStream fw = new FileOutputStream("score.data");
		ObjectOutputStream oos = new ObjectOutputStream(fw); 
		Score score = Score.builder()
				.name("홍길동")
				.java(100)
				.db(90)
				.web(80)
				.gender("남자")
				.hobby("운동")
				.build();
		Score score4 = Score.builder()
				.name("홍길동4")
				.java(100)
				.db(90)
				.web(80)
				.gender("남자4")
				.hobby("운동4")
				.build();
		
		oos.writeObject(score);
		oos.writeObject(score4);
		oos.close();
		fw.close();
		
		FileInputStream fis = new FileInputStream("score.data");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Score score2 = (Score)ois.readObject();
		System.out.println(score + score.major);
		System.out.println(score2);
		System.out.println(score4);
		
	}
	
	private static void f9() throws IOException {
		// 기본 타입 스트림
		FileOutputStream fos = new FileOutputStream("aa.data");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.write(97);
		dos.writeChar('a');
		dos.writeBoolean(false);
		dos.writeDouble(10.5);
		dos.writeUTF("문자");
		fos.close();
		
		FileInputStream fis = new FileInputStream("aa.data");
		DataInputStream dis = new DataInputStream(fis);
		
		int i = dis.read();
		char ch = dis.readChar();
		boolean b = dis.readBoolean();
		double d = dis.readDouble();
		String s = dis.readUTF();
		System.out.println(i);
		System.out.println(ch);
		System.out.println(b == true?"참":"거짓");
		System.out.println(d);
		System.out.println(s);
		
//		int i = fis.read();
//		System.out.println(i);
//		System.out.println((char)i);
		
		dis.close();
		fis.close();
		
	}
	
	private static void f8() throws IOException {
		// 18장 LAB2 입출력 2번문제
		FileReader fr = new FileReader("src/com/shinhan/day13/data.txt");
		BufferedReader br = new BufferedReader(fr);
		br.readLine();
		
		String line;
		List<Score> data = new Vector<Score>();
		while((line = br.readLine())!=null) {
			int total = 0;
			String[] arr = line.split("/");
			Score score = Score.builder()
					.name(arr[0])
					.java(Integer.parseInt(arr[1]))
					.db(Integer.parseInt(arr[1]))
					.web(Integer.parseInt(arr[1]))
					.build();
			data.add(score);
		}
		br.close();
		fr.close();
		data.stream().forEach(s->System.out.println(s));
		
	}
	
	private static void f7() throws IOException {
		// 18장 LAB2 입출력 1번문제 
		// 보조 스트림, 한줄전체 출력
		FileReader fr = new FileReader("src/com/shinhan/day13/data.txt");
		BufferedReader br = new BufferedReader(fr);
		String line;
		line = br.readLine(); // 제목
		System.out.println(line.replace("/", "\t" ) + "\t총점");	// "/"을 tap으로 변경	
		while((line = br.readLine())!=null) {
			int total = 0;
			String[] arr = line.split("/");
			for(int i=1;i<arr.length;i++) {
				total+=Integer.parseInt(arr[i]);
			}
			System.out.println(line.replace("/", "\t" ) + "\t" + total);
		}
		
		
		
		br.close();
		fr.close();
		
	}
	
	private static void f6() throws IOException {
		// 파일 문자출력
		FileWriter fw = new FileWriter("cc.txt");
		fw.write("문자출력1\n");
		fw.write("문자출력2\n");
		fw.write("문자출력3\n");
		fw.close();
		
		FileReader fr = new FileReader("cc.txt");
		int i;
		while((i = fr.read())!=-1) {
			System.out.print((char)i);
		}
		fr.close();
		
		
	}
	
	private static void f5() throws IOException {
		// 출력(파일)
		FileOutputStream fos = new FileOutputStream("aa.txt");
		fos.write(97);
		fos.write(98);
		fos.write(99);
		fos.close();
		
		FileInputStream fis = new FileInputStream("aa.txt");
		int i;
		while((i = fis.read())!=-1){
			System.out.print((char)i);
		}
		fis.close();
		
	}
	
	private static void f4() throws IOException {
		// 출력(모니터)
		OutputStream os = System.out;	// 상위 = 하위 (OutputStream <- PrintStream)
		os.write(97);
		os.flush();
		
		PrintStream ps = System.out;
		ps.println("문자를 출력함");
		
		
	}
	
	private static void f3() {
//		File
		try(FileReader fr = new FileReader("src/com/shinhan/day13/Example.java");) {
			
			int data;
			while((data = fr.read())!=-1) {
				System.out.print((char)data);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}	finally {
			System.out.println("작업END");
		}
		
		
		
	}
	
	private static void f2() throws IOException {
		// 입력Stream : 키보드, File
		FileInputStream fi = new FileInputStream("src/com/shinhan/day13/Example.java");
		// 보조스트림 (Stream(1byte) -> Reader(2byte))
		InputStreamReader ir = new InputStreamReader(fi);	
		int i;
		while((i = ir.read())!= -1) {		// -1은 End Of File(EOF)
			System.out.print((char)i);
		}
		// 자원반납
		ir.close();
		fi.close();
		
	}
	
	private static void f1() throws IOException {
		// 입력Stream : 키보드
		System.out.print("입력>>");
		InputStream is = System.in;
		int i;
		byte[] arr = new byte[10];
		i = is.read(arr);
		System.out.println("크기 : " + i);
		System.out.println(Arrays.toString(arr));
		String data = new String(arr);
		System.out.println(data);
	}


}
