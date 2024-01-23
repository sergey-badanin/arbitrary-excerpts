package io.bsy.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LongestIncreasingSubsequenceTest {

    @Test
    void testSolveCase01() {
        var givenNums = List.of(50, 3, 10, 7, 40, 80);
        assertEquals(4, LongestIncreasingSubsequence.solve(givenNums));
    }

    @Test
    void testSolveCase02() {
        var givenNums = List.of(1, 2, 4, 3);
        assertEquals(3, LongestIncreasingSubsequence.solve(givenNums));
    }

    @Test
    void testSolveCase03() {
        var givenNums = List.of(5, 8, 2, 3, 7, 9, 1, 8, 9, 10);
        assertEquals(6, LongestIncreasingSubsequence.solve(givenNums));
    }

}
