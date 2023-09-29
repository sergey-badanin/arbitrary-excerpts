package io.bsy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void case01() {
        var given = new Integer[] { 3, 2, 1 };
        var expected = new Integer[] { 1, 2, 3 };

        var actual = new MergeSort<Integer>(Integer.class).perform(given);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void case02() {
        var given = new Integer[] { 3, 1, 0, 5, 2, 12, 1 };
        var expected = new Integer[] { 0, 1, 1, 2, 3, 5, 12 };

        var actual = new MergeSort<Integer>(Integer.class).perform(given);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void case03() {
        var given = new Integer[] { 3, 1 };
        var expected = new Integer[] { 1, 3 };

        var actual = new MergeSort<Integer>(Integer.class).perform(given);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void case04() {
        var given = new Integer[] { 3 };
        var expected = new Integer[] { 3 };

        var actual = new MergeSort<Integer>(Integer.class).perform(given);

        Assertions.assertArrayEquals(expected, actual);
    }
}
