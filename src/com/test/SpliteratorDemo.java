package com.sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorDemo {
	
static class Person {
		
		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		int age;
		String name;
		String lastName;

		Person(String name, String lastName, int age) {
			this.lastName = lastName;
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + " " + age + " " + lastName;
		}

	}


	public static void main(String... args) {
		Path file = Paths.get("resources/persons");
		Stream<String> lines = null;
		try {
			lines = Files.lines(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Spliterator<String> lineSpliterator = lines.spliterator();
		Stream<Person> personStream = StreamSupport.stream(new PersonSpliterator(lineSpliterator), false);
		
		personStream.forEach(System.out::println);
		
		}
	
	
}
