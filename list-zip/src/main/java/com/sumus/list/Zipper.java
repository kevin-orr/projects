package com.sumus.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kevinorr on 01/05/2018.
 */
public class Zipper {

    /** zip up two lists up to the smallest size of the two */
    public static <A, B> List<Pair<A, B>> zip(List<A> left, List<B> right) {
        required(left, "Null or empty list argument(s) to zip not allowed.");
        required(right, "Null or empty list argument(s) to zip not allowed.");

        // get min length of two list, only zip up to shortest list size to avoid any problems
        int minZipLen = Collections.min(Arrays.asList(left.size(), right.size()));

        return IntStream.range(0, minZipLen)
                .mapToObj(i -> Pair.<A, B>of(left.get(i), right.get(i)))
                .collect(Collectors.toList())
                ;
    }

    /**
     *  Zips up a list with its indices (zero based of course ;-)
     *  Usage:
     *  List<Character> chars = Arrays.asList('a', 'b', 'c');
     *
     *  final List<Pair<Character, Integer>> expected = Zipper.zipWithIndex(chars)
     *  Will result in:
     *  Arrays.asList(Pair.of('a',0), Pair.of('b',1), Pair.of('c',2));
     */
    public static <A, Integer> List<Pair<A, java.lang.Integer>> zipWithIndex(List<A> list) {
        required(list, "Null or empty list argument(s) to zip not allowed.");
        return zip(list, IntStream.range(0, list.size()).boxed().collect(Collectors.toList()));
    }

    static <T> List<T> required(List<T> obj, String message) {
        if (obj == null || obj.isEmpty()) throw new IllegalArgumentException(message);
        return obj;
    }
}