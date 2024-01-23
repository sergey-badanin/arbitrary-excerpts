package io.bsy.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LongestDivisibleSubsetTest {

    @Test
    void testSolveCase01() {
        var givenNums = List.of(1, 2, 4, 8);
        assertEquals(4, LongestDivisibleSubset.solve(givenNums));
    }

    @Test
    void testSolveCase02() {
        var givenNums = List.of(1, 2, 3);
        assertEquals(2, LongestDivisibleSubset.solve(givenNums));
    }

}
