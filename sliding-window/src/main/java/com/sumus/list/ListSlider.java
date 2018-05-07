package com.sumus.list;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by kevinorr on 29/04/2018.
 */
public class ListSlider<E> {

    private static final String LENGTH_ERROR_MSG = "Window size must be less than or equal to the length of the List.";
    private static final String SLIDE_SIZE_ERROR_MSG = "Window size cannot be less than 1.";
    private static final String NULL_OR_EMPTY_LIST = "List argument cannot be null or empty.";

    public static <E> List<List<E>> slide(int size, final List<E> inputListOfThingies) throws IllegalArgumentException {

        final List<E> input = Optional.ofNullable(inputListOfThingies)
                                      .orElseThrow(() -> new IllegalArgumentException(NULL_OR_EMPTY_LIST));

        if (size > input.size()) throw new IllegalArgumentException(LENGTH_ERROR_MSG);
        if (size <= 0) throw new IllegalArgumentException(SLIDE_SIZE_ERROR_MSG);

        int howManySlidingWindows = input.size() + 1 - size;

        return IntStream.range(0, howManySlidingWindows)
                .mapToObj(i -> input.stream()
                        .skip(i)
                        .limit(size)
                        .collect(Collectors.toList())

                )
                .collect(Collectors.toList());

    }
}