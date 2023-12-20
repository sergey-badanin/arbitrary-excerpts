package io.bsy.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ShortestPathTest {

    @Test
    void testShortestPath01() {
        var vertex0 = List.of(1, 2);
        var vertex1 = List.of(0, 2, 3);
        var vertex2 = List.of(0, 1);
        var vertex3 = List.of(1);
        var givenGraph = List.of(vertex0, vertex1, vertex2, vertex3);

        var pathResolver = new ShortestPath();
        var actualPath = pathResolver.shortestPath(givenGraph, 0, 3);
        assertEquals(2, actualPath);
    }

}
