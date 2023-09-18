package com.flipkart.bean;
/**
 * @author rohit.r10
 */
public class Customer extends User{
	private String name;
	private int age;
	private String location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void display() {
		System.out.println("~~~~~~~~~~~~~~Customer Profile~~~~~~~~~~~~~~");
		System.out.println("Username: "+this.getUserName());
		System.out.println("Name: "+this.name);
		System.out.println("Age: "+this.age);
		System.out.println("Location: "+this.location);
	}
	
}
