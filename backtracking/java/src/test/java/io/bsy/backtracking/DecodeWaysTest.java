package io.bsy.backtracking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DecodeWaysTest {

    @Test
    void testDecodeWays01() {
        var given = "18";

        var decoder = new DecodeWays();

        assertEquals(2, decoder.decodeWays(given));
    }

    @Test
    void testDecodeWays02() {
        var given = "123";

        var decoder = new DecodeWays();

        assertEquals(3, decoder.decodeWays(given));
    }
}
