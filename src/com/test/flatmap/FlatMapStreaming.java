package com.sample.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlatMapStreaming {

	public static void main(String[] args) {

		Stream<String> s1 = null;
		Stream<String> s2 = null;

		try {
			s1 = Files.lines(Paths.get("resources/THEoffice"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			s2 = Files.lines(Paths.get("resources/THEbigbangtheory"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// This although is a way but it will return a stream of Streams.
		// Stream<Stream<String>> s3 = Stream.of(s1,s2);

		// This is good
		Stream<Object> streamOfWords = Stream.of(s1, s2).flatMap(Function.identity())
				.flatMap(line -> Pattern.compile(" ").splitAsStream(line));

		// This good to but it will always have certain order
		// Stream<String> s5 = Stream.concat(s1, s2);

		streamOfWords.forEach(System.out::println);

	}

}
