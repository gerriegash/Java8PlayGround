package com.test;

import java.util.ArrayList;
import java.util.List;

public class ComparatorJava8 {
	
	public static void main(String... args) {
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(34,"Gerry","Hanjra"));
		persons.add(new Person(25,"Herry","Ianjra"));
		
		Comparator<Person> ageComparatorWithLambda = (p1,p2) -> p1.getAge() - p1.getAge();
		Comparator<Person> nameComparatorWithLambda = (p1,p2) -> p1.getName().compareTo(p1.getName());
		Comparator<Person> lastNameComparatorWithLambda = (p1,p2) -> p1.getName().compareTo(p1.getName());
		
		//Comparator that accepts a generic function that will apply internally to comparator
		//Removing the boilerPlate code
		Comparator<Person> ageComparatorWithMR = Comparator.comparing(Person::getAge);
	}

}
