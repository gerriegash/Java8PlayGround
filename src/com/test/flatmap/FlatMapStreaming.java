package com.sample.flatmap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapStreaming {

	public static void main(String[] args) {

		Stream<String> s1 = null;
		Stream<String> s2 = null;

		int[] scrabble = new int[] { 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7,
				8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7,
				8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51,
				1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0,
				1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3,
				5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3,
				36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5,
				6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3,
				4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8,
				9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4,
				3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4,
				4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3,
				4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2,
				2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6,
				7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8,
				5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7,
				5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3, 5, 2, 2, 3, 4, 51, 1, 1, 2,
				2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7, 7, 6, 7, 8, 9, 0, 1, 2, 3,
				5, 2, 2, 3, 4, 51, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 8, 7, 5, 4, 4, 3, 36, 7, 8, 8, 8, 5, 4, 3, 3, 5, 6, 7,
				7, 6, 7, 8, 9, 0 };

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
		Set<String> words = Stream.of(s1, s2).flatMap(Function.identity())
				.flatMap(line -> Pattern.compile(" ").splitAsStream(line)).filter(word -> word.length() == 4)
				.collect(Collectors.toSet());
		;

		System.out.println(words);

		// IntStream weightOfWords = streamOfWords.map(word -> word.chars())
		// .map(wordStream -> wordStream.reduce((a,b) -> (scrabble[a] +
		// scrabble[b])));
		//
		Function<String, Integer> weightOfWord = word -> word.chars().map((letter) -> scrabble[letter - 'a']).sum();
		Function<String, IntStream> streamOfWordChars = word -> (word.chars());
		// Set<Integer> weightOfWords =
		// words.stream().map(weightOfWord).collect(Collectors.toSet());
		String maxValueWord = words.stream().max(Comparator.comparing(weightOfWord)).get();

		// This good to but it will always have certain order
		// Stream<String> s5 = Stream.concat(s1, s2);

		streamOfWordChars.apply("abc").forEach(System.out::println);
		System.out.println(maxValueWord);

		// streamOfWordChars.apply("AB12312312C").forEach(System.out::println);

		// /System.out.println(streamOfWords.count());

	}

}
