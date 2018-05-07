package com.sumus.list.sample;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class LargestProductFromStringTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void expect18AsLargestProductWhenWindowSizeEqualsStringToSearchLength() {
        final LargestProductFromString calculator = new LargestProductFromString("29");
        final long expectedProduct = 18;

        final long actualProduct = calculator.largestProductWhenWindowSize(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void expectLargestProductToBeZeroWhenEveryAlernativeDigitIsZero() {
        final LargestProductFromString calculator = new LargestProductFromString("10909");
        final long expectedProduct = 0;

        final long actualProduct = calculator.largestProductWhenWindowSize(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersInOrder() {
        final LargestProductFromString calculator = new LargestProductFromString("0123456789");
        final long expectedProduct = 72;

        final long actualProduct = calculator.largestProductWhenWindowSize(2);

        assertEquals(expectedProduct, actualProduct);
    }


    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthTwoWithNumbersNotInOrder() {
        final LargestProductFromString calculator = new LargestProductFromString("576802143");
        final long expectedProduct = 48;

        final long actualProduct = calculator.largestProductWhenWindowSize(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersInOrder() {
        final LargestProductFromString calculator = new LargestProductFromString("0123456789");
        final long expectedProduct = 504;

        final long actualProduct = calculator.largestProductWhenWindowSize(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthThreeWithNumbersNotInOrder() {
        final LargestProductFromString calculator = new LargestProductFromString("1027839564");
        final long expectedProduct = 270;

        final long actualProduct = calculator.largestProductWhenWindowSize(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOfLengthFiveWithNumbersInOrder() {
        final LargestProductFromString calculator = new LargestProductFromString("0123456789");
        final long expectedProduct = 15120;

        final long actualProduct = calculator.largestProductWhenWindowSize(5);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductInLongStringToSearchV1() {
        final LargestProductFromString calculator
                = new LargestProductFromString("73167176531330624919225119674426574742355349194934");

        final long expectedProduct = 23520;

        final long actualProduct = calculator.largestProductWhenWindowSize(6);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllDigitsAreZeroes() {
        final LargestProductFromString calculator = new LargestProductFromString("0000");
        final long expectedProduct = 0;

        final long actualProduct = calculator.largestProductWhenWindowSize(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOf12345() {
        final LargestProductFromString calculator = new LargestProductFromString("12345");
        final long expectedProduct = 20;

        final long actualProduct = calculator.largestProductWhenWindowSize(2);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testCorrectlyCalculatesLargestProductOfZeroIfAllSeriesOfGivenLengthContainZero() {
        final LargestProductFromString calculator = new LargestProductFromString("99099");
        final long expectedProduct = 0;

        final long actualProduct = calculator.largestProductWhenWindowSize(3);

        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void testWindowSizeLongerThanLengthOfStringToTestIsRejected() {
        final LargestProductFromString calculator = new LargestProductFromString("123");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(
                "Window size must be less than or equal to the length of the List.");

        calculator.largestProductWhenWindowSize(4);
    }

    @Test
    public void expectExceptionWhenLength0ForEmptyStringToSearch() {
        final LargestProductFromString calculator = new LargestProductFromString("");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size cannot be less than 1.");

        calculator.largestProductWhenWindowSize(0);
    }

    @Test
    public void expectExceptionWhenLength0ForNonEmptyStringToSearch() {
        final LargestProductFromString calculator = new LargestProductFromString("123");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size cannot be less than 1.");

        calculator.largestProductWhenWindowSize(0);
    }

    @Test
    public void testEmptyStringToSearchAndSeriesOfNonZeroLengthIsRejected() {
        final LargestProductFromString calculator = new LargestProductFromString("");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(
                "Window size must be less than or equal to the length of the List.");

        calculator.largestProductWhenWindowSize(1);
    }

    @Test
    public void testStringToSearchContainingNonDigitCharacterIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("String to search may only contain digits.");

        new LargestProductFromString("1234a5");
    }

    @Test
    public void testNegativeWindowSizeIsRejected() {
        final LargestProductFromString calculator = new LargestProductFromString("12345");

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Window size cannot be less than 1.");

        calculator.largestProductWhenWindowSize(-1);
    }

}
