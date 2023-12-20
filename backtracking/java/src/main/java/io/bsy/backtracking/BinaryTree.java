package io.bsy.backtracking;

import java.util.Arrays;
import java.util.Iterator;

public class BinaryTree {

    public static Node<Integer> buildTree(String input) {
        var tokensIterator = Arrays.asList(input.split(" ")).iterator();
        return dfsBuild(tokensIterator);
    }

    private static Node<Integer> dfsBuild(Iterator<String> tokensIterator) {
        if (!tokensIterator.hasNext()) {
            return null;
        }
        var next = tokensIterator.next();
        if ("x".equals(next)) {
            return null;
        }

        var val = Integer.parseInt(next);
        var node = new Node<Integer>(val);

        node.left = dfsBuild(tokensIterator);
        node.right = dfsBuild(tokensIterator);

        return node;
    }

    public static class Node<T> {

        public Node(T val) {
            this.val = val;
        }

        public T val;
        public Node<T> left;
        public Node<T> right;
    }
}
