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

public class ZipperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void expectExceptionWhenLeftIsNull() throws IllegalArgumentException {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null or empty list argument(s) to zip not allowed.");

        Zipper.zip(null, Arrays.asList('a', 'b', 'c'));
    }

    @Test
    public void expectExceptionWhenRightIsNull() throws IllegalArgumentException {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null or empty list argument(s) to zip not allowed.");

        Zipper.zip(Arrays.asList('a', 'b', 'c'), null);
    }

    @Test
    public void expectExceptionWhenLeftIsEmpty() throws IllegalArgumentException {
        List<Integer> left = Collections.emptyList();
        List<Character> right = Arrays.asList('a', 'b', 'c');

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null or empty list argument(s) to zip not allowed.");

        Zipper.zip(left, right);
    }

    @Test
    public void expectExceptionWhenRightIsEmpty() throws IllegalArgumentException {
        List<Character> left = Arrays.asList('a', 'b', 'c');
        List<Integer> right = Collections.emptyList();

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null or empty list argument(s) to zip not allowed.");

        Zipper.zip(left, right);
    }

    @Test
    public void expectListOfPairsForValidLists() {
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Character> right = Arrays.asList('a', 'b', 'c');

        final List<Pair<Integer, Character>> expected =
                Arrays.asList(Pair.of(1,'a'), Pair.of(2,'b'), Pair.of(3,'c'));

        final List<Pair<Integer, Character>> actual = Zipper.zip(left, right);

        assertEquals(expected, actual);
    }

    @Test
    public void allowNullValuesInList() {
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Character> right = Arrays.asList('a', null, 'c');

        final List<Pair<Integer, Character>> expected =
                Arrays.asList(Pair.of(1,'a'), Pair.of(2, null), Pair.of(3,'c'));

        final List<Pair<Integer, Character>> actual = Zipper.zip(left, right);

        assertEquals(expected, actual);
    }
}
