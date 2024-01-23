package io.bsy.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MinPathSumTest {

    @Test
    void testSolveCase01() {
        var givenGrid = List.of(
                List.of(1, 3, 1),
                List.of(1, 5, 1),
                List.of(4, 2, 1));

        assertEquals(7, MinPathSum.solve(givenGrid));
    }

}
