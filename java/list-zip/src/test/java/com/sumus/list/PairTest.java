package com.sumus.list;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by kevinorr on 02/05/2018.
 */
public class PairTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldBeAbleTpCreatePair() throws Exception {
        Pair<Integer, String> pair = Pair.of(22, "a string");
        Pair<Integer, String> pair2 = pair;

        assertTrue(pair == pair2);
    }

    @Test
    public void shouldAllowNullIterableType() throws Exception {
        List<String> listButNull = null;
        Pair<Integer, List<String>> pair = Pair.of(22, listButNull);
        assertEquals(Optional.empty(), pair.b());
    }

    @Test
    public void expectExceptionForNonNullIterableType() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Pair<A,B> does not support iterables such as List or Collection.");

        List<String> list = new ArrayList<>();

        Pair<Integer, List<String>> pair = Pair.of(22, list);
    }

    @Test
    public void shouldHaveEqualsBehaviourAsExpected() throws Exception {

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
    public void expectHashCodeToBeConsistent() throws Exception {

        Pair<Integer, String> p1 = Pair.of(22, "a string");
        Pair<Integer, String> p2 = Pair.of(22, "a StrinG");

        assertTrue(p1.hashCode() != p2.hashCode());
    }

}