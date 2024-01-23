package io.bsy.graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SequenceReconstructionTest {

    @Test
    void testSequenceReconstruction01() {

        var original = List.of(1, 2, 3);
        var seqs = List.of(
                List.of(1, 2),
                List.of(1, 3));

        assertFalse(SequenceReconstruction.sequenceReconstruction(original, seqs));
    }

    @Test
    void testSequenceReconstruction02() {

        var original = List.of(1, 2, 3);
        var seqs = List.of(
                List.of(1, 2));

        assertFalse(SequenceReconstruction.sequenceReconstruction(original, seqs));
    }

    @Test
    void testSequenceReconstruction03() {

        var original = List.of(1, 2, 3);
        var seqs = List.of(
                List.of(1, 2),
                List.of(1, 3),
                List.of(2, 3));

        assertTrue(SequenceReconstruction.sequenceReconstruction(original, seqs));
    }

    @Test
    void testSequenceReconstruction04() {

        var original = List.of(4, 1, 5, 2, 6, 3);
        var seqs = List.of(
                List.of(5, 2, 6, 3),
                List.of(4, 1, 5, 2));

        assertTrue(SequenceReconstruction.sequenceReconstruction(original, seqs));
    }

}
