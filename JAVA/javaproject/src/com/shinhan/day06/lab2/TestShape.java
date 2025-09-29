package com.shinhan.day06.lab2;


public class TestShape {

	public static void main(String args[])
	{
		Shape[] s = new Shape[3];
		
		s[0] = new Circle("BLUE", 10);
		s[1] = new Rectangle("RED", 5, 7);
		s[2] = new Circle("GREEN", 8);
		
		for(int i = 0 ; i < 3 ; i++)
		{
			System.out.println(i + "번째 도형:" + s[i]);
			System.out.println(i + "번째 도형 면적:" + s[i].calculateArea());
			System.out.println(i + "번째 도형 둘레:" + s[i].calculatePerimeter());
			
			if(s[i] instanceof Circle) {
				Circle c = (Circle)s[i];
				System.out.println(i + "번째 도형 반지름:" + c.getRadius());
			}
			System.out.println("--------------------------");
		}	
	}
}

/*
 * Shape 0 is a BLUE Circle with an area of 314.15927, a radius of 10.0, and a perimeter of 62.831854
Shape 1 is a RED Rectangle with an area of 35.0 and a perimeter of 24.0
Shape 2 is a GREEN Circle with an area of 201.0619328, a radius of 8.0, and a perimeter of 50.2654832

*/
 

