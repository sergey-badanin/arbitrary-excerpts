package io.bsy.backtracking;

import org.junit.jupiter.api.Test;

public class ZigZagLevelTraversalTest {

    @Test
    void testZigZagTraversal() {
        var treeString = "1 2 4 x 7 x x 5 x 8 x x 3 x 6 x x";
        var tree = BinaryTree.buildTree(treeString);

        var traversal = new ZigZagLevelTraversal();
        var levels = traversal.zigZagTraversal(tree);

        System.out.println("[");
        for (var level : levels) {

            var builder = new StringBuilder();
            builder.append("[");
            for (var val : level) {
                builder.append(" " + val);
            }
            builder.append(" ]");
            System.out.println(builder.toString());
        }
        System.out.println("]");
    }
}
