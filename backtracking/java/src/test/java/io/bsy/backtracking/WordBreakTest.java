package io.bsy.backtracking;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class WordBreakTest {

    @Test
    void testResolve01() {
        var wordBreak = new WordBreak();

        var givenTarget = "algomonster";
        var givenWords = List.of("algo", "monster");

        assertTrue(wordBreak.resolve(givenTarget, givenWords));
    }

    @Test
    void testResolve02() {
        var wordBreak = new WordBreak();

        var givenTarget = "aab";
        var givenWords = List.of("a", "c");

        assertFalse(wordBreak.resolve(givenTarget, givenWords));
    }

}
