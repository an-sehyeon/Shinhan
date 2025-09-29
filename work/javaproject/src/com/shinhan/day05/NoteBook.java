package com.shinhan.day05;

// class : object만드는 틀, object는 각각의 특징을 갖는다.(field로 선언)
// VO(Value Object) : 값을 저장하는 객체
// JavaBeans (객체)
// 업무로직은 작성하지 않고, 단지 값을 저장하기 위함.
// DTO(Data Transfer Object) : data를 저장해서 전송하려는 목적
public class NoteBook {
	
	private String model;
	private String company;
	private int price;
	public NoteBook(String model, String company, int price) {
		super();
		this.model = model;
		this.company = company;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
	
	

}
