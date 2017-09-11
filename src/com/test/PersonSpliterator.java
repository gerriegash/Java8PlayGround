package com.sample;

import java.util.Spliterator;
import java.util.function.Consumer;

import com.sample.SpliteratorDemo.Person;


public class PersonSpliterator implements Spliterator<Person> {

	Spliterator<String> lineSpliterator = null;
	private int age;
	private String lastName;
	private String firstName;

	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {
		// TODO Auto-generated method stub
		if (lineSpliterator.tryAdvance(line -> this.firstName = line)
				&& lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line))
				&& lineSpliterator.tryAdvance(line -> this.lastName = line)) {
			action.accept(new Person(lastName, firstName, age));
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Spliterator<Person> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return lineSpliterator.estimateSize();
	}

	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return lineSpliterator.characteristics();
	}

}
