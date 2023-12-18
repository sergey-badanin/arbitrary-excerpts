package io.bsy.backtracking;

import org.junit.jupiter.api.Test;

public class ParanthesesTest {

    @Test
    void testGenerateOnePair() {
        var generator = new Parantheses();

        var actual = generator.generate(1);
        System.out.println("[");
        for (var parantheses : actual) {
            System.out.println("\t" + parantheses);
        }
        System.out.println("]");
    }

    @Test
    void testGenerateTwoPairs() {
        var generator = new Parantheses();

        var actual = generator.generate(2);
        System.out.println("[");
        for (var parantheses : actual) {
            System.out.println("\t" + parantheses);
        }
        System.out.println("]");
    }

    @Test
    void testGenerateThreePairs() {
        var generator = new Parantheses();

        var actual = generator.generate(3);
        System.out.println("[");
        for (var parantheses : actual) {
            System.out.println("\t" + parantheses);
        }
        System.out.println("]");
    }

    @Test
    void testGenerateFourPairs() {
        var generator = new Parantheses();

        var actual = generator.generate(4);
        System.out.println("[");
        for (var parantheses : actual) {
            System.out.println("\t" + parantheses);
        }
        System.out.println("]");
    }
}
