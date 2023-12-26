package io.bsy.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {

    @Test
    void testCountNumberOfIslands() {
        var grid = List.of(
                List.of(1, 1, 1, 0, 0, 0),
                List.of(1, 1, 1, 1, 0, 0),
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 1, 0, 0, 0, 0),
                List.of(0, 0, 0, 0, 1, 0),
                List.of(0, 0, 0, 0, 0, 0));

        var actualCnt = NumberOfIslands.countNumberOfIslands(grid);
        assertEquals(2, actualCnt);
    }
}
