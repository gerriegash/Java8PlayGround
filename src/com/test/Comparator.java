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
	
	public static Comparator<Person> comparing(Function<Person,Integer> comparingFunction) {
		return (p1,p2) -> comparingFunction.apply(p1) - comparingFunction.apply(p2);
	}
	
}
