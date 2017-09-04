/**
 * 
 */
package com.test;

import java.util.function.Function;

/**
 * @author ghanjra
 *
 */
@FunctionalInterface
public interface Comparator<T> {
	
	public int compare(T t1, T t2);
	
	public static Comparator<Person> comparing(Function<Person,Comparable> comparingFunction) {
		return (p1,p2) -> comparingFunction.apply(p1).compareTo(comparingFunction.apply(p2));
	}
	
}
