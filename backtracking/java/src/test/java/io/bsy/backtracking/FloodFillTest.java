package io.bsy.backtracking;

import java.util.List;

import org.junit.jupiter.api.Test;

public class FloodFillTest {

    @Test
    void testDoFill01() {
        var givenImage = List.of(
                List.of(0, 1, 3, 4, 1),
                List.of(3, 8, 8, 3, 3),
                List.of(6, 7, 8, 8, 3),
                List.of(12, 2, 8, 9, 1),
                List.of(12, 3, 1, 3, 2));

        var flood = new FloodFill();
        var actualResult = flood.doFill(2, 2, 9, givenImage);

        for (var row : actualResult) {
            for (var color : row) {
                System.out.print(String.format("%2s", color));
            }
            System.out.println();
        }

    }
}