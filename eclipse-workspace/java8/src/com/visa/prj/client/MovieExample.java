package com.visa.prj.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class MovieExample {

	public static void main(String[] args) {
		BufferedReader breader = null;
		try {
			Path path = Paths.get("src", "movies.csv");
			breader = Files.newBufferedReader(path, StandardCharsets.ISO_8859_1);

		} catch (IOException exception) {
			System.out.println("Error occured while trying to read the file");
			System.exit(0);
		}
		// we get all the lines at one shot.
		List<String> lines = breader.lines().collect(Collectors.toList());
		// To get the list of all movie names
		lines.stream().map(line -> line.split(";")[0]).forEach(System.out::println);

		// To Get Director of "A Beautiful Mind"

		lines.stream().filter(line -> line.split(";")[0].equals("A Beautiful Mind")).map(line -> line.split(";")[2])
				.forEach(System.out::println);

		lines.stream()
		.skip(1)
		.map(line -> Arrays.asList(line.split(";")))
		.filter(movie -> {
			String movieName = movie.get(0);
			return movieName.trim().equalsIgnoreCase("A Beautiful Mind");
		}).forEach(movie -> {
			String director = movie.get(2);
			System.out.println("A Beautiful Mind was directed by " + director);
		});
		// Top 5 movies voted on IMDB [ Column 9]
		lines.stream()
		.skip(1)
		.map(line -> Arrays.asList(line.split(";")))
		.filter(movie -> {
			String imdbVotes = movie.get(9).trim();
			return !imdbVotes.equals("");
		}).sorted((movie1, movie2) -> {
			String m1Votes = movie1.get(9).trim();
			String m2Votes = movie2.get(9).trim();
			return Integer.valueOf(m2Votes).compareTo(Integer.valueOf(m1Votes));
		}).limit(5).forEach(movie -> {
			System.out.println(movie.get(0) + " --- " + movie.get(9));
		});
	}

}
