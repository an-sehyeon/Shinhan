package com.shinhan.myapp;

// 업무로직은 없고 field정의, 생성방법, setter/getter만 존재 
// VO(Value Object)
// DTO(Data Transfer Object)
// JavaBeas 기술 -> JSP/Servlet.Spring, Mybates framework
public class Book {
	
	// 1. field(멤버변수 : intance변수)
	private String title;
	private int price;
	
	public Book() {
//		default 생성자
	}
	
	
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	
	// EL : ${title}
	/*
	 * <select type="com.shinhan.day05.LAB.Book">
	 * 	select * from 테이블이름
	 * </select>
	 * */
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
