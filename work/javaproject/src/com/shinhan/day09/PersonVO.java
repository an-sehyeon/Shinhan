package com.shinhan.day09;

import java.util.Objects;

public class PersonVO {
	
	private String name;
	private int age;
	private String job;
	
	public PersonVO() {
		super();
	}
	public PersonVO(String name, int age, String job) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, job, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return age == other.age && Objects.equals(job, other.job) && Objects.equals(name, other.name);
	}
	
	

}
