package com.sumus.list.sample;

import com.sumus.list.ListSlider;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by kevinorr on 29/04/2018.
 */
class LargestProductFromString {

    private static final String INVALID_INPUT_MSG = "String to search may only contain digits.";
    private final String number;

    LargestProductFromString(String inputNumber) {
        if (!inputNumber.matches("[0-9]*")) throw new IllegalArgumentException(INVALID_INPUT_MSG);
        number = Optional.ofNullable(inputNumber).orElse("");
    }

    long largestProductWhenWindowSize(int windowSize) {

        List<Character> charList = number.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        return ListSlider.<Character>slide(windowSize, charList)
                .stream()
                .mapToLong(l -> l.stream()
                                 .map(Character::getNumericValue)
                                 .reduce(1, (x, y) -> x * y))
                .max()
                .orElseGet(() -> 1L);
    }
}