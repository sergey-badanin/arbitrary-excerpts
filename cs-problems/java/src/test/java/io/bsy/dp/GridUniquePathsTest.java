package io.bsy.dp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GridUniquePathsTest {

    @Test
    void testSolveCase01() {
        /*
         * 2,3
         * 
         * [3] [2] [1]
         * [1] [1] [0]
         * 
         */
        assertEquals(3, GridUniquePaths.solve(2, 3));
    }

    @Test
    void testSolveCase02() {
        assertEquals(15, GridUniquePaths.solve(5, 3));
    }

}
