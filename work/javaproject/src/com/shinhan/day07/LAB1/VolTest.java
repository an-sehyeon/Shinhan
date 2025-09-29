package com.shinhan.day07.LAB1;

class VolTest {
public static void main(String args[]){
 Volume[] v = new Volume[3];
 v[0] = new Speaker();
 v[1] = new Radio();
 v[2] = new TV();
 for(int i = 0; i < v.length; i++){
	 for(int j = 1; j <= 3; j++){
       		v[i].volumeUp(200);
      }
	 for(int j = 1; j <= 3; j++){
	  	v[i].volumeDown(300);
	 }
 }
}
}



