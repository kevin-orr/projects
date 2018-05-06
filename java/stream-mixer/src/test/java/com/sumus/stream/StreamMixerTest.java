package com.sumus.stream;

import com.sumus.stream.StreamMixer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 *
 */

public class StreamMixerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void expectStreamsToBeMixedIn() throws IllegalArgumentException {

        IntStream one = IntStream.iterate(0, n -> n + 1);

        IntStream two = IntStream.iterate(10, n -> n * 10);

        List expected = Arrays.asList(0,10,1,100,2,1000,3,10000,4,100000);

        List actual = StreamMixer.intMixer(one, two)
                .limit(10)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void expectStreamsToBeMixedInWithLimit() throws IllegalArgumentException {

        IntStream one = IntStream.iterate(0, n -> n + 1).limit(2);

        IntStream two = IntStream.iterate(10, n -> n * 10).limit(4);

        List expected = Arrays.asList(0,10,1,100,1000,10000);

        List actual = StreamMixer.intMixer(one, two)
                .mapToObj(i -> i)
                .collect(Collectors.toList());

        assertEquals(expected, actual);
    }

    @Test
    public void expectNullPointerExceptionWhenPassedNullStream() throws IllegalArgumentException {
        expectedException.expect(NullPointerException.class);
        //expectedException.expectMessage(null);
        StreamMixer.intMixer(null, IntStream.of(1,2));
    }




}
