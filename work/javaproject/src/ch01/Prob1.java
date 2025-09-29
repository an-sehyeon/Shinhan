package ch01;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;



public class Prob1 {
	
	// 5번문제	
	public static void main5(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		for(int i = 0; i < answer.length; i++) {
			int value = answer[i];
			counter[value - 1]++;
		}
		
		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		for(int i = 0; i < counter.length; i++) {
			System.out.println((i + 1) + "의 갯수는 " + counter[i] + "개 입니다.");
		}
	}
	
	

	
	
	
	
	
	
	
	
//---------------------------------------------------------------------	
	
	
	
	
	
	// 4번문제
	public static void main4(String[] args) {
		Product[] prodList = {
				new Product("NT450R5E-K24S",500000,"삼성전자"),
				new Product("15UD340-LX2CK",400000,"LG전자"),
				new Product("G2-K3T32AV",600000,"HP")
				};
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();
		
	}
	
	
	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		//구현하시오...return값 수정하기 
		HashSet hs = new LinkedHashSet();
		for(Product p : prodList) {
			if(p.getPrice() >= price) {
				hs.add(p);
			}
		}
		
		List<Product> sortedList = new ArrayList<>(hs);
		sortedList.sort((a,b)-> b.getPrice() - a.getPrice());
		
		 System.out.println("*특정 금액 이상의 상품 결과입니다.*****************");
		 for(Product p : sortedList) {
			 System.out.println(p);
		 }
		return hs;
	}
	
	
	
	private static void makeFile(HashSet resultList)  {
		//구현하시오.
		try(
			ObjectOutputStream os = new ObjectOutputStream(
			new FileOutputStream("data.txt"))){
			for(Object ob : resultList) {
				os.writeObject(ob);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void readFile()  {
		//구현하시오. 
		System.out.println("\n");
		 System.out.println("*readFile결과입니다.*****************");
		 
		 List<Product> list = new ArrayList<>();
		 
		 try(
			 ObjectInputStream is = new ObjectInputStream(
			 new FileInputStream("data.txt"))){
			 while(true) {
				 try {
					 Object obj = is.readObject();
					 if(obj instanceof Product) {
						 list.add((Product) obj);
					 }
				 }catch(EOFException e) {
					 break;
				 }
			 }
			 
		 }catch (IOException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 
		 list.sort((a,b)-> b.getPrice() - a.getPrice());
		 
		 for(Product p : list) {
			 System.out.println(p);
		 }
	}
}

class Product implements Serializable{
	private String model_name;
	private int price;
	private String company;
	
	
	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}


	public String getModel_name() {
		return model_name;
	}


	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price
				+ ", company=" + company + "]";
	}
	
	


	
	
	
	
//---------------------------------------------------------------------	
	
	
	// 3번문제
	public static void main3(String[] args) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();

	}
}

class PhoneCharge {
	// 구현하시오.
	private String user; // 폰사용자이름
	private int call; // 통화시간(분단위)
	private int sms; // 문자전송건수
	private int data; // 데이터통신량(GB단위)
	private int total; // 통신요금(원)

	public PhoneCharge(String user, int call, int sms, int data) {
		super();
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calcCharge() {
		int callFee = (call >= 200) ? 20:10;
		int smsFee = (sms >= 300) ? 80:20;
		int dataFee = (data >= 7) ? 2000 : 1000;
		
		total = (call * callFee) + (sms * smsFee) + (data * dataFee);
		
		
		
	
		
		return total;
	}
	
	public void printCharge() {
		
		System.out.printf("%s 사용자는 이번달에 사용하신 전화요금이 %d원입니다.\n", user, calcCharge());

	}

	
	
	
//---------------------------------------------------------------------	
	
	
	
	
	// 2번문제
	public static void main2(String[] args) {
		System.out.println(leftPad("Samsung", 10, '#'));
		System.out.println(leftPad("SDS", 5, '*'));
		System.out.println(leftPad("Multicampus", 5, '@'));

	}

	public static String leftPad(String str, int size, char fillChar) {
		// 구현하시오.....return값 수정할것
		String strResult = "";
		StringBuilder sb = new StringBuilder();
		for (int i = str.length(); i < size; i++) {
			sb.append(fillChar);
		}

		try {
			if (str.length() > size) {
				throw new IllegalSizeException("문자열의 길이보다 size가 큽니다.");
			} else {
				strResult = sb + str;
			}
		} catch (IllegalSizeException e) {
			System.out.println(e.getMessage());
		}

		return strResult;
	}

//구현하시오.
	static class IllegalSizeException extends Exception {
		String message;

		public IllegalSizeException(String message) {
			super(message);
		}
	}
	
	
	
//---------------------------------------------------------------------
	
	
	// 1번문제
	public static void main(String[] args) {
		String[] array = { "황남기85점", "조성호89점", "한인성88점", "독고정진77점" };
		printMaxScore(array);

	}

	private static void printMaxScore(String[] array) {
		int max = 0;
		int maxIndex = -1;
		array.toString().split(",");
		for (int i = 0; i < array.length; i++) {
			String numberStr = array[i].replaceAll("[^0-9]", "");
			int score = Integer.parseInt(numberStr);
			if (max < score) {
				max = score;
				maxIndex = i;
			}
		}
		System.out.println("최고점수는 " + array[maxIndex] + " 입니다.");
	}
}

