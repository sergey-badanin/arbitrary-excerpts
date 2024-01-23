package io.bsy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesTest {

    @Test
    void testRemoveDuplicates01() {
        List<Integer> given = List.of(0, 0, 1, 1, 1, 2, 2);
        given = new ArrayList<>(given);

        var actualSize = RemoveDuplicates.removeDuplicates(given);

        assertEquals(3, actualSize);
    }

    @Test
    void testRemoveDuplicates02() {
        List<Integer> given = List.of(0, 0);
        given = new ArrayList<>(given);

        var actualSize = RemoveDuplicates.removeDuplicates(given);

        assertEquals(1, actualSize);
    }

}
