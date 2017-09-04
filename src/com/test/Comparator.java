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
	
	public static <T> Comparator<T> comparing(Function<T, Comparable> comparingFunction) {
		return (p1, p2) -> comparingFunction.apply(p1).compareTo(comparingFunction.apply(p2));
	}

	public default Comparator<T> thenComparing(Function<T,Comparable> comparingFunction) {
//		return (p1,p2) -> 
//		{
//			if(compare(p1,p2) == 0) {
//				return compare(p1,p2);
//			} else {
//				return comparingFunction.apply(p1).compareTo(comparingFunction.apply(p2));
//			}
//	};
	return thenComparing(comparing(comparingFunction));
	}
	
	public default Comparator<T> thenComparing(Comparator<T> comp) {
			return (p1,p2) -> compare(p1, p2) ==0?comp.compare(p1, p2):compare(p1, p2);
	}
	
	
}
