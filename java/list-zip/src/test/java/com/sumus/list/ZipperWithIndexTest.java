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

public class ZipperWithIndexTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void expect_1_2_3_AsIndexForList() {
        List<Character> left = Arrays.asList('a', 'b', 'c');

        final List<Pair<Character, Integer>> expected =
                Arrays.asList(Pair.of('a',0), Pair.of('b',1), Pair.of('c',2));

        final List<Pair<Character, Integer>> actual = Zipper.zipWithIndex(left);

        assertEquals(expected, actual);
    }

    @Test
    public void allowNullValuesInList() {
        List left = Arrays.asList(1);

        final List expected = Arrays.asList(Pair.of(1,0));

        final List<Pair<Character, Integer>> actual = Zipper.zipWithIndex(left);

        assertEquals(expected, actual);
    }

    @Test
    public void expectExceptionWhenListIsNull() throws IllegalArgumentException {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Null or empty list argument(s) to zip not allowed.");

        Zipper.zipWithIndex(null);
    }
}
