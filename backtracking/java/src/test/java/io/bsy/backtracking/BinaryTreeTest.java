package io.bsy.backtracking;

import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    
    @Test
    public void testBuildTreeInteger01() {
        var given = "1 2 3 x x x 6 x x";

        var tree = BinaryTree.buildTree(given);

        System.out.println("    " + tree.val);
        System.out.println("   " + tree.left.val);
        System.out.println("  " + tree.left.left.val);
        System.out.println("" + tree.left.left.left);
    }
}
