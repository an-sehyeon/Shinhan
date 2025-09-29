package com.shinhan.day02;

public class Exercise_CH3 {
	
	public static void main(String[] args) {
		for(int x = 1; x <= 5; x++) {
            for(int y = 1; y <= 5; y++) {
                if(y < x) {
                    System.out.printf(" ");
                } else {
                    System.out.printf("*");
                }
            }
            System.out.println();
        }
  
    }
	
	public static void main9(String[] args) {
		 for(int row = 1; row <= 5; row++) {  //줄 
			 
			    for(int col = 1; col <= 5-row; col++) {
					System.out.print(" ");
				}
				for(int col = 6-row; col <= 5; col++) {
					System.out.print("*");
				}
				
				System.out.println(); //줄바꿈 
		 }
	}
	/*
	 1->0000 5,5
	 2->000 4,5
	 3->00 3,5
	 4->0 2,5
	 5->1,5
	*/ 
	
	public static void main8(String[] args) {
		 for(int row = 1; row <= 5; row++) {  //줄 
				for(int col = 1; col <= 6-row; col++) {
				 	System.out.print("*");
				}
				
				System.out.println(); //줄바꿈 
		 }
	}
	
	/*
	 1->1,5
	 2->1,4
	 3->1,3
	 4->1,2
	 5->1,1
	*/ 
	
	 public static void main7(String[] args) {
		 for(int row = 1; row <= 5; row++) {  //줄 
				for(int col = 1; col <= row; col++) {
					System.out.print("*");
				}
				
				System.out.println(); //줄바꿈 
		 }
	}
	 
	 
	/*
	 1->1,1
	 2->1,2
	 3->1,3
	 4->1,4
	 5->1,5
	*/ 
	
	
	
	
	
	/*
	 * 4. while 문과 Math.random() 메소드를 이용해서 두 개의 주사위를 던졌을 때 나오는 눈을 (눈1, 
		눈2) 형태로 출력하고, 눈의 합이 5가 아니면 계속 주사위를 던지고, 눈의 합이 5이면 실행을 멈추
		는 코드를 작성해보세요. 눈의 합이 5가 되는 경우는 (1, 4), (4, 1), (2, 3), (3, 2)입니다.

	 */
	public static void main6(String[] args) {
		민수();
	}
	
	public static void 민성() {
		long start = System.currentTimeMillis();
		labelX: for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if(4 * x >= 60) break labelX;
				
				if(5 * y >= 60) break;
				
				if (4 * x + 5 * y == 60) System.out.printf("(%d, %d)\n", x, y);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end-start));
	}
	
	private static void 민수() {
		long start = System.currentTimeMillis();
        int x,y;
        for(x=1;x<=10;x++) {
            for(y=1;y<=10;y++) {
                if((4*x+5*y)==60) {
                    System.out.printf("(%d, %d)\n",x,y);
                }
            }
        }
        long end = System.currentTimeMillis();
		System.out.println("걸린시간:" + (end-start));
    }
	
	
	public static void main5(String[] args) {
		//로또번호생성 1<=  <=45
		int aa = (int)(Math.random()*45)+1;
		System.out.println(aa);
	}
	
	
	
	public static void main4(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.abs(-123));
		System.out.println(Math.random()); //0<= <1
		
		while(true) {
			int dice1 = (int)(Math.random() * 6) + 1;
			int dice2 = (int)(Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", dice1, dice2);
			if(dice1+dice2 == 5) break;  
		}	
	}
	
	
	
	public static void main3(String[] args) {
		double su = Math.random() * 6;  //0<= 실수   <1
		int su2 = (int)Math.floor(su) + 1 ;
		//0<= 실수 <6
		//1<= 정수 <=6
		System.out.println(su2);
	}
	
	
	
	
	public static void main2(String[] args) {
		fun9();
		f8();
		f7();

	}
	private static void f7() {
		int i = 1, sum = 0;
		for (; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.printf("1부터 %d까지의 정수 중 %d의 배수의 총합: %d\n", 0, 100, sum);
	}
	
	private static void f8() {
		int total = 0;
		for(int i=0; i<=100; i+=3) {
			total += i;
		}
		System.out.printf("1부터 %d까지의 정수 중 %d의 배수의 총합: %d\n", 0, 100, total);
	}
	
	private static void fun9() {
        int num1 = 100;
        int num2 = 3;
        int result = 0;
        
        for(int i = 1; i <= num1 / num2; i++) {  //33번 
            result += i * num2;
        }
        
        System.out.printf("1부터 %d까지의 정수 중 %d의 배수의 총합: %d\n", num1, num2, result);
    }
}
