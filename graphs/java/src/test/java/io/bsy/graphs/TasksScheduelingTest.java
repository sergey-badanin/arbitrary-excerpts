package io.bsy.graphs;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TasksScheduelingTest {

    @Test
    void testTaskScheduling01() {
        var givenTasks = List.of("a", "b", "c", "d");
        var givenRequirements = List.of(
                List.of("a", "b"),
                List.of("c", "b"),
                List.of("b", "d"));

        var actualSchedule = TasksSchedueling.taskScheduling(givenTasks, givenRequirements);

        System.out.print("[");
        for (var task : actualSchedule) {
            System.out.print(" " + task + ", ");
        }
        System.out.println("]");

    }

}
