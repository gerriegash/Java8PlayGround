package com.sample.optional;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DoubleJava8 {
	
	public static void main(String[] args) {
		
		Function<Double,Optional<Double>> inverse = d -> d!=0?Optional.of(1/d):Optional.empty();
		Function<Double,Optional<Double>> squareRoot = d -> d>0?Optional.of(Math.sqrt(d)):Optional.empty();
		
		List<Double> doubles = new ArrayList<>();
		
		ThreadLocalRandom.current().doubles(100_000)
							.forEach(doubleNumber -> inverse.apply(doubleNumber)
									.ifPresent(inversedNumber -> squareRoot.apply(inversedNumber)
											.ifPresent(finalNumber -> doubles.add(finalNumber))));
		
		System.out.println(doubles.size());

		 //We can`t really apply parallel on it as list i involved wile iterating over the stream.
		 // But we can surely have collectors.toList
		
		List<Double> doubles2 = new ArrayList<>();
				
        Function<Double, Stream<Double>> flatMapper = 
        			d -> inverse.apply(d)
                        .flatMap(inv -> squareRoot.apply(inv))
                        	.map(sqrt -> Stream.of(sqrt))
                        		.orElseGet(() -> Stream.empty());

		
		doubles2 = ThreadLocalRandom.current().doubles(100_000).boxed().parallel()
						.flatMap(flatMapper).
							collect(Collectors.toList());
		
		System.out.print(doubles2.size());
	}

}
