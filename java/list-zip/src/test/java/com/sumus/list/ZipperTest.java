package com.sumus.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 */

public class ZipperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void expectExceptionForNonNullIterableType() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Pair<A,B> does not support iterables such as List or Collection.");

        List<Integer> nums = Arrays.asList(1, 2, 3);
        List<String> strs = Arrays.asList("one", "two", "three");

        System.out.println(Zipper.zip(nums, strs).toString());

        List<String> list = new ArrayList<>();
        Pair<Integer, List<String>> pair = Pair.of(22, list);

    }

    @Test
    public void expectNoExceptionWhenCreatingANewPair() {

        Pair<Integer, String> pair = Pair.of(22, "a string");
        Pair<Integer, String> pair2 = pair;

        assertTrue(pair == pair2);
    }

    @Test
    public void expectPairsToBehaveProperlyForEqual() {

        Pair<Integer, String> pair = Pair.of(22, "a string");
        Pair<Integer, String> pair2 = Pair.of(22, "a String");
        assertTrue(false == pair.equals(pair2));

        pair = Pair.of(21, "a string");
        pair2 = Pair.of(22, "a string");
        assertTrue(false == pair.equals(pair2));

        pair = Pair.of(22, null);
        pair2 = Pair.of(22, null);
        assertTrue(true == pair.equals(pair2));

        pair = Pair.of(22, null);
        pair2 = Pair.of(null, "22");
        assertTrue(false == pair.equals(pair2));

        pair = Pair.of(null, "23");
        pair2 = Pair.of(null, "22");
        assertTrue(false == pair.equals(pair2));

        pair = Pair.of(null, null);
        pair2 = Pair.of(null, null);
        assertTrue(true == pair.equals(pair2));

        pair = Pair.of(null, "11");
        pair2 = Pair.of(null, "11");
        assertTrue(true == pair.equals(pair2));
    }

    @Test
    public void expectNoExceptionForNullIterableType() {

        List<String> listButNull = null;
        Pair<Integer, List<String>> pair = Pair.of(22, listButNull);
        assertEquals(Optional.empty(), pair.b());
    }

    @Test
    public void canCreatePairOfIntString() {
        Pair<Integer, String> pair = Pair.of(22, "22");

        assertEquals(Optional.of(22), pair.a());
        assertEquals(Optional.of("22"), pair.b());
    }

    @Test
    public void expectPairHashCodeToWorkProperly() {

        Pair<Integer, String> p1 = Pair.of(22, "aa");
        Pair<Integer, String> p2 = Pair.of(22, "aA");

        assertTrue(p1.hashCode() != p2.hashCode());

        p1 = Pair.of(22, "aa");
        p2 = Pair.of(21, "aa");

        assertTrue(p1.hashCode() != p2.hashCode());

        p1 = Pair.of(22, null);
        p2 = Pair.of(21, null);

        assertTrue(p1.hashCode() != p2.hashCode());

        p1 = Pair.of(22, null);
        p2 = Pair.of(22, null);

        assertTrue(p1.hashCode() == p2.hashCode());

        p1 = Pair.of(null, null);
        p2 = Pair.of(null, null);

        assertTrue(p1.hashCode() == p2.hashCode());

        p1 = Pair.of(222, "123aa");
        p2 = Pair.of(222, "123aa");

        assertTrue(p1.hashCode() == p2.hashCode());
    }

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
