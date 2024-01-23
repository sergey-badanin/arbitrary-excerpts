package io.bsy.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TriangleMinPathSumTest {

    @Test
    void testSolveCase01() {
        var givenTriangle = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3));
        assertEquals(11, TriangleMinPathSum.solve(givenTriangle));
    }
}
