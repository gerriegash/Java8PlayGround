package com.test;

public class Person { 
	/**
	 * @param age
	 * @param name
	 * @param lastName
	 */
	public Person(int age, String name, String lastName) {
		this.age = age;
		this.name = name;
		this.lastName = lastName;
	}

	int age;
	String name;
	String lastName;
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the lastName
	 */
	public String getlastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " " + lastName;
	}
	
}
