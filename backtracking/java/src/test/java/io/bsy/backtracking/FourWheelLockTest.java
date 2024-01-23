package io.bsy.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class FourWheelLockTest {

    @Test
    void testNumSteps01() {

        var givenTarget = "0202";
        var givenTraps = List.of("0201", "0101", "0102", "1212", "2002");

        var actualHops = FourWheelLock.numSteps(givenTarget, givenTraps);
        assertEquals(6, actualHops);
    }

}
