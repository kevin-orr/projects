package com.sumus.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 */

public class ListSliderTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void expectSameListWhenWindowSizeEqualToListSize() throws IllegalArgumentException {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

        final List<List<Integer>> expectedProduct = Arrays.asList(list);

        final List<List<Integer>> actualProduct = ListSlider.slide(list.size(), list);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void expectExceptionWhenWindowSizeNegative() throws IllegalArgumentException {
        List<Character> charList = Arrays.asList('a', 'b', 'c');

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size cannot be less than 1.");
        ListSlider.<Character>slide(-1, charList);
    }

    @Test
    public void expectExceptionWhenWindowSizeGreaterThanListSize() throws IllegalArgumentException {
        List<Character> charList = Arrays.asList('a', 'b', 'c');

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size must be less than or equal to the length of the List.");
        ListSlider.<Character>slide(charList.size() + 1, charList);
    }

    @Test
    public void expectExceptionWhenNullList() throws IllegalArgumentException {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("List argument cannot be null or empty.");
        ListSlider.<Character>slide(1, null);
    }

    @Test
    public void expectExceptionWhenEmptyList() throws IllegalArgumentException {
        List<Character> charList = Collections.emptyList();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size must be less than or equal to the length of the List.");

        ListSlider.slide(1, charList);
    }

    @Test
    public void expectExceptionWhenWindowSizeZero() throws IllegalArgumentException {
        List<Integer> intList = Arrays.asList(1, 2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size cannot be less than 1.");

        ListSlider.<Integer>slide(0, intList);
    }

    @Test
    public void expect2ListsWhenSLidingOver4ItemsOfSize3() throws IllegalArgumentException {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4);

        final List<List<Integer>> expectedProduct = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(2,3,4));

        final List<List<Integer>> actualProduct = ListSlider.<Integer>slide(3, intList);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void expect3ListsWhenSLidingOver4ItemsOfSize2() throws IllegalArgumentException {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4);

        final List<List<Integer>> expectedProduct = Arrays.asList(Arrays.asList(1,2), Arrays.asList(2,3), Arrays.asList(3,4));

        final List<List<Integer>> actualProduct = ListSlider.<Integer>slide(2, intList);

        assertEquals(expectedProduct, actualProduct);
    }
}
