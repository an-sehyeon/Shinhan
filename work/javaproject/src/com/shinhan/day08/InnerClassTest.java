package com.shinhan.day08;


// class의 구성요소 : field, constructor(생성자), method, block, inner class
// class : 변수 + 함수
class OuterClass{
	int outerInstanceVar = 1;
	static int outerStaticVar = 2;
	
	void outerInstanceMethod() {
		System.out.println("outerInstanceVar : " + outerInstanceVar);
		System.out.println("outerStaticVar : " + outerStaticVar);
	}
	
	static void outerStaticMethod() {
//		System.out.println("outerInstanceVar : " + outerInstanceVar);	접근불가
		System.out.println("outerStaticVar : " + outerStaticVar);
	}
	
	// 이름이 충돌된 경우
	int score = 100;
	
	class InnerClass{
		int score = 200;
		
		int innerInstanceVar = 3;
		static int innerStaticVar = 4;
		
		void innerInstanceMethod() {
			int score = 300;
			System.out.println("outerInstanceVar : " + outerInstanceVar);
			System.out.println("outerStaticVar : " + outerStaticVar);
			System.out.println("innerInstanceVar : " + innerInstanceVar);
			System.out.println("innerStaticVar : " + innerStaticVar);
			System.out.println("local score : " + score);
			System.out.println("field score : " + this.score);
			System.out.println("Outer field score : " + OuterClass.this.score);
		}
		
		static void outerStaticMethod() {
			System.out.println("outerStaticVar : " + outerStaticVar);
			System.out.println("innerStaticVar : " + innerStaticVar);
		}
		
	}
	
	static class StaticInnerClass{
		int score = 200;
		
		int innerInstanceVar = 5;
		static int innerStaticVar = 6;
		
		void innerInstanceMethod() {
			int score = 300;
//			System.out.println("outerInstanceVar : " + outerInstanceVar); 	접근 불가
			System.out.println("outerStaticVar : " + outerStaticVar);
			System.out.println("innerInstanceVar : " + innerInstanceVar);
			System.out.println("innerStaticVar : " + innerStaticVar);
			System.out.println("local score : " + score);
			System.out.println("field score : " + this.score);
//			System.out.println("Outer field score : " + OuterClass.this.score);		접근 불가
		}
		
		static void innerStaticMethod() {
			System.out.println("outerStaticVar : " + outerStaticVar);
			System.out.println("innerStaticVar : " + innerStaticVar);
		}
		
	}
	
}

public class InnerClassTest {
	
	InnerClassTest(){
		class AA{
			
		}
	}

	public static void main(String[] args) {
//		f1();
		f2();
		
		String address = "마포구";		// 지역변수 Local class에서 사용하면 무조건 final이다. 내부 class에서 수정불가
		
		// 함수 안의 내부 클래스, 함수에서만 사용가능
		class LocalClass{
			String name;
			static String name2 = "자바";
			
			LocalClass(String name){
				this.name = name;
			}
			
			void f1() {
				System.out.println("local class name = " + name + name2);
//				address = "강남구";	지역변수는 내부 클래스에서 사용은 가능하지만 수정 불가
				System.out.println("지역변수 address = " + address);
			}
			
			static void f2() {
				System.out.println("local calss name2 = " + name2);
			}
			
		}
		System.out.println(LocalClass.name2);
		LocalClass.f2();
		LocalClass aa = new LocalClass("커피");
		System.out.println(aa.name);
		aa.f1();
	}

	private static void f2() {
		OuterClass.StaticInnerClass.innerStaticMethod();
		
		OuterClass.StaticInnerClass v1 = new OuterClass.StaticInnerClass();
		v1.innerInstanceMethod();
	}

	private static void f1() {
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
		OuterClass.InnerClass v1 = new OuterClass().new InnerClass();
		v1.innerInstanceMethod();
	}

}







