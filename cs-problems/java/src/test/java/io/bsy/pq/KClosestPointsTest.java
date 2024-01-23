package io.bsy.pq;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class KClosestPointsTest {

    @Test
    void testSolveCase01() {
        var givenPoints = List.of(
                List.of(1, 1),
                List.of(2, 2),
                List.of(3, 3));

        var expectedPoints = List.of(
                List.of(1, 1));

        var actualPoints = KClosestPoints.solve(givenPoints, 1);

        assertEquals(expectedPoints, actualPoints);
    }
}
