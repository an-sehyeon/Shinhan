package com.shinhan.day06.lab2;

public class TestShape {

	public static void main(String args[])
	{
		// 배열 생성
		Shape[] s = new Shape[3];
		
		// Shape은 abstract class임으로 객체생성불가
//		new Shape();
		
		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);
		
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.println(i + "번째 도형" + s[i]);
			System.out.println(i + "번째 도형 면적" + s[i].calculateArea());
			System.out.println(i + "번째 도형 둘레" + s[i].calculatePerimeter());
			
			if(s[i] instanceof Circle) {
				Circle c = (Circle)s[i];
			System.out.println(i + "번째 도형 반지름" + c.getRadius());
			}
			System.out.println("=======================================================");
		}	
	}
}
