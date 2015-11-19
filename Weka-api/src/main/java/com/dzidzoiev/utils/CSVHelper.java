package com.dzidzoiev.utils;

import com.dzidzoiev.model.csv.Place;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by dzidzoiev on 11/18/15.
 */
public class CSVHelper {

    public static List<String[]> readFile(String filePath, int count) throws IOException {
        return fileToStream(filePath)
                .limit(count)
                .skip(1) //headers
                .collect(Collectors.toList());
    }

    public static <T> List<T> readFile(String filePath, int count, Function<? super String[], T> mapper) throws IOException {
        return fileToStream(filePath)
                .skip(1)
                .limit(count)
                .map(mapper)
                .collect(Collectors.toList());
    }

    public static <T> List<T> readFile(String filePath, Function<? super String[], T> mapper) throws IOException {
        return fileToStream(filePath)
                .skip(1)
                .limit(100000)
                .map(mapper)
                .collect(Collectors.toList());
    }

    private static Stream<String[]> fileToStream(String filePath) throws FileNotFoundException {
        com.opencsv.CSVReader reader = new com.opencsv.CSVReader(new FileReader(filePath));
        Iterator<String[]> iterator = reader.iterator();
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
    }

    public static void main(String[] args) throws IOException {
        String filename = "src/main/resources/ml-latest-small/places.csv";
        File f = new File(filename);
        System.out.println(f.getCanonicalPath());
//        List<String[]> places = readFile(filename, 1000);
//        places.stream()
//                .map(Arrays::deepToString)
//                .forEach(System.out::println);
        List<Place> places = readFile(filename, 20,
                (String[] s) -> new Place()
                        .setPlaceId(Long.parseLong(s[0]))
                        .setName(s[1])
                        .setAttributes(s[2]));
        System.out.println(places);
//        places.stream()
//                .map((String[] s) -> new Place()
//                                .setPlaceId(Long.parseLong(s[0]))
//                                .setName(s[1])
//                                .setAttributes(s[2]))
//                .forEach(System.out::println);
    }
}
